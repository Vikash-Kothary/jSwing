/*
 * PRA Coursework - Deep Vein Thrombosis
 * @author  Vikash Kothary
 * @author  Toby Birkett
 */
package PRA;

import jSwing.jFrame;
import jSwing.jPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class InformationPopup.
 */
@SuppressWarnings("serial")
public class InformationPopup extends jFrame {

	/**
	 * Instantiates a new information popup.
	 *
	 * @param student
	 *            the student
	 */
	public InformationPopup(Student student) {
		super("Information");
		this.setMinimumSize(new Dimension(400, 150));
		jPanel container = addContainer();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setPadding(10, 10, 10, 10);

		jPanel labelPanel = container.addPanel("labelPanel");
		labelPanel.setLayout(new GridLayout(4,1, 10,10));
		labelPanel.addLabel("<html>" + student.getStudentName() + "</html>")
				.setHorizontalAlignment(SwingConstants.CENTER);

		labelPanel.addLabel(
				"<html><i>" + student.getEmailAddress() + "</i></html>")
				.setHorizontalAlignment(SwingConstants.CENTER);

		labelPanel.addLabel("Student No.: " + student.getStudentNumber())
				.setHorizontalAlignment(SwingConstants.LEFT);

		labelPanel.addLabel("Tutor: " + student.getTutorEmail())
				.setHorizontalAlignment(SwingConstants.LEFT);
		
		if(student.getLastAccessed()!=null){
			labelPanel.addLabel("Last Accessed: " + student.getLastAccessed())
			.setHorizontalAlignment(SwingConstants.LEFT);
		}


		String[][] dataArray = toStringArray(student.getResults());
		if(dataArray.length!=0){
			jPanel results = container.addPanel("resultsPopup");
			results.setPadding(5, 0, 0, 0);
			String[] headers = { "Module", "Ass", "Mark", "Grade" };
			results.addTable("Student Results", dataArray, headers);
		}

		pack();
		centreFrame();
		setVisible(true);
	}

	/**
	 * To string array.
	 *
	 * @param resultsData
	 *            the results data
	 * @return the string[][]
	 */
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
