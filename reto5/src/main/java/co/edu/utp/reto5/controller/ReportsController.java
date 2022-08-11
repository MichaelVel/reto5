package co.edu.utp.reto5.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import co.edu.utp.reto5.model.dao.*;
import co.edu.utp.reto5.view.*;

public class ReportsController implements ActionListener, ItemListener{
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
				String query = model.getQuery(Report.FreeSearch);
				window.getView().setQuery(query);
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
			new SchemaView();
			break;
		case ViewEditor:
			String rep = window.getView().getReportName();
			window.changePanel(new SearchView());
			String query = model.getQuery(getTypeReport(rep));
			window.getView().setQuery(query);
			setController();
			break;
		case None:
			break;
		
		}
        
    }
	
	private Report getTypeReport(String name) {
		if (name.contains("1")) { return Report.First;  } 
		if (name.contains("2")) { return Report.Second; } 
		if (name.contains("3")) { return Report.Third;  } 
		return Report.FreeSearch;
	}
	
	private Action getAction(String action) {
		switch(action) {
			case "back": return Action.Back;
			case "freeSearch": return Action.FreeSearch;
			case "generate": return Action.GenerateReport;
			case "schema": return Action.RelationalSchema;
			case "editor": return Action.ViewEditor;
			default: return Action.None;
		}
	}
	
	public void setController() {
	        window.getView().setController(this);
	    }

	@Override
	public void itemStateChanged(ItemEvent e) {
		// Specific to InfoPanel, if more items events where added this code should be refactor 
		// to reflect the change. 
		if (e.getStateChange() == ItemEvent.DESELECTED) {
			return;
		}
		
		InfoPanel panel = (InfoPanel) window.getView();
		String currentReport = (String) e.getItem();
		
		String viewReportName = panel.getReportName().toLowerCase();
		if (viewReportName.contains(currentReport.toLowerCase())) { // Not redraw the current report
			return;
		}
		
		Report report = Report.None;
		String reportName = "";
		switch(currentReport) {
			case "Reportes":
				return;
			case "Informe 1": 
				report = Report.First;
				reportName = "INFORME 1: LIDERES";
				break;
			case "Informe 2": 
				report = Report.Second;
				reportName = "INFORME 2: PROYECTOS";
				break;
			case "Informe 3": 
				report = Report.Third;
				reportName = "INFORME 3: COMPRAS";
				break;
			default:
				break;
		}
		panel.redrawTable(model.getReport(report));
		panel.redrawTitle(reportName);
	}	

}
