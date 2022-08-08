package co.edu.utp.reto5.view;

import javax.swing.JFrame;

public class MainView extends JFrame  {
	private static final long serialVersionUID = 1L;
			
	public MainView(ReportView view) {
		setTitle("MinTic:Reto 5");
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	add(view);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
		
	public void changePanel(ReportView view) {
		var contentPane = getContentPane();
		contentPane.removeAll();
        contentPane.add(view);
        validate();
        setVisible(true);
	}
	
	public ReportView getView() {
		return (ReportView) getContentPane().getComponent(0);
	}
	
}
