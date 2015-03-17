package PRA;

import jSwing.jFrame;
import jSwing.jPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class InterfaceWindow extends jFrame {

	public InterfaceWindow(final StudentList mainList) {
		super("PRA Coursework - Deep Vein Thrombosis");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stops program when exits frame
		this.setSize(1000, 600); // delete afterwards or should i

		
		
		
		initMenu();

		jPanel container = new jPanel();
		container.setLayout(new BorderLayout());

		final jPanel students = new jPanel();
		students.setLayout(new BorderLayout());
		students.addTextField("", "studentSearchField", BorderLayout.NORTH);
		students.addList(
				mainList.updateStudentList(students.getTextField("studentSearchField").getText()),
				"studentList");

		

		
		container.add(students, BorderLayout.WEST);




		students.getList("studentList").getList().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					new InformationPopup(mainList.getStudent(students
							.getList("studentList").getList()
							.getSelectedIndex()));
					// returns list index
				}
			}
		});

		students.getTextField("studentSearchField").getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				students.getList("studentList").updateList(mainList.updateStudentList(students.getTextField("studentSearchField").getText()));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				students.getList("studentList").updateList(mainList.updateStudentList(students.getTextField("studentSearchField").getText()));

			}
		});

		getMenuItem("File", "Load anonymous marking codes").addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				final JFileChooser fc = new JFileChooser();
					
				int returnVal = fc.showOpenDialog(InterfaceWindow.this);
				String[][] csvFile = null;
				if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
						java.io.File file = fc.getSelectedFile();
						String filePath = file.toString();
						
						csvFile = getCSV(filePath);
						String studentNumber;
						String arrayNumber;
						int imports = 0;
						
						for (int i = 0; i < mainList.size(); i++){
							for (int j = 0; j< csvFile.length; j++){
								arrayNumber = csvFile[j][0];
								studentNumber = mainList.getStudent(i).getStudentNumber();
								if(arrayNumber.equals(studentNumber)){
									mainList.getStudent(i).setAnonymousMarkingCode(csvFile[j][1]);
									imports +=1;
								}
								
							}
						}
						System.out.println("Anonymous marking codes impored. " + imports + 
								" codes were for known students; " + ((csvFile.length)-imports) 
								+ " codes were for unknown students");
						}
			}
		});
	
		
		
		
		this.setContainer(container);

		// this.pack();
		this.setVisible(true);
	}

	private void initMenu(  ) {
		this.addMenu("File", new String[] { "Load anonymous marking codes",
				"Load exam results", "Exit" });
		
		getMenuItem("File", "Exit").addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				exitFrame();
			}
		});
		
		
	
	}
	

	
	public String[][] getCSV(String filePath){
		String csvFile = filePath;
		BufferedReader br = null;
		String line = " ";
		String cvsSplitBy = ",";
		String[][] student = null;
		int lengthOfFile = 0;
		
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				lengthOfFile+=1;
			}
			br = new BufferedReader(new FileReader(csvFile));
			int inc = 0;
			String[] studentLines;
			student = new String[lengthOfFile][];	
			while ((line = br.readLine()) != null) {	
				studentLines = line.split(cvsSplitBy);
				student[inc] = studentLines; 	
				inc +=1;
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
	 
		return student;
	}

}
