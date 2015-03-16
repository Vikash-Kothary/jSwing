package PRA;

import java.util.ArrayList;

public class StudentList extends ArrayList<Student> {

	public String getStudentString(int i) {
		return get(i).toString();
	}

	public StudentList() {

	}

	public int getSize() {
		return size();
	}

}
