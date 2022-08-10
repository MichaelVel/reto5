package co.edu.utp.reto5.model.dao;

import java.util.regex.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.utp.reto5.model.vo.*;
import co.edu.utp.reto5.util.JDBCUtilities;

public class ReportDao {
	private static final String QUERY1 = 
			"SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia \n"
					+ "FROM Lider l ORDER BY Ciudad_Residencia;";
	private static final String QUERY2 = 
			"SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad \n"
					+ "FROM Proyecto p\n"
					+ "WHERE Clasificacion ='Casa Campestre' AND \n"
					+ "	Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla')\n"
					+ "ORDER BY Ciudad;";
	private static final String QUERY3 = 
			 "SELECT  ID_Compra, Constructora, Banco_Vinculado \n"
						+ "FROM Compra c JOIN Proyecto p USING(ID_Proyecto)\n"
						+ "WHERE Proveedor = 'Homecenter' AND p.Ciudad='Salento'\n"
						+ "ORDER BY Constructora;";
	
	private String customQuery = "";
	
	public ArrayList<ReportVo> getReport(Report rep) {
		var reportEntrys = new ArrayList<ReportVo>();
		
		String query = getQuery(rep);	
		try (Connection conn = JDBCUtilities.getConnection();
			 Statement stm = conn.createStatement();
			 ResultSet rs = stm.executeQuery(query);
			 ) {
			while (rs.next()) {
				ReportVo reportEntry;
				switch(rep) {
				case First:
					reportEntry = new Lider();
					break;
				case Second:
					reportEntry = new Proyecto();
					break;
				default:
					reportEntry = new Compra();
					break;
				}
				reportEntry.setValues(rs);
				reportEntrys.add(reportEntry);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reportEntrys;
	}
	
	public ArrayList<ReportVo> getReport(String query) throws InvalidQueryException {
		var reportEntrys = new ArrayList<ReportVo>();
		
		if (query.isEmpty()) {
			throw new InvalidQueryException("Realiza una consulta.");
		}
		
		Pattern pattern = Pattern.compile("insert|delete|create");
		Matcher matcher = pattern.matcher(query.toLowerCase());
		if (matcher.find()) {
			throw new InvalidQueryException("Operacion Invalida: Base de datos de solo lectura.");
		}
				
		try (Connection conn = JDBCUtilities.getConnection();
				 Statement stm = conn.createStatement();
				 ResultSet rs = stm.executeQuery(query);
				 ) {
				while (rs.next()) {
					ReportVo reportEntry = new FreeSearch();
					reportEntry.setValues(rs);
					reportEntrys.add(reportEntry);
				}
			} catch (SQLException e) {
				throw new InvalidQueryException("SQL Error: " + e.getMessage());
			}
		
		this.customQuery = query; 
		return reportEntrys;
	}
	
	public String getQuery(Report rep) {
		switch(rep) {
		case First:  return QUERY1;
		case Second: return QUERY2;
		case Third:  return QUERY3;
		default: 	 return customQuery;
	}
	}

}
