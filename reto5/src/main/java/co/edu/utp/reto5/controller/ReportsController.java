package co.edu.utp.reto5.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import co.edu.utp.reto5.model.dao.*;
import co.edu.utp.reto5.view.*;

public class ReportsController implements ActionListener{
	Action action;
	MainView window;
	ReportDao model;
	
	public ReportsController() {
		this.window = new MainView(new MainPanel());
		this.model = new ReportDao();
		setController();
	}
	
	public void setAction(Action action) {
		this.action = action;
	}
	
		
	@Override
    public void actionPerformed(ActionEvent e) {
		setAction(getAction(e.getActionCommand()));
		switch (action) {
		case Back:
			String viewName = window.getView().getViewName();		// In InfoView this method is overloaded to also return from 
																	// which view the report was generated
			if (viewName.equals("InfoPanel:SearchView")) {
				window.changePanel(new SearchView());
			} else {
				window.changePanel(new MainPanel());
			}
			setController();
			break;
		case FreeSearch:
			window.changePanel(new SearchView());
			setController();
			break;
		case GenerateReport:
			String reportName = "";
			var report = window.getView().getReport();
			switch(report) {
				case First:
					reportName = "INFORME 1: LIDERES";
					break;
				case Second:
					reportName = "INFORME 2: PROYECTOS";
					break;
				case Third:
					reportName = "INFORME 3: COMPRAS";
					break;
				case FreeSearch:
					String query = window.getView().getQuery();
					try {
						var info = model.getReport(query);
						window.getView().showOutput("Operacion Exitosa: Cargando resultados.");
						window.changePanel(new InfoPanel(
								info,
								"INFORME PERSONALIZADO",
								window.getView().getViewName()
								));
						setController();
					} catch (InvalidQueryException error) {
						window.getView().showOutput(error.getMessage());
					}
					return;
				default: break;
			}
			window.changePanel(new InfoPanel(
					model.getReport(report),
					reportName,
					window.getView().getViewName()));
			setController();
			break;
		case RelationalSchema:
			break;
		case None:
			break;
		}
        
    }
	
	private Action getAction(String action) {
		switch(action) {
			case "back": return Action.Back;
			case "freeSearch": return Action.FreeSearch;
			case "generate": return Action.GenerateReport;
			case "schema": return Action.RelationalSchema;
			default: return Action.None;
		}
	}
	
	public void setController() {
	        window.getView().setController(this);
	    }

}
