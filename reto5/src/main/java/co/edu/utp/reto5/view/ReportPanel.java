package co.edu.utp.reto5.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.utp.reto5.controller.ReportsController;
import co.edu.utp.reto5.model.dao.Report;

public abstract class ReportPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	protected int xButtonSize = 130;
	protected int yButtonSize = 25;
	
	public abstract void setController(ReportsController controller);
	
	// Utility methods
	public JPanel space(int x, int y, Color col) {
		var panel = new JPanel();
		panel.setBackground(col);
		panel.setPreferredSize(new Dimension(x,y));
		return panel;
	}
		
	public String getViewName() {
		return this.getClass().getSimpleName();
	}
	
	public JButton makeButton(String name, String actionCommand, int x, int y) {
		var button = new JButton(name);
		button.setActionCommand(actionCommand);
		button.setPreferredSize(new Dimension(x,y));
		return button;
	}
	
		
	// This methods are only used by some derived classes which override them. Is not worth make them
	// abstract.
	
	public Report getReport() { return Report.None; }
	
	public void showOutput(String text) { }
	
	public String getReportName() { return ""; }
	
	public String getQuery() { return ""; }
	
	public void setQuery(String text) {	}
}
