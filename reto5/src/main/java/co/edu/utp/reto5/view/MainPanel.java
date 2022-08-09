package co.edu.utp.reto5.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import co.edu.utp.reto5.controller.ReportsController;
import co.edu.utp.reto5.model.dao.Report;

public class MainPanel extends ReportView {
	private static final long serialVersionUID = 1L;
	private JComboBox<Object> infoMainSelect;
	private JButton infoMainButton;
	private JButton searchButton;
		
	public MainPanel() {
		 addComponentsToPane();
	}
		
	private void addComponentsToPane() {
	   setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
	   
	   // Background Image Panel
       var img = new JPanel();
       img.setBackground(Color.blue);
       img.setPreferredSize(new Dimension(700,600));
       
       // Info Panel: 
       var info = new JPanel();
       info.setBackground(Color.white);
       info.setLayout(new BoxLayout(info,BoxLayout.Y_AXIS));
       info.setPreferredSize(new Dimension(300,600));
             
       var infoMain = new JPanel();
       infoMain.setOpaque(false);
       infoMain.setLayout(new FlowLayout(FlowLayout.LEFT));
       infoMain.setPreferredSize(new Dimension(300,100));
       infoMain.setBorder(
               BorderFactory.createCompoundBorder(
                   BorderFactory.createCompoundBorder(
                                   BorderFactory.createTitledBorder("INFORMES"),
                                   BorderFactory.createEmptyBorder(5,5,5,5)),
                   infoMain.getBorder()));
       
       var infoMainText = new JLabel("Seleccione Reporte: ");
       infoMainText.setPreferredSize(new Dimension(125,20));
       String options[] = {"Informe 1", "Informe 2", "Informe 3"};
       infoMainSelect = new JComboBox<Object>(options);
       infoMainSelect.setPreferredSize(new Dimension(150,20));
       infoMainButton = new JButton("Generar");
       infoMainButton.setActionCommand("generate");
             
       info.add(Box.createVerticalStrut(10));
       infoMain.add(infoMainText);
       infoMain.add(infoMainSelect);
       infoMain.add(infoMainButton);
       
       var infoOther = new JPanel();
       infoOther.setOpaque(false);
       infoOther.setLayout(new FlowLayout(FlowLayout.LEFT));
       infoOther.setPreferredSize(new Dimension(300,150));
       infoOther.setBorder(
               BorderFactory.createCompoundBorder(
                   BorderFactory.createCompoundBorder(	
                                   BorderFactory.createTitledBorder("CONSULTA LIBRE"),
                                   BorderFactory.createEmptyBorder(5,5,5,5)),
                   infoOther.getBorder()));
       var searchText = new JLabel("<html>Editor SQL: Puedes realizar consultas simples a la base de datos."
    		   					   + " Solo estan soportadas operaciones de lectura.</html>");
       searchText.setPreferredSize(new Dimension(265,50));
       searchText.setFont( new Font("Verdana",Font.PLAIN,12));
       searchButton = new JButton("Nueva Consulta");
       searchButton.setActionCommand("freeSearch");
       
       infoOther.add(searchText);
       info.add(Box.createVerticalStrut(10));
       infoOther.add(searchButton);
       
       info.add(Box.createVerticalStrut(30));
       info.add(infoMain);
       info.add(Box.createVerticalStrut(10));
       info.add(infoOther);
       info.add(Box.createVerticalStrut(300));
       
       add(img);
       add(info);
    }
	
	    /*  
    private void addImage(String src, Container container, String layout) {
        ImageIcon icon = new ImageIcon(src);
        JLabel img = new JLabel(icon);
        img.setPreferredSize(new Dimension(300,600));
        container.add(img);
    }
    */
	
	@Override
	public Report getReport() {
		String rep = (String) infoMainSelect.getSelectedItem();
		switch(rep) {
		case "Informe 1": return Report.First;
		case "Informe 2": return Report.Second;
		case "Informe 3": return Report.Third;
		default: return Report.None;
		}
	}
	
	@Override
	public void setController(ReportsController controller) {
		infoMainButton.addActionListener(controller);
		searchButton.addActionListener(controller);
	}

	@Override
	public void showOutput(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return "";
	}
	
	
}
