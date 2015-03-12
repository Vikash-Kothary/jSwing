package PRA;

import jSwing.jFrame;
import jSwing.jPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class InformationPopup extends jFrame {
	private Student student;

	public InformationPopup(Student _student){
		super("Information");
		student  = _student;
		
		jPanel container = new jPanel();
		container.setLayout(new GridLayout(1,4));
		
		JLabel studentName = new JLabel(student.getFullName());
		container.add(studentName);
		JLabel studentEmail = new JLabel("<html><i>"+student.getEmailAddress()+"</i></html>");
		container.add(studentEmail);
		JLabel studentNumber = new JLabel("Student No.: "+student.getStudentNumber());
		container.add(studentNumber);
		JLabel tutorEmail = new JLabel();
		container.add(tutorEmail);
		
		this.setContainer(container);
		
		this.pack();
		this.setVisible(true);
	}

}
