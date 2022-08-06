package co.edu.utp.reto4.model.vo;

public class ProyectoBancoVo {
	int id;
	String constructora;
	String ciudad;
	String clasificacion;
	int estrato;
	String lider;
	
	public ProyectoBancoVo(int id, String constr, String ciudad, String clasif, int estr, String lid) {
		this.id = id;
		this.constructora = constr;
		this.ciudad = ciudad;
		this.clasificacion = clasif;
		this.estrato = estr;
		this.lider = lid;
	}
	
	public String toString() {
		return String.format(
				"%3d %-25s %-20s %-15s %7d %-30s",
				id, constructora, ciudad, clasificacion, estrato, lider);
	}
}
