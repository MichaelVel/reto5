package co.edu.utp.reto4.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.utp.reto4.model.vo.ComprasDeLiderVo;
import co.edu.utp.reto4.util.JDBCUtilities;

public class ComprasDeLiderDao {
	public static String query = 
			"SELECT  Nombre || ' ' || Primer_Apellido || ' ' || Segundo_Apellido AS LIDER,\n"
			+ "	SUM(Precio_Unidad * Cantidad) AS VALOR\n"
			+ "FROM  Compra JOIN MaterialConstruccion USING(ID_MaterialConstruccion)\n"
			+ "	JOIN Proyecto USING(ID_Proyecto) \n"
			+ "	JOIN Lider USING(ID_Lider)\n"
			+ "GROUP BY LIDER\n"
			+ "ORDER BY VALOR DESC\n"
			+ "LIMIT 10;";
	
	public ArrayList<ComprasDeLiderVo> getLiderBills() {
		var liders = new ArrayList<ComprasDeLiderVo>();
		
		try (Connection conn = JDBCUtilities.getConnection();
			 Statement stm = conn.createStatement();
			 ResultSet rs = stm.executeQuery(query);
			 ) {
			while (rs.next()) {
				liders.add(new ComprasDeLiderVo(
						rs.getString("LIDER"),
						rs.getDouble("VALOR")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liders;
	}


}
