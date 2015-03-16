package PRA;

import jSwing.jFrame;
import jSwing.jPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class InterfaceWindow extends jFrame {

	public InterfaceWindow(final StudentList mainList) {
		super("PRA Coursework - Deep Vein Thrombosis");
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
//				students.getList("studentList").
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
//				students.setList(
//						mainList.updateStudentList(students
//								.getTextField("studentSearchField")
//								.getText()), students
//								.getList("studentList"), students
//								.getScrollPane("scrollList")
//				);
			}
		});

		getMenuItem("File", "Load anonymous marking codes").addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				final JFileChooser fc = new JFileChooser();
					
				int returnVal = fc.showOpenDialog(InterfaceWindow.this);
				
				if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
						java.io.File file = fc.getSelectedFile();
						String fileName = file.toString();
						
						JOptionPane.showMessageDialog(InterfaceWindow.this, fileName); //Temporary, to display file path
				}
			}
		});
		
		getMenuItem("File", "Exit").addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		this.setContainer(container);

		// this.pack();
		this.setVisible(true);
	}

	private void initMenu() {
		this.addMenu("File", new String[] { "Load anonymous marking codes",
				"Load exam results", "Exit" });
	}
	

}
