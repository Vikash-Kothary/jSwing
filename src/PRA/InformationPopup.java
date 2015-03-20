package PRA;

import jSwing.jFrame;
import jSwing.jPanel;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class InformationPopup extends jFrame {

	public InformationPopup(Student student) {
		super("Information");
		setSize(300, 300);
		jPanel container = addContainer();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setPadding(5, 5, 5, 5);

		container.addLabel("<html>" + student.getStudentName() + "</html>")
				.setHorizontalAlignment(SwingConstants.CENTER);

		container.addLabel(
				"<html><i>" + student.getEmailAddress() + "</i></html>")
				.setHorizontalAlignment(SwingConstants.CENTER);

		container.addLabel("Student No.: " + student.getStudentNumber())
				.setHorizontalAlignment(SwingConstants.LEFT);

		container.addLabel("Tutor: " + student.getTutorEmail())
				.setHorizontalAlignment(SwingConstants.LEFT);

		jPanel results = container.addPanel("resultsPopup");
		results.setPadding(5, 0, 0, 0);
		String[] headers = { "Module", "Ass", "Mark", "Grade" };
		String[][] dataArray = toStringArray(student.getResults());
		results.addTable("Student Results", dataArray, headers);

		pack();
		centreFrame();
		setVisible(true);
	}

	private String[][] toStringArray(ArrayList<Result> resultsData) {
		String[][] dataArray = new String[resultsData.size()][4];
		for (int i = 0; i < dataArray.length; i++) {
			dataArray[i][0] = resultsData.get(i).getExamModule();
			dataArray[i][1] = resultsData.get(i).getAssModule();
			dataArray[i][2] = resultsData.get(i).getExamMark();
			dataArray[i][3] = resultsData.get(i).getExamGrade();
		}
		return dataArray;
	}

}
