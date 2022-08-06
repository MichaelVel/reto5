package co.edu.utp.reto5.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.utp.reto5.controller.ReportsController;

public class MainView implements ReportView  {
	
	public static void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
        
        JPanel image = new JPanel();
        image.setLayout(new BoxLayout(image,BoxLayout.Y_AXIS));
        addImage("img/test.png", image);
       
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info,BoxLayout.Y_AXIS));
        addPanel("INFORMES",info);
        addPanel("CONSULTA LIBRE",info);
        
        pane.add(image);
        pane.add(info);
    }

    private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }
    
    private static void addImage(String src, Container container) {
        ImageIcon icon = new ImageIcon(src);
        container.add(new JLabel(icon));
    }
    
    private static void addPanel(String name, Container container) {
    	JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(
                BorderFactory.createCompoundBorder(
                    BorderFactory.createCompoundBorder(
                                    BorderFactory.createTitledBorder(name),
                                    BorderFactory.createEmptyBorder(5,5,5,5)),
                    panel.getBorder()));
        
        addAButton("Button 4", panel);
        addAButton("Button 3", panel);
        container.add(panel);
    }
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("MinTic:Reto 5");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

	@Override
	public void iniciar(ReportsController controller) {
		// TODO Auto-generated method stub
		
	}
}
