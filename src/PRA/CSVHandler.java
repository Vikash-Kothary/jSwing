package PRA;

import jSwing.jFrame;

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
			String filePath = getFile();
			if (filePath != null) {
				ArrayList<Result> csvData = getCSVData(filePath);
				ArrayList<Assessment> assData = addToAssessments(csvData);
				deAnonymiseData(assData);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void deAnonymiseData(ArrayList<Assessment> assData){
		for(Assessment ass : assData){
			for(Result result : ass){
				// if not a student number
				if(!result.getCandKey().contains("/")){
					deAnonymise(result);
				}
			}
		}
	}
	
	private boolean deAnonymise(Result result){
		// check every student
		for(Student student : mainList){
			// and all the anonymous marking codes for each student
			for(String aMC : student.getAnonymousMarkingCodes()){
				// if they are the same as the results
				if(result.getCandKey().equals(aMC)){
					// and if they are, replace the cand key with that student's student number
					result.setCandKey(student.getStudentNumber());
					return true;
				}
			}
		}
		return false;
	}

	private ArrayList<Assessment> addToAssessments(ArrayList<Result> data) {
		ArrayList<Assessment> assData= new ArrayList<>();
		int assIndex = -1;
		while(data.size()!=0){
			Assessment newAss = new Assessment(data.get(0).getExamModule(), data.get(0).getAssModule());
			if(!assData.contains(newAss)){
				assData.add(newAss);
				assIndex++;
			}
			for(int i=0; i<data.size(); i++){
				Result test = data.remove(0);
				boolean success = assData.get(assIndex).addResult(test);
				if(!success){
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
		String csvFile = filePath;
		BufferedReader br = new BufferedReader(new FileReader(csvFile));

		String[] lineData = br.readLine().split(",");
		int[] column = new int[5];
		for (int i = 0; i < lineData.length; i++) {
			if (lineData[i].contains("Module")) {
				column[0] = i;
			} else if (lineData[i].contains("Ass")) {
				column[1] = i;
			} else if (lineData[i].contains("Cand Key")) {
				column[2] = i;
			} else if (lineData[i].contains("Mark")) {
				column[3] = i;
			} else if (lineData[i].contains("Grade")) {
				column[4] = i;
			}
		}

		String line = "";
		ArrayList<Result> data = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			lineData = line.split(",");
			Result test = new Result(lineData[column[0]], lineData[column[1]], lineData[column[2]],
					lineData[column[3]], lineData[column[4]]);
			data.add(test);
		}
		br.close();
		return data;
	}
}
