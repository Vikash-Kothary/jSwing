package pracoursework;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import GUIClasses.*;

public class mainWindow {
	
	
	public static void main(String[] args){
		final jFrame mainWindow = new jFrame("Welcome Screen", 800, 600); //creates Main Window(Title, width, height)

		//Outermost JPanel container
		final jPanel panelCollection = new jPanel();
		panelCollection.setLayout(new BorderLayout());
		
		//Adds interactive JPanels
		final jPanel scrollStudents = new jPanel();
		final jPanel displayPanel = new jPanel();
		final jPanel topPanel = new jPanel();
		//topPanel.setLayout(new GridLayout(1,1));
		final jPanel bottomPanel = new jPanel();
		
		panelCollection.add(scrollStudents, BorderLayout.WEST);
		bottomPanel.add(displayPanel,BorderLayout.EAST);
		panelCollection.add(topPanel,BorderLayout.NORTH);
		
		String[] students = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", };
		JScrollPane studentList = scrollStudents.addTextArea(students, new Rectangle(250,200,100,100),false);
		
		String[] menuComponents = {"File","Edit","View", "Help",};
		JMenuBar mainMenu = topPanel.addMenuBar(menuComponents);
		
		mainWindow.background(panelCollection.getPanel());
	
	}
}
