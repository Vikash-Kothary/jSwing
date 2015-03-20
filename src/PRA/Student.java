package PRA;

import java.util.ArrayList;

public class Student {

	private String studentName;
	private String studentNumber;
	private String emailAddress;
	private String tutorEmail;
	private ArrayList<String> anonymousMarkingCode;

	public Student(String _studentName, String _studentNumber,
			String _emailAddress, String _tutorEmail) {
		studentName = _studentName;
		studentNumber = _studentNumber;
		emailAddress = _emailAddress;
		tutorEmail = _tutorEmail;
		anonymousMarkingCode = new ArrayList<>();
	}

	public Student() {
		studentName = "";
		studentNumber = "";
		emailAddress = "";
		tutorEmail = "";
		anonymousMarkingCode = new ArrayList<>();
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the studentNumber
	 */
	public String getStudentNumber() {
		return studentNumber;
	}

	/**
	 * @param studentNumber
	 *            the studentNumber to set
	 */
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the tutorEmail
	 */
	public String getTutorEmail() {
		return tutorEmail;
	}

	/**
	 * @param tutorEmail
	 *            the tutorEmail to set
	 */
	public void setTutorEmail(String tutorEmail) {
		this.tutorEmail = tutorEmail;
	}

	public ArrayList<String> getAnonymousMarkingCodes() {
		return anonymousMarkingCode;
	}

	public boolean addAnonymousMarkingCode(String aMC) {
		if (!anonymousMarkingCode.contains(aMC)) {
			anonymousMarkingCode.add(aMC);
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return studentName + " (" + studentNumber + ")";
	}

}
