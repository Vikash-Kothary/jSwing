package PRA;

import java.util.ArrayList;

public class StudentList extends ArrayList<Student> {

	public StudentList() {

	}

	public int getSize() {
		return size();
	}

	public Student getStudent(int i) {
		return get(i);
	}

	// consider splitting into two functions: toStringArray and filterList
	public String[] updateStudentList(String textField) {
		ArrayList<String> studentNamesArrayList = new ArrayList<String>();
		for (int i = 0; i < getSize(); i++) {
			if (textField != "") {
				if (get(i).toString().toUpperCase()
						.contains(textField.toUpperCase())) {
					studentNamesArrayList.add(get(i).toString());
				}

			} else {
				studentNamesArrayList.add(get(i).toString());
			}

		}

		String[] studentNamesArray = new String[studentNamesArrayList.size()];
		for (String s : studentNamesArrayList) {
			studentNamesArray = studentNamesArrayList
					.toArray(studentNamesArray);
		}

		return studentNamesArray;

	}

}
