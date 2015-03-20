package PRA;

import jSwing.jFrame;
import jSwing.jPanel;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class InformationPopup extends jFrame {

	public InformationPopup(Student student) {
		super("Information");
		setSize(300, 300);
		jPanel container = addContainer();
		container.setLayout(new GridLayout(4, 1));

		container.addLabel(student.getStudentName()).setHorizontalAlignment(
				SwingConstants.CENTER);

		container.addLabel(
				"<html><i>" + student.getEmailAddress() + "</i></html>")
				.setHorizontalAlignment(SwingConstants.CENTER);

		container.addLabel("Student No.: " + student.getStudentNumber())
				.setHorizontalAlignment(SwingConstants.LEFT);

		container.addLabel("Tutor: " + student.getTutorEmail())
				.setHorizontalAlignment(SwingConstants.LEFT);

		String[] headers = { "Module", "Ass", "Cand Key", "Mark",
				"Grade" };
		String[][] dataArray = toStringArray(student.getResults());
		container.addTable("Student Results", dataArray, headers);
		
		centreFrame();
		pack();
		setVisible(true);
	}
	
	private String[][] toStringArray(ArrayList<Result> resultsData) {
		String[][] dataArray = new String[resultsData.size()][5];
		for (int i = 0; i < dataArray.length; i++) {
			dataArray[i][0] = resultsData.get(i).getExamModule();
			dataArray[i][1] = resultsData.get(i).getAssModule();
			dataArray[i][2] = resultsData.get(i).getCandKey();
			dataArray[i][3] = resultsData.get(i).getExamMark();
			dataArray[i][4] = resultsData.get(i).getExamGrade();
		}
		return dataArray;
	}

}
