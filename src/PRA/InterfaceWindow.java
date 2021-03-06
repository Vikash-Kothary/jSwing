/*
 * PRA Coursework - Deep Vein Thrombosis
 * @author  Vikash Kothary
 * @author  Toby Birkett
 */
package PRA;

import jSwing.jFrame;
import jSwing.jPanel;
import jSwing.jTabbedPane;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

// TODO: Auto-generated Javadoc
/**
 * The Class InterfaceWindow.
 */
@SuppressWarnings("serial")
public class InterfaceWindow extends jFrame {

	/** The main list. */
	private StudentList mainList;

	/** The series. */
	private final XYSeries series = new XYSeries("StudentData");

	/**
	 * Instantiates a new interface window.
	 *
	 * @param _mainList
	 *            the _main list
	 */
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

		maximiseFrame();
		setVisible(true);
	}

	/**
	 * Inits the menu.
	 */
	private void initMenu() {
		String[] fileMenu = new String[] { "Load anonymous marking codes",
				"Load exam results", "Exit" };
		addMenu("File", fileMenu);
		String[] dataMenu = new String[] { "Compare To Average",
				"Email to Students", "Email Settings", "Fetch Participation",
		"Export To PDF" };
		addMenu("Data", dataMenu);

		getMenuItem("File", fileMenu[0]).addActionListener(
				new CSVHandler(this, mainList));

		getMenuItem("File", fileMenu[1]).addActionListener(
				new CSVHandler(this, mainList));

		getMenuItem("File", fileMenu[2]).addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						exitFrame();
					}

				});

		getMenuItem("Data", dataMenu[0]).addActionListener(
				new ActionListener() {
					@SuppressWarnings("unused")
					@Override
					public void actionPerformed(ActionEvent e) {
						jTabbedPane tabbedPane = getFrameContainer().getPanel(
								"data").getTabbedPane("resultsPane");
						if (tabbedPane.getSelectedIndex() != -1) {
							new ScatterPlotWindow(mainList, tabbedPane);
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

		getMenuItem("Data", dataMenu[3]).addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							new WebScraper();
						} catch (HeadlessException | UnsupportedFlavorException
								| IOException e1) {
							e1.printStackTrace();
						}
					}

				});

		getMenuItem("Data", dataMenu[4]).addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new PDFExport(mainList);
					}
				});
	}

	/**
	 * Adds the student panel elements.
	 */
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

}
