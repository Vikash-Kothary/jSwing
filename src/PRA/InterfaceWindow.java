package PRA;

import jSwing.jFrame;
import jSwing.jPanel;

import java.awt.BorderLayout;


@SuppressWarnings("serial")
public class InterfaceWindow extends jFrame {

	public InterfaceWindow() {
		super("PRA Coursework - Deep Vein Thrombosis");
		this.setSize(500, 600); //delete afterwards

		initMenu();
		
		jPanel container = new jPanel();
		container.setLayout(new BorderLayout());
		
		// need to redo list
		String[] test = {"Vikash Kothary (1462396)", "Toby Birkett ()", "Divyen Joshi ()"};
		jPanel students = new jPanel();
		students.setLayout(new BorderLayout());
		students.addTextField("", BorderLayout.NORTH);
		students.addList(test);
		container.add(students, BorderLayout.WEST);
		
		
		this.setContainer(container);
		
		//this.pack();
		this.setVisible(true);
	}
	
	private void initMenu(){
		this.addMenu("File", new String[]{"Exit"});
	}
}
