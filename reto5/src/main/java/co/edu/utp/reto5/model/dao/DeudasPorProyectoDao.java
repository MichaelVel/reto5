package co.edu.utp.reto4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.utp.reto4.model.vo.DeudasPorProyectoVo;
import co.edu.utp.reto4.util.JDBCUtilities;

public class DeudasPorProyectoDao {
	public static String query = 
			"SELECT ID_Proyecto, SUM(Precio_Unidad * Cantidad) AS VALOR\n"
			+ "FROM  Compra INNER JOIN MaterialConstruccion USING(ID_MaterialConstruccion)\n"
			+ "WHERE Pagado = 'No'\n"
			+ "GROUP BY ID_Proyecto\n"
			+ "HAVING VALOR > ?\n"
			+ "ORDER BY VALOR DESC;";
	
	public ArrayList<DeudasPorProyectoVo> getDebts(double val) {
		var debts = new ArrayList<DeudasPorProyectoVo>();
		
		try (Connection conn = JDBCUtilities.getConnection();
			PreparedStatement pstm = conn.prepareStatement(query);
			 ) {
			pstm.setDouble(1,val);
			try (ResultSet rs = pstm.executeQuery()) {
				while (rs.next()) {
					debts.add(new DeudasPorProyectoVo(
							rs.getInt("ID_Proyecto"),
							rs.getDouble("VALOR")
							));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return debts;
	}
}
