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
			window.changePanel(new MainPanel());
			setController();
			break;
		case FreeSearch:
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
				default: break;
			}
			window.changePanel(new InfoPanel(model.getReport(report),reportName));
			setController();
			break;
		case RelationalSchema:
			break;
		case None:
			break;
		}
        
    }
	
	private Action getAction(String action) {
		//System.out.println(action);
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
