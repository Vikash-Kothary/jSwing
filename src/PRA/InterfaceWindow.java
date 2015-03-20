package PRA;

import jSwing.jFrame;
import jSwing.jPanel;
import jSwing.jTabbedPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

@SuppressWarnings("serial")
public class InterfaceWindow extends jFrame {
	private StudentList mainList;
	private Random rand = new Random();
	private final XYSeries series = new XYSeries("StudentData");

	public InterfaceWindow(StudentList _mainList) {
		super("PRA Coursework - Deep Vein Thrombosis");
		mainList = _mainList;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stops program when
														// frame is closed
		setSize(1000, 600);
		initMenu();

		jPanel container = addContainer();
		container.setLayout(new BorderLayout());

		jPanel students = container.addPanel("students", BorderLayout.WEST);
		students.setLayout(new BorderLayout());
		addStudentPanelElements();

		jPanel data = container.addPanel("data", BorderLayout.CENTER);
		data.setLayout(new BorderLayout());

		jTabbedPane resultsPane = data.addPane("resultsPane",
				BorderLayout.CENTER);

		// This is an example of how the addTable/addPane class works
		// data.getTabbedPane("resultsPane").addTab("Tab1",
		// data.addTable("Table",
		// getCSV("C:\\Users\\Toby\\Downloads\\codes_and_marksheets\\codes_and_marksheets\\anoncodes1.csv"),
		// getCSV("C:\\Users\\Toby\\Downloads\\codes_and_marksheets\\codes_and_marksheets\\anoncodes1.csv")[0]));

		this.setVisible(true);
	}

	private void initMenu() {
		String[] fileMenu = new String[] { "Load anonymous marking codes",
				"Load exam results", "Exit" };
		addMenu("File", fileMenu);
		String[] dataMenu = new String[] { "Compare To Average",
				"Email to Students", "Email Settings" };
		addMenu("Data", dataMenu);


		
	
		

		getMenuItem("File", fileMenu[0]).addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						final JFileChooser fc = new JFileChooser();
						FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(
								"CSV files (*.csv)", "csv");
						fc.setFileFilter(xmlfilter);
						fc.setDialogTitle("Open anonymous marking codes");

						int returnVal = fc.showOpenDialog(InterfaceWindow.this);
						String[][] csvFile = null;
						if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
							java.io.File file = fc.getSelectedFile();
							String filePath = file.toString();
							csvFile = getCSV(filePath);

							String Snumber;
							String Acode;
							int imports = 0;

							for (int i = 0; i < mainList.size(); i++) {
								for (int j = 0; j < csvFile.length; j++) {
									Acode = csvFile[j][0];
									Snumber = mainList.getStudent(i)
											.getStudentNumber();
									if (Acode.equals(Snumber)) {
										mainList.getStudent(i)
												.addAnonymousMarkingCode(
														csvFile[j][1]);
										imports += 1;
									}
								}
							}
							System.out
									.println("Anonymous marking codes impored. "
											+ imports
											+ " codes were for known students; "
											+ ((csvFile.length) - imports)
											+ " codes were for unknown students");
							jTabbedPane tabbedPane = getFrameContainer()
									.getPanel("data").getTabbedPane(
											"resultsPane");
							for (int i = 0; i < tabbedPane.getNumberOfTabs(); i++) {
//								 jScrollPane test = tabbedPane.removeTab(i);
//								 tabbedPane.addTableTab(test.getName(),
//								 test.getTable());
							}
						}
					}
				});
		
		getMenuItem("File", fileMenu[1]).addActionListener(	new CSVHandler(this, mainList));
		

		getMenuItem("File", fileMenu[2]).addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						exitFrame();
					}

				});

		
		getMenuItem("Data", dataMenu[0]).addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						jTabbedPane tabbedPane = getFrameContainer().getPanel("data").getTabbedPane("resultsPane");
						if(tabbedPane.getSelectedIndex() != -1){
							JTable selectedTable = tabbedPane.getTab(tabbedPane.getSelectedIndex()).getTable();
							int studentIndex = 0;
							for(int i = 0; i < selectedTable.getColumnCount(); i++){
								if (selectedTable.getColumnName(i).equals("Cand Key")){
									studentIndex = i;
									break;
								}
							}
							
							
							
							
							
							
							
							
							
							
							
//							int average = 0;
//							JTable selectedTable = tabbedPane.getTab(tabbedPane.getSelectedIndex()).getTable();
//							
//							for (int i = 0; i < selectedTable.getRowCount(); i++){
//								for(int j = 0; j<tabbedPane.getTabCount(); j++){
//									if (j != tabbedPane.getSelectedIndex()){
//										int markIndex = 0;
//										
//										JTable nonSelectedTable = tabbedPane.getTab(j).getTable();
//								
//										for(int k = 0; k < nonSelectedTable.getColumnCount(); k++){
//											if (nonSelectedTable.getColumnName(k).equals("Mark")){
//												markIndex = k;
//												break;
//											}
//										}
//										average += Integer.valueOf((String) nonSelectedTable.getValueAt(i, markIndex));
//									}	
//								}
//									average = average / (tabbedPane.getTabCount() - 1);
//									int markIndex = 0;
//									for (int k = 0; k <selectedTable.getColumnCount(); k++){
//										if (selectedTable.getColumnName(k).equals("Mark")){
//											markIndex = k;
//											break;
//										}	
//									}
//									series.add(Integer.valueOf((String) selectedTable.getValueAt(i, markIndex)), Integer.valueOf(average));
//									System.out.println(selectedTable.getRowCount());
//								}
//							
//								
//								
//							
//					
							XYSeriesCollection studentData = new XYSeriesCollection();
							studentData.addSeries(series);
							new ScatterPlot(studentData);	
						}
					}
				});

		getMenuItem("Data", dataMenu[1]).addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							new EmailPopup(mainList);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
		


		getMenuItem("Data", dataMenu[2]).addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							new EmailSettingsDialogue();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
		
		
	}

	private void addStudentPanelElements() {
		final jPanel students = getFrameContainer().getPanel("students");
		students.addTextField(null, "studentSearchField", BorderLayout.NORTH);
		students.addList(
				mainList.updateStudentList(students.getTextField(
						"studentSearchField").getText()), "studentList");

		students.getList("studentList").getList()
				.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						if (e.getButton() == MouseEvent.BUTTON1) {
							new InformationPopup(mainList.getStudent(students
									.getList("studentList").getList()
									.getSelectedIndex()));
						}
					}
				});

		students.getTextField("studentSearchField").getDocument()
				.addDocumentListener(new DocumentListener() {
					@Override
					public void changedUpdate(DocumentEvent e) {
					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						students.getList("studentList").updateList(
								mainList.updateStudentList(students
										.getTextField("studentSearchField")
										.getText()));
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						students.getList("studentList").updateList(
								mainList.updateStudentList(students
										.getTextField("studentSearchField")
										.getText()));

					}
				});
	}

	public String[][] getCSV(String filePath) {
		String csvFile = filePath;
		BufferedReader br = null;
		String line = " ";

		String[][] student = null;
		int lengthOfFile = 0;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				lengthOfFile += 1;
			}
			int inc = 0;
			String[] studentLines;
			student = new String[lengthOfFile][];
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				studentLines = line.split(",");
				student[inc] = studentLines;
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

		return student;
	}

}
