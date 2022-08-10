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

public class InfoPanel extends ReportPanel  {
	private static final long serialVersionUID = 1L;
	private String reportName;
	private String from;
	private ArrayList<ReportVo> reportInfo;
	private JButton returnButton;
	private JButton showInEditorButton;
	
	public InfoPanel(ArrayList<ReportVo> info, String name, String from) {
		this.from = from;
		reportName = name;
		reportInfo = info;
		addComponentsToPanel();
	}
	
		
	private void addComponentsToPanel() {
	   setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	   
	   // Header Section
       var header = new JPanel();
       header.setBackground(MainView.PRIMARY_COLOR);
       header.setPreferredSize(new Dimension(1000,100));
       
       var headerTitle = new JLabel(reportName);
       headerTitle.setForeground(Color.white);
       headerTitle.setFont( new Font("Verdana",Font.BOLD,30));
       header.add(space(1000,15,MainView.PRIMARY_COLOR));
       header.add(headerTitle);
       
       // Main Section
       var main = new JPanel();
       main.setBackground(Color.white);
       main.setPreferredSize(new Dimension(1000,500));
             
       var mainTable = new JScrollPane(makeTable());
       mainTable.setPreferredSize(new Dimension(800,400));
      
       var mainExtra = new JPanel();
       mainExtra.setPreferredSize(new Dimension(800,50));
       mainExtra.setOpaque(false);
       mainExtra.setLayout(new FlowLayout(FlowLayout.RIGHT));
       returnButton = makeButton("Regresar", "back", xButtonSize, yButtonSize);
       showInEditorButton = makeButton("Editor", "editor", xButtonSize, yButtonSize);
       mainExtra.add(showInEditorButton);
       mainExtra.add(returnButton);
       
       main.add(mainTable);
       main.add(mainExtra);
       
       // Set Up Panel
       add(header);
       add(space(1000,5,MainView.SECONDARY_COLOR));
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
			showInEditorButton.addActionListener(controller);
	}

	@Override
	public Report getReport() {
		return Report.None;
	}
	
	@Override
	public String getViewName() {
		return this.getClass().getSimpleName() + ":" + from;
	}
	
	@Override
	public String getReportName() {
		return this.reportName;
		}

}
