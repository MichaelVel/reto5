package co.edu.utp.reto5.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SchemaView extends JFrame  {
	private static final long serialVersionUID = 1L;
		
	public SchemaView() {
		setTitle("Esquema Relacional");
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	ImageIcon icon = new ImageIcon("img/schema.png");
        JLabel imgContent = new JLabel(icon);
        add(imgContent);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
