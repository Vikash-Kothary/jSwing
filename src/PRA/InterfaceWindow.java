package PRA;

import jSwing.jFrame;
import jSwing.jPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class InterfaceWindow extends jFrame {

	public InterfaceWindow(final StudentList mainList) {
		super("PRA Coursework - Deep Vein Thrombosis");
		this.setSize(500, 600); //delete afterwards

		initMenu();
		
		jPanel container = new jPanel();
		container.setLayout(new BorderLayout());
		
		
		String[] test = new String[mainList.getSize()];
		
		for (int i = 0; i < mainList.getSize(); i++){
			test[i] = mainList.toString(i);	
		}
		
		
		
		final jPanel students = new jPanel();
		students.setLayout(new BorderLayout());
		students.addTextField("", BorderLayout.NORTH);
		students.addList(test, "testList");

		container.add(students, BorderLayout.WEST);
		
		
		

		
		students.getList("testList").addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(e.getButton()==MouseEvent.BUTTON1){
					new InformationPopup(mainList.getStudent((students.getList("testList").getSelectedIndex())));
				}
			}
		});
		

		
		this.setContainer(container);
		
		//this.pack();
		this.setVisible(true);
	}
	
	private void initMenu(){
		this.addMenu("File", new String[]{"Exit"});
	}
}
