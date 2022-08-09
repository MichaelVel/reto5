package co.edu.utp.reto5.model.dao;

public class InvalidQueryException extends Exception {
	private static final long serialVersionUID = 1L;
	String msg;
	
	public InvalidQueryException(String msg) {
		 super(msg);
	}	
	
}
