package co.edu.utp.reto5.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import co.edu.utp.reto5.controller.ReportsController;
import co.edu.utp.reto5.model.dao.Report;
import co.edu.utp.reto5.model.vo.ReportVo;

public class SearchView extends ReportPanel  {
	private static final long serialVersionUID = 1L;
	
	private String defaultMssg = "Realiza una consulta.";
		
	private JButton returnButton;
	private JButton generateButton;
	private JButton schemaButton;
	private JTextArea editor;
	private JTextArea console;

	public SearchView() {
		addComponentsToPanel();
	}
		
	private void addComponentsToPanel() {
	   setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	   setBackground(Color.white);
	   
       var header = new JPanel();
       header.setBackground(MainView.PRIMARY_COLOR);
       header.setPreferredSize(new Dimension(1000,100));
       var headerTitle = new JLabel("CONSULTA LIBRE");
       headerTitle.setForeground(Color.white);
       headerTitle.setFont( new Font("Verdana",Font.BOLD,30));
       header.add(space(1000,15, MainView.PRIMARY_COLOR));
       header.add(headerTitle);
       
       
       var main = new JPanel();
       main.setBackground(Color.white);
       main.setPreferredSize(new Dimension(1000,500));
       main.setLayout(new BoxLayout(main,BoxLayout.X_AXIS));
              
       var mainConsole = new JPanel();
       mainConsole.setLayout(new FlowLayout(FlowLayout.RIGHT));
       mainConsole.setPreferredSize(new Dimension(750,500));
       mainConsole.setOpaque(false);
       
       this.editor = new JTextArea();
       editor.setFont(new Font("Serif", Font.PLAIN, 13));
       editor.setLineWrap(true);
       editor.setWrapStyleWord(true);
       JScrollPane editorScrollPane = new JScrollPane(editor);
       editorScrollPane.setVerticalScrollBarPolicy(
                       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       editorScrollPane.setPreferredSize(new Dimension(650, 240));
       editorScrollPane.setBorder(
           BorderFactory.createCompoundBorder(
               BorderFactory.createCompoundBorder(
                               BorderFactory.createTitledBorder("SQL Editor"),
                               BorderFactory.createEmptyBorder(5,5,5,5)),
               editorScrollPane.getBorder()));
       
       this.console = new JTextArea(defaultMssg);
       console.setFont(new Font("Serif", Font.PLAIN, 13));
       console.setLineWrap(true);
       console.setWrapStyleWord(true);
       console.setEditable(false);
       JScrollPane consoleScrollPane = new JScrollPane(console);
       consoleScrollPane.setVerticalScrollBarPolicy(
                       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       consoleScrollPane.setPreferredSize(new Dimension(650, 150));
       consoleScrollPane.setBorder(
           BorderFactory.createCompoundBorder(
               BorderFactory.createCompoundBorder(
                               BorderFactory.createTitledBorder("Console"),
                               BorderFactory.createEmptyBorder(5,5,5,5)),
               consoleScrollPane.getBorder()));
       
       mainConsole.add(editorScrollPane);
       mainConsole.add(consoleScrollPane);
       
       var mainPanel = new JPanel();
       mainPanel.setPreferredSize(new Dimension(250,500));
       mainPanel.setOpaque(false);
       mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
       returnButton = makeButton("Regresar", "back", xButtonSize, yButtonSize);
       generateButton = makeButton("Generar", "generate", xButtonSize, yButtonSize);
       schemaButton = makeButton("Mostrar Schema", "schema", xButtonSize, yButtonSize);
       
       mainPanel.add(schemaButton);
       mainPanel.add(Box.createHorizontalStrut(80));
       mainPanel.add(generateButton);
       mainPanel.add(Box.createHorizontalStrut(80));
       mainPanel.add(returnButton);
       
       
       main.add(mainConsole);
       main.add(mainPanel);
       
       add(header);
       add(space(1000,5,MainView.SECONDARY_COLOR));
       add(Box.createVerticalStrut(25));
       add(main);
    }
	
		
	@Override
	public void setController(ReportsController controller) {
			returnButton.addActionListener(controller);
			schemaButton.addActionListener(controller);
			generateButton.addActionListener(controller);
	}
	
	@Override
	public void showOutput(String text) {
		console.setText(text);
	}
	
	@Override
	public Report getReport() {
		return Report.FreeSearch;
	}

	@Override
	public String getQuery() {
		return editor.getText();
	}

	@Override
	public void setQuery(String text) {
		editor.setText(text);
		
	}
}
