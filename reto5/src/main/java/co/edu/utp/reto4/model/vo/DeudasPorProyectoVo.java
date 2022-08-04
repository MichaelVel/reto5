package co.edu.utp.reto4.model.vo;

public class DeudasPorProyectoVo {
	int id;
	double valor;
	
	public DeudasPorProyectoVo(int id, double valor) {
		this.id = id;
		this.valor = valor;
	}
	
	public String toString() {
		return String.format("%3d %,15.1f", id, valor);
	}
}
