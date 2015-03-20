package PRA;

import jSwing.jFrame;
import jSwing.jPanel;
import jSwing.jTabbedPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
			File[] files = getFiles();
			for (File file : files) {
				ArrayList<Result> csvData = getCSVData(file.toString());
				if (csvData != null) {
					String[] headers = { "Module", "Ass", "Cand Key", "Mark",
							"Grade" };
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
				if (result.getCandKey().equals(aMC)
						|| result.getCandKey().split("/")[0].equals(
								student.getStudentNumber())) {
					// and if they are, attaches student to result
					result.setStudent(student);
					student.addResults(result);
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

	private File[] getFiles() throws IOException {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(
				"CSV files (*.csv)", "csv");
		fc.setFileFilter(xmlfilter);
		fc.setDialogTitle("Open exam results");
		fc.setMultiSelectionEnabled(true);

		int returnVal = fc.showOpenDialog(frame);
		if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
			File[] files = fc.getSelectedFiles();
			return files;
		}
		return null;
	}

	@SuppressWarnings("resource")
	private ArrayList<Result> getCSVData(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		boolean codesFile = (br.readLine().split(",").length == 2);
		br.close();
		if (codesFile) {
			return readCodes(filePath);
		} else {
			return readResults(filePath);
		}
	}

	private ArrayList<Result> readResults(String filePath) throws IOException {
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

	private ArrayList<Result> readCodes(String filePath) {
		BufferedReader br = null;
		String line = " ";

		String[][] csvFile = null;
		int lengthOfFile = 0;
		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {
				lengthOfFile += 1;
			}
			int inc = 0;
			String[] studentLines;
			csvFile = new String[lengthOfFile][];
			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {
				studentLines = line.split(",");
				csvFile[inc] = studentLines;
				inc += 1;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		String Snumber;
		String Acode;
		int imports = 0;

		for (int i = 0; i < mainList.size(); i++) {
			for (int j = 0; j < csvFile.length; j++) {
				Acode = csvFile[j][0];
				Snumber = mainList.getStudent(i).getStudentNumber();
				if (Acode.equals(Snumber)) {
					mainList.getStudent(i).addAnonymousMarkingCode(
							csvFile[j][1]);
					imports += 1;
				}
			}
		}
		System.out.println("Anonymous marking codes impored. " + imports
				+ " codes were for known students; "
				+ ((csvFile.length) - imports)
				+ " codes were for unknown students");
		return null;

	}

}