/*
 * PRA Coursework - Deep Vein Thrombosis
 * @author  Vikash Kothary
 * @author  Toby Birkett
 */
package PRA;

import java.util.ArrayList;

/**
 * The Class StudentList. Stores all the student.
 */
public class StudentList extends ArrayList<Student> {

	/**
	 * Instantiates a new student list.
	 */
	public StudentList() {

	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size();
	}

	/**
	 * Gets the student.
	 *
	 * @param i
	 *            the i
	 * @return the student
	 */
	public Student getStudent(int i) {
		return get(i);
	}

	// consider splitting into two functions: toStringArray and filterList
	/**
	 * Update student list.
	 *
	 * @param textField
	 *            the text field
	 * @return the string[]
	 */
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
