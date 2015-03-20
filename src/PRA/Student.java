package PRA;

import java.util.ArrayList;

public class Student {

	private ArrayList<String> anonymousMarkingCode;
	private String emailAddress;
	private ArrayList<Result> results;
	private String studentName;
	private String studentNumber;
	private String tutorEmail;
	private String lastAccessed;

	public Student() {
		anonymousMarkingCode = new ArrayList<>();
		results = new ArrayList<>();
	}

	public Student(String _studentName, String _studentNumber,
			String _emailAddress, String _tutorEmail) {
		studentName = _studentName.replaceAll("[\"]", "");
		studentNumber = _studentNumber.replaceAll("[\"]", "").replaceAll("#", "");
		emailAddress = _emailAddress.replaceAll("[\"]", "");
		tutorEmail = _tutorEmail.replaceAll("[\"]", "");
		anonymousMarkingCode = new ArrayList<>();
		results = new ArrayList<>();
	}

	/**
	 * @return the lastAccessed
	 */
	public String getLastAccessed() {
		return lastAccessed;
	}

	/**
	 * @param lastAccessed the lastAccessed to set
	 */
	public void setLastAccessed(String lastAccessed) {
		this.lastAccessed = lastAccessed;
	}

	public boolean addAnonymousMarkingCode(String aMC) {
		aMC = aMC.replaceAll("[\"]", "");
		if (!anonymousMarkingCode.contains(aMC)) {
			anonymousMarkingCode.add(aMC);
			return true;
		}
		return false;
	}

	/**
	 * @param results
	 *            the results to set
	 */
	public boolean addResults(Result result) {
		if (!results.contains(result)) {
			results.add(result);
			return true;
		}
		return false;
	}

	public ArrayList<String> getAnonymousMarkingCodes() {
		return anonymousMarkingCode;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @return the results
	 */
	public ArrayList<Result> getResults() {
		return results;
	}

	public String getStudentName() {
		return studentName;
	}

	/**
	 * @return the studentNumber
	 */
	public String getStudentNumber() {
		return studentNumber;
	}

	/**
	 * @return the tutorEmail
	 */
	public String getTutorEmail() {
		return tutorEmail;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress.replaceAll("[\"]", "");
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName.replaceAll("[\"]", "").replaceAll("#", "");
	}

	/**
	 * @param studentNumber
	 *            the studentNumber to set
	 */
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber.replaceAll("[\"]", "");
	}

	/**
	 * @param tutorEmail
	 *            the tutorEmail to set
	 */
	public void setTutorEmail(String tutorEmail) {
		this.tutorEmail = tutorEmail.replaceAll("[\"]", "");
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
