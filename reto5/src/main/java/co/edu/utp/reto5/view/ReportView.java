package co.edu.utp.reto5.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.utp.reto5.controller.ReportsController;
import co.edu.utp.reto5.model.dao.Report;

public abstract class ReportView extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public abstract void setController(ReportsController controller);
	
	public abstract Report getReport();
		
	public abstract String getQuery();
	
	public abstract void showOutput(String text);
	
	public JPanel space(int x, int y) {
		var panel = new JPanel();
		panel.setOpaque(false);
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
	
}
