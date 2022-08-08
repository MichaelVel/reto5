package co.edu.utp.reto5.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Lider implements ReportVo {
	int id;
	String nombre;
	String apellido;
	String ciudad;
	
	@Override
	public void setValues(ResultSet rs) throws SQLException {
		this.id = rs.getInt("ID_Lider");
		this.nombre =rs.getString("Nombre");
		this.apellido = rs.getString("Primer_Apellido");
		this.ciudad =rs.getString("Ciudad_Residencia");
	}

	@Override
	public Object[] getData() {
		Object[] data = {id, nombre, apellido, ciudad};
		return data;
	}

	@Override
	public Object[] getNames() {
		Object[] names = {"ID", "Nombre", "Apellido", "Ciudad Residecia"};
		return names;
	}
	
	public String toString() {
		return id + " " + nombre +" " + apellido + " " + ciudad; 
	}
	
}
