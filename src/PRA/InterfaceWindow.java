package PRA;

import jSwing.jFrame;
import jSwing.jPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
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

		students.getList("studentList").addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("a;lskdf");
				if (e.getButton() == MouseEvent.BUTTON1) {
					new InformationPopup(mainList.getStudent(students
							.getList("studentList")
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

		this.setContainer(container);

		// this.pack();
		this.setVisible(true);
	}

	private void initMenu() {
		this.addMenu("File", new String[] { "Load anonymous marking codes",
				"Load exam results", "Exit" });
	}
	

}
