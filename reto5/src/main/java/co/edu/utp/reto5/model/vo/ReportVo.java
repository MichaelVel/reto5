package co.edu.utp.reto5.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ReportVo {
	public void setValues(ResultSet rs) throws SQLException;
	
	public Object[] getData();
	
	public Object[] getNames();
	
}
