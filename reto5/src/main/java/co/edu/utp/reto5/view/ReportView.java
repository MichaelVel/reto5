package co.edu.utp.reto5.view;

import java.awt.Dimension;

import javax.swing.JPanel;

import co.edu.utp.reto5.controller.ReportsController;
import co.edu.utp.reto5.model.dao.Report;

public abstract class ReportView extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public abstract void setController(ReportsController controller);
	
	public abstract Report getReport();
	
	public JPanel space(int x, int y) {
		var panel = new JPanel();
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(x,y));
		return panel;
	}

	
}
