package PRA;

import jSwing.jFrame;
import jSwing.jPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class InformationPopup extends jFrame {

	public InformationPopup(Student student){
		super("Information");
		
		jPanel container = addContainer();
		container.setLayout(new GridLayout(4,1));
		
		container.addLabel(student.getStudentName())
			.setHorizontalAlignment(SwingConstants.CENTER);

		container.addLabel("<html><i>"+student.getEmailAddress()+"</i></html>")
			.setHorizontalAlignment(SwingConstants.CENTER);

		container.addLabel("Student No.: "+student.getStudentNumber())
			.setHorizontalAlignment(SwingConstants.LEFT);

		container.addLabel("Tutor: " + student.getTutorEmail())
			.setHorizontalAlignment(SwingConstants.LEFT);
		
		centreFrame();
		pack();
		setVisible(true);
	}

}
