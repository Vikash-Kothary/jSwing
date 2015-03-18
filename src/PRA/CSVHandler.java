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

	
	
	public CSVHandler(jFrame _frame) {
		frame = _frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try{
			String filePath = getFile();
			Result[] data = null;
			if(filePath!=null){
				data = getCSVData(filePath);
				ArrayList<Assessment> assData = new ArrayList<>();
				for(Result result : data){
				}
				
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

	public Result[] getCSVData(String filePath) throws IOException {
		String csvFile = filePath;
		String line = "";
		int lengthOfFile = 0;
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
			lengthOfFile += 1;
		}
		BufferedReader br1 = new BufferedReader(new FileReader(csvFile));
		String[] lineData = br1.readLine().split(",");
		int[] headerLocation = new int[5];
		for(int i=0; i < lineData.length; i++){
			if(lineData[i].contains("Module")){
				headerLocation[0] = i;
			}else if(lineData[i].contains("Ass")){
				headerLocation[1] = i;
			}else if(lineData[i].contains("Cand Key")){
				headerLocation[2] = i;
			}else if(lineData[i].contains("Mark")){
				headerLocation[3] = i;
			}else if(lineData[i].contains("Grade")){
				headerLocation[4] = i;
			}
		}
		Result[] data = new Result[lengthOfFile];
		for (int i = 1; i < lengthOfFile; i++) {
			lineData = br1.readLine().split(",");
			data[i] = new Result(lineData[0], lineData[1], lineData[2], lineData[3], lineData[4]);
		}
		br1.close();
		return data;
	}
}
