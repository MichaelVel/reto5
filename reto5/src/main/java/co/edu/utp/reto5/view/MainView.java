package co.edu.utp.reto5.view;

import java.awt.Color;

import javax.swing.JFrame;

public class MainView extends JFrame  {
	private static final long serialVersionUID = 1L;
	public static final Color PRIMARY_COLOR = new Color(59, 99, 172);
	public static final Color SECONDARY_COLOR = new Color(232, 50, 101);
			
	public MainView(ReportPanel view) {
		setTitle("MinTic:Reto 5");
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	add(view);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
		
	public void changePanel(ReportPanel view) {
		var contentPane = getContentPane();
		contentPane.removeAll();
        contentPane.add(view);
        validate();
        setVisible(true);
	}
	
	public ReportPanel getView() {
		return (ReportPanel) getContentPane().getComponent(0);
	}
	
}
