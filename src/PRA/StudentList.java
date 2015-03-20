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
		ArrayList<String> studentNamesArrayList = new ArrayList<String>();
		int length = 0;
		for (int i = 0; i < getSize(); i++) {
			if (textField != "") {
				if (get(i).toString().toUpperCase()
						.contains(textField.toUpperCase())) {
					studentNamesArrayList.add(get(i).toString());
					length += 1;
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
