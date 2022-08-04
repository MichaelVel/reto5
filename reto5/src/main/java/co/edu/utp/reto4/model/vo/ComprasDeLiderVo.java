package co.edu.utp.reto4.model.vo;

public class ComprasDeLiderVo {
	String lider;
	double valor;
	
	public ComprasDeLiderVo(String lid, double val) {
		this.lider = lid;
		this.valor = val;
	}
	
	public String toString() {
		return String.format("%-25s %,15.1f", lider, valor);

	}
}
