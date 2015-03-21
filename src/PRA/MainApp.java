package PRA;

import studentdata.Connector;
import studentdata.DataTable;

public class MainApp {

	public static void main(String[] args) {
		StudentList studentList = new StudentList();

		// Create a Connector object and open the connection to the server
		Connector server = new Connector();
		boolean success = server.connect("Deep_Vein_Thrombosis",
				"91c82a5b099492cce498e151e5d71a68");

		if (success == false) {
			System.out
					.println("Fatal error: could not open connection to server");
			System.exit(1);
		}

		DataTable data = server.getData();
		for (int row = 0; row < data.getRowCount(); ++row) {
			Student student = new Student();
			student.setEmailAddress(data.getCell(row, 0));
			student.setStudentNumber(data.getCell(row, 1));
			student.setStudentName(data.getCell(row, 2));
			student.setTutorEmail(data.getCell(row, 3));
			studentList.add(student);
		}

		new InterfaceWindow(studentList);
	}

}
