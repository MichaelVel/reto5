package co.edu.utp.reto5.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.utp.reto5.model.vo.*;
import co.edu.utp.reto5.util.JDBCUtilities;

public class ReportDao {
		
	public ArrayList<ReportVo> getReport(Report rep) {
		var reportEntrys = new ArrayList<ReportVo>();
		
		String query;
		ReportVo reportEntry;
		switch(rep) {
			case First:
				reportEntry = new Lider();
				query = "SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia \n"
						+ "FROM Lider l ORDER BY Ciudad_Residencia;";
				
				break;
			case Second:
				reportEntry = new Proyecto();
				query = "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad \n"
						+ "FROM Proyecto p\n"
						+ "WHERE Clasificacion ='Casa Campestre' AND \n"
						+ "	Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla')\n"
						+ "ORDER BY Ciudad;";
				break;
			default:
				reportEntry = new Compra();
				query = "SELECT  ID_Compra, Constructora, Banco_Vinculado \n"
						+ "FROM Compra c JOIN Proyecto p USING(ID_Proyecto)\n"
						+ "WHERE Proveedor = 'Homecenter' AND p.Ciudad='Salento'\n"
						+ "ORDER BY Constructora;";
				break;
		}
				
		try (Connection conn = JDBCUtilities.getConnection();
			 Statement stm = conn.createStatement();
			 ResultSet rs = stm.executeQuery(query);
			 ) {
			while (rs.next()) {
				reportEntry.setValues(rs);
				reportEntrys.add(reportEntry);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reportEntrys;
	}


}
