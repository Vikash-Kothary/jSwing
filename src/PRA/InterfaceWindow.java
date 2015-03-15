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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


@SuppressWarnings("serial")
public class InterfaceWindow extends jFrame {

	public InterfaceWindow(final StudentList mainList) {
		super("PRA Coursework - Deep Vein Thrombosis");
		this.setSize(500, 600); //delete afterwards

		initMenu();
		
		jPanel container = new jPanel();
		container.setLayout(new BorderLayout());
		
		
		
		
		
		
		final jPanel students = new jPanel();
		students.setLayout(new BorderLayout());
		students.addTextField("", "studentSearchField", BorderLayout.NORTH);
		students.addList(updateStudentList(mainList, students.getTextField("studentSearchField").getText()), "studentList", "scrollList");

		container.add(students, BorderLayout.WEST);
		
		
		

		
		students.getList("studentList").addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(e.getButton()==MouseEvent.BUTTON1){
					new InformationPopup(mainList.getStudent((students.getList("studentList").getSelectedIndex())));
				}
			}
		});
		
		students.getTextField("studentSearchField").getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void changedUpdate(DocumentEvent e) {	
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				students.setList(updateStudentList(mainList, students.getTextField("studentSearchField").getText()), students.getList("studentList"), students.getScrollPane("scrollList"));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				students.setList(updateStudentList(mainList, students.getTextField("studentSearchField").getText()), students.getList("studentList"), students.getScrollPane("scrollList"));
			}
			
		});
		

		
		this.setContainer(container);
		
		//this.pack();
		this.setVisible(true);
	}
	
	private void initMenu(){
		this.addMenu("File", new String[]{"Load anonymous marking codes","Load exam results", "Exit"});
	}
	
	public String[] updateStudentList(StudentList mainList, String textField){
		
		String[] studentNames = new String[mainList.getSize()];
		for (int i = 0; i < mainList.getSize(); i++){
			if (textField != ""){
				if (mainList.toString(i).toUpperCase().contains(textField.toUpperCase())){
					studentNames[i] = mainList.toString(i);	
				}
			
			} else {
				studentNames[i] = mainList.toString(i);	
			}
	
		}
	
		return studentNames;
	
	}
}















