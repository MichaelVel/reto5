package co.edu.utp.reto5.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.edu.utp.reto5.controller.ReportsController;
import co.edu.utp.reto5.model.dao.Report;
import co.edu.utp.reto5.model.vo.ReportVo;

public class InfoPanel extends ReportView  {
	private static final long serialVersionUID = 1L;
	private String reportName;
	private ArrayList<ReportVo> reportInfo;
	private JButton returnButton;
	
	public InfoPanel(ArrayList<ReportVo> info, String name) {
		reportName = name;
		reportInfo = info;
		addComponentsToPanel();
	}
	
		
	private void addComponentsToPanel() {
	   setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	   
       var header = new JPanel();
       header.setBackground(Color.blue);
       header.setPreferredSize(new Dimension(1000,100));
       var headerTitle = new JLabel(reportName);
       headerTitle.setForeground(Color.white);
       headerTitle.setFont( new Font("Verdana",Font.BOLD,30));
       header.add(space(1000,15));
       header.add(headerTitle);
       
       var main = new JPanel();
       main.setBackground(Color.white);
       main.setPreferredSize(new Dimension(1000,500));
             
       var mainTable = new JScrollPane(makeTable());
       mainTable.setPreferredSize(new Dimension(800,400));
      
       var mainExtra = new JPanel();
       mainExtra.setPreferredSize(new Dimension(800,50));
       mainExtra.setOpaque(false);
       mainExtra.setLayout(new FlowLayout(FlowLayout.RIGHT));
       returnButton = new JButton("Regresar");
       returnButton.setActionCommand("back");
       mainExtra.add(returnButton);
       
       main.add(mainTable);
       main.add(mainExtra);
       
       add(header);
       add(main);
    }
	
	private JTable makeTable() {
		var names = reportInfo.get(1).getNames();
		var data = reportInfo.stream().map(x -> x.getData()).collect(Collectors.toList());
		Object[][] dataArray = data.toArray(new Object[0][0]);
		return new JTable(dataArray,names);
	}
	
	@Override
	public void setController(ReportsController controller) {
			returnButton.addActionListener(controller);
	}

	@Override
	public Report getReport() {
		return Report.None;
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
