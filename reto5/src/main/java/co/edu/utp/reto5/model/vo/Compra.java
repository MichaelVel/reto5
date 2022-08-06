package co.edu.utp.reto5.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Compra implements ReportVo{
	int id;
	String constructora;
	String bancoVinculado;
	
	@Override
	public void setValues(ResultSet rs) throws SQLException {
		this.id = rs.getInt("ID_Compra");
		this.constructora =rs.getString("Constructora");
		this.bancoVinculado = rs.getString("Banco_Vinculado");
		
	}
}
