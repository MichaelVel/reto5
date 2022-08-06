package co.edu.utp.reto5.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import co.edu.utp.reto5.model.dao.*;
import co.edu.utp.reto5.view.*;

public class ReportsController implements ActionListener{
	Action action;
	ReportView currentView;
	ReportDao model;
	
	public ReportsController() {
		this.currentView = new MainView();
		this.model = new ReportDao();
	}
	
	public void setAction(Action action) {
		this.action = action;
	}
	public void setView(ReportView view) {
		this.currentView = view;
	}
		
	@Override
    public void actionPerformed(ActionEvent e) {
		switch (action) {
		case Back:
			break;
		case FreeSearch:
			break;
		case GenerateReport:
			break;
		case RelationalSchema:
			break;
		default:
			break;
		}
        
    }
		
	public void showCurrentView() {
	        currentView.iniciar(this);
	    }

}
