package co.edu.utp.reto5.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class FreeSearch implements ReportVo {
	LinkedHashMap<String,String> data;
	
	
	public FreeSearch() {
		data = new LinkedHashMap<String,String>();
	}
	@Override
	public void setValues(ResultSet rs) throws SQLException {
		var dbmeta = rs.getMetaData();
		
		for (int i = 1; i<= dbmeta.getColumnCount();i++) {
			data.put(dbmeta.getColumnName(i),rs.getString(i));
		}
		
	}

	@Override
	public Object[] getData() {
		Object[] d = new String[data.size()];
		
		int i=0;
		for (Map.Entry<String, String> mapElement : data.entrySet()) {
			d[i] = mapElement.getValue();
			i++;
		}	
		return d;
	}

	@Override
	public Object[] getNames() {
		Object[] d = new String[data.size()];
		
		int i=0;
		for (Map.Entry<String, String> mapElement : data.entrySet()) {
			d[i] = mapElement.getKey();
			i++;
		}	
		return d;
	}
	
	
}
