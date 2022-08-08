package co.edu.utp.reto5.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.utp.reto5.controller.ReportsController;
import co.edu.utp.reto5.model.dao.Report;

public class MainPanel extends ReportView {
	private static final long serialVersionUID = 1L;
	private JComboBox<Object> infoMainSelect;
	private JButton infoMainButton;
		
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
       infoMain.setPreferredSize(new Dimension(300,200));
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
             
       infoMain.add(space(300,15));
       infoMain.add(infoMainText);
       infoMain.add(infoMainSelect);
       infoMain.add(infoMainButton);
       
       var infoOther = new JPanel();
       infoOther.setOpaque(false);
       infoOther.setPreferredSize(new Dimension(300,200));
       infoOther.setBorder(
               BorderFactory.createCompoundBorder(
                   BorderFactory.createCompoundBorder(	
                                   BorderFactory.createTitledBorder("CONSULTA LIBRE"),
                                   BorderFactory.createEmptyBorder(5,5,5,5)),
                   infoOther.getBorder()));
       
       info.add(space(300,95));
       info.add(infoMain);
       info.add(space(300,10));
       info.add(infoOther);
       info.add(space(300,95));
       
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
	}
	
	
}
