package PRA;

import jSwing.jFrame;
import jSwing.jPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class InformationPopup extends jFrame {
	private Student student;

	public InformationPopup(Student _student){
		super("Information");
		student  = _student;
		
		jPanel container = new jPanel();
		jPanel topPanel = new jPanel();
		jPanel bottomPanel = new jPanel();
		container.setLayout(new GridLayout(4,1));
		
		JLabel studentName = new JLabel(student.getFullName());
		studentName.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(studentName);
		JLabel studentEmail = new JLabel("<html><i>"+student.getEmailAddress()+"</i></html>");
		studentEmail.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(studentEmail);
		JLabel studentNumber = new JLabel("Student No.: "+student.getStudentNumber());
		studentNumber.setHorizontalAlignment(SwingConstants.LEFT);
		container.add(studentNumber);
		JLabel tutorEmail = new JLabel("Tutor: " + student.getTutorEmail());
		tutorEmail.setHorizontalAlignment(SwingConstants.LEFT);
		container.add(tutorEmail);
		
		
		this.setContainer(container);
		
		this.pack();
		this.setVisible(true);
	}

}
