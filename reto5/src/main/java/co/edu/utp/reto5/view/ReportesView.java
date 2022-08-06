package co.edu.utp.reto4.view;

import co.edu.utp.reto4.model.dao.*;

public class ReportesView {
	private String repitaCaracter(Character ch, Integer n) {
		String res = "";
		for (int i = 0; i < n; i++) {
			res += ch;
		}
		return res; 
	}
	
	public void proyectosFinanciadosPorBanco(String banco) {
		System.out.println(repitaCaracter('=', 36) 
				+ " LISTADO DE PROYECTOS POR BANCO "
				+ repitaCaracter('=', 37));
		
		if (banco != null && !banco.isBlank()) {
			System.out.println(String.format(
			"%3s %-25s %-20s %-15s %-7s %-30s",
			"ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
			System.out.println(repitaCaracter('-', 105));
			
			var pb = new ProyectosBancoDao();
			for (var proyecto:  pb.getProyects(banco)) {
				System.out.println(proyecto);
			}
		}
	}
	
	public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) {
		System.out.println(repitaCaracter('=', 1) 
				+ " TOTAL DEUDAS POR PROYECTO "
				+ repitaCaracter('=', 1));
		
		if (limiteInferior != null) {
			System.out.println(String.format("%3s %15s", "ID", "VALOR "));
			System.out.println(repitaCaracter('-', 29));
			
			var pb = new DeudasPorProyectoDao();
			for (var deuda:  pb.getDebts(limiteInferior)) {
				System.out.println(deuda);
			}
		}
	}

	public void lideresQueMasGastan() {
		System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
				+ repitaCaracter('=', 7));
		System.out.println(String.format("%-25s %15s", "LIDER", "VALOR "));
		System.out.println(repitaCaracter('-', 41));
		
		var pb = new ComprasDeLiderDao();
		for (var lider:  pb.getLiderBills()) {
			System.out.println(lider);
		}
	}
}