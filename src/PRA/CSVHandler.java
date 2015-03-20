package PRA;

import jSwing.jFrame;
import jSwing.jPanel;
import jSwing.jScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CSVHandler implements ActionListener {
	private jFrame frame;
	private StudentList mainList;

	public CSVHandler(jFrame _frame, StudentList _mainList) {
		frame = _frame;
		mainList = _mainList;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			String filePath = getFile();
			if (filePath != null) {
				String[] headers = { "Module", "Ass", "Cand Key", "Mark",
						"Grade" };
				ArrayList<Result> csvData = getCSVData(filePath);
				if (csvData != null) {
					ArrayList<Assessment> assData = addToAssessments(csvData);
					for (Assessment ass : assData) {
						for (Result result : ass) {
							deAnonymise(result);
						}
					}

					jPanel panel = frame.getFrameContainer().getPanel("data");
					for (Assessment ass : assData) {
						panel.getTabbedPane("resultsPane").addTableTab(
								ass.toString(), toStringArray(ass), headers);
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private String[][] toStringArray(Assessment assData) {
		String[][] dataArray = new String[assData.size()][5];
		for (int i = 0; i < dataArray.length; i++) {
			dataArray[i][0] = assData.get(i).getExamModule();
			dataArray[i][1] = assData.get(i).getAssModule();
			dataArray[i][2] = assData.get(i).getCandKey();
			dataArray[i][3] = assData.get(i).getExamMark();
			dataArray[i][4] = assData.get(i).getExamGrade();
		}
		return dataArray;
	}
	
	private boolean deAnonymise(Result result) {
		// check every student
		for (Student student : mainList) {
			// and all the anonymous marking codes for each student
			for (String aMC : student.getAnonymousMarkingCodes()) {
				// if they are the same as the results
				if (result.getCandKey().contains(aMC)) {
					// and if they are, attaches student to result
					result.setStudent(student);
					return true;
				}
			}
		}
		return false;
	}

	private ArrayList<Assessment> addToAssessments(ArrayList<Result> data) {
		ArrayList<Assessment> assData = new ArrayList<>();
		int assIndex = -1;
		while (data.size() != 0) {
			Assessment newAss = new Assessment(data.get(0).getExamModule(),
					data.get(0).getAssModule());
			if (!assData.contains(newAss)) {
				assData.add(newAss);
				assIndex++;
			}
			for (int i = 0; i < data.size(); i++) {
				Result test = data.remove(0);
				boolean success = assData.get(assIndex).addResult(test);
				if (!success) {
					data.add(test);
				}
			}
		}
		return assData;
	}

	private String getFile() throws IOException {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(
				"CSV files (*.csv)", "csv");
		fc.setFileFilter(xmlfilter);
		fc.setDialogTitle("Open anonymous marking codes");

		int returnVal = fc.showOpenDialog(frame);
		if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			return file.toString();
		}
		return null;
	}

	public ArrayList<Result> getCSVData(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));

		String[] headers = { "Module", "Ass", "Cand Key", "Mark", "Grade" };

		String[] lineData = br.readLine().split(",");
		int[] column = new int[5];
		for (int i = 0; i < lineData.length; i++) {
			for (int j = 0; j < headers.length; j++) {
				if (lineData[i].contains(headers[j])) {
					column[j] = i;
				}
			}

		}

		if (column[0] == column[1]) {
			return null;
		}

		String line = "";
		ArrayList<Result> data = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			lineData = line.split(",");
			Result test = new Result(lineData[column[0]], lineData[column[1]],
					lineData[column[2]], lineData[column[3]],
					lineData[column[4]]);
			data.add(test);
		}
		br.close();
		return data;
	}
}