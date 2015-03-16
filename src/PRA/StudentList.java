package PRA;

import java.util.ArrayList;

public class StudentList extends ArrayList<Student> {

	public Student getStudent(int i) {
		return get(i);
	}

	public StudentList() {

	}

	public int getSize() {
		return size();
	}

	// consider splitting into two functions: toStringArray and filterList
	public String[] updateStudentList(String textField) {
		String[] studentNames = new String[getSize()];
		for (int i = 0; i < getSize(); i++) {
			if (textField != "") {
				if (get(i).toString().toUpperCase()
						.contains(textField.toUpperCase())) {
					studentNames[i] = get(i).toString();
				}

			} else {
				studentNames[i] = get(i).toString();
			}

		}
		return studentNames;

	}

}
