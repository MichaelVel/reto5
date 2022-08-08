package co.edu.utp.reto5.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Proyecto implements ReportVo {
	int id;
	String constructora;
	int nHabitaciones;
	String ciudad;
	
	@Override
	public void setValues(ResultSet rs) throws SQLException {
		this.id = rs.getInt("ID_Proyecto");
		this.constructora =rs.getString("Constructora");
		this.nHabitaciones = rs.getInt("Numero_Habitaciones");
		this.ciudad =rs.getString("Ciudad");
		
	}

	@Override
	public Object[] getData() {
		Object[] data = {id, constructora, nHabitaciones, ciudad};
		return data;
	}

	@Override
	public Object[] getNames() {
		Object[] names = {"ID", "Constructora", "Numero Habitaciones", "Ciudad"};
		return names;
	}
	
	
}
