package pracoursework;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import GUIClasses.*;

public class mainWindow {
	
	
	public static void main(String[] args){
		final jFrame mainWindow = new jFrame("Welcome Screen", 500, 600); //creates Main Window(Title, width, height)

		//Outermost JPanel container
		final jPanel panelCollection = new jPanel();
		panelCollection.setLayout(new BorderLayout());
		
		//Adds interactive JPanels
		final jPanel scrollStudents = new jPanel(); //Scroll list of students
		final jPanel displayPanel = new jPanel();  //Display panel for student information
		final jPanel topPanel = new jPanel();   //Panel for menubar
		
		final jPanel bottomPanel = new jPanel(); //Panel for holding scroll list and display screen
		
		//Sets ups layout for panels on main window
		panelCollection.add(scrollStudents, BorderLayout.WEST);
		bottomPanel.add(displayPanel,BorderLayout.EAST);
		panelCollection.add(topPanel,BorderLayout.NORTH);

		
		
		String[] students = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", };
		JScrollPane studentList = scrollStudents.addTextArea(students, new Rectangle(250,200,100,100),false);
		
		//Adds in the list of Menu Items
		String[] menuComponents = {"File","Edit","View", "Help",};
		JMenuBar mainMenu = topPanel.addMenuBar(menuComponents);
		
		
		//Sets the panelCollection as the primary window to be displayed
		mainWindow.background(panelCollection.getPanel());
	
	}
}
