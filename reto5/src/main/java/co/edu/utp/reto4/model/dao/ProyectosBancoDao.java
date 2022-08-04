package co.edu.utp.reto4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.utp.reto4.model.vo.ProyectoBancoVo;
import co.edu.utp.reto4.util.JDBCUtilities;

public class ProyectosBancoDao {
	private static String query = 
	" SELECT ID_Proyecto AS ID, Constructora, Ciudad,\n"
	+ "	Proyecto.Clasificacion, Estrato,\n"
	+ "	Nombre || ' ' || Primer_Apellido || ' ' || Segundo_Apellido AS Lider\n"
	+ "FROM Proyecto \n"
	+ "	JOIN Lider USING(id_lider)\n"
	+ "	JOIN Tipo USING(id_tipo)\n"
	+ "WHERE Banco_vinculado = ?\n"
	+ "ORDER BY Fecha_Inicio DESC, Ciudad, Constructora;";
	
	public ArrayList<ProyectoBancoVo> getProyects(String bank) {
		var proyects = new ArrayList<ProyectoBancoVo>();
		
		try (Connection conn = JDBCUtilities.getConnection();
			PreparedStatement pstm = conn.prepareStatement(query);
			 ) {
			pstm.setString(1, bank);
			try (ResultSet rs = pstm.executeQuery()) {
				while (rs.next()) {
					proyects.add(new ProyectoBancoVo(
							rs.getInt("ID"),
							rs.getString("Constructora"),
							rs.getString("Ciudad"),
							rs.getString("Clasificacion"),
							rs.getInt("Estrato"),
							rs.getString("Lider")
							));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proyects;
	}
}
