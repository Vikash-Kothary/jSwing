package PRA;

import jSwing.jFrame;
import jSwing.jPanel;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ScatterGraphWindow extends jFrame {

	public ScatterGraphWindow(Student student) {
		super("Scatterplot: Marks compared to Average");
		setSize(1000, 600);
		jPanel container = addContainer();
		container.setLayout(new BorderLayout());
		container.setPadding(5, 5, 5, 5);

		

//		pack();
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
