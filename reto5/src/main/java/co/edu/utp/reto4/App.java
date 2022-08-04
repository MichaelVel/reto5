package co.edu.utp.reto4;

import co.edu.utp.reto4.view.*;

public class App 
{
    public static void main( String[] args )
    {
    	var reportesView = new ReportesView();
    
    	var banco = "Conavi";
        var limiteInferior = 50_000d;
    	
        reportesView.proyectosFinanciadosPorBanco(banco);
    	//reportesView.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);
    	//reportesView.lideresQueMasGastan();

    }
}
