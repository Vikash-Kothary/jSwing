package PRA;

import jSwing.jFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ExamResults implements ActionListener {
	private jFrame frame;

	public ExamResults(jFrame _frame) {
		frame = _frame;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		try{
			String filePath = getFile();
			Results[] data = null;
			if(filePath!=null){
				data = getCSVData(filePath);
			}
			if(data!=null){
				//TODO
			}
		}catch(IOException ex){
			ex.printStackTrace();
		}
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

	public Results[] getCSVData(String filePath) throws IOException {
		String csvFile = filePath;
		String line = "";
		int lengthOfFile = 0;
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
			lengthOfFile += 1;
		}
		br.reset();
		String[] studentLines;
		Results[] data = new Results[lengthOfFile];
		for (int i = 1; i < lengthOfFile; i++) {
			String[] lineData = br.readLine().split(",");
			data[i] = new Results();
			data[i].setExamModule(lineData[2]);
			data[i].setAssModule(lineData[5]);
			data[i].setCandKey(lineData[6]);
			data[i].setExamMark(lineData[9]);
			data[i].setExamGrade(lineData[10]);
		}
		br.close();
		return data;
	}
}
