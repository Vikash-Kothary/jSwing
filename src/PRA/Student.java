/*
 * PRA Coursework - Deep Vein Thrombosis
 * @author  Vikash Kothary
 * @author  Toby Birkett
 */
package PRA;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 */
public class Student {

	/** The anonymous marking code. */
	private ArrayList<String> anonymousMarkingCode;
	
	/** The email address. */
	private String emailAddress;
	
	/** The results. */
	private ArrayList<Result> results;
	
	/** The student name. */
	private String studentName;
	
	/** The student number. */
	private String studentNumber;
	
	/** The tutor email. */
	private String tutorEmail;
	
	/** The last accessed. */
	private String lastAccessed;

	/**
	 * Instantiates a new student.
	 */
	public Student() {
		anonymousMarkingCode = new ArrayList<>();
		results = new ArrayList<>();
	}

	/**
	 * Instantiates a new student.
	 *
	 * @param _studentName
	 *            the _student name
	 * @param _studentNumber
	 *            the _student number
	 * @param _emailAddress
	 *            the _email address
	 * @param _tutorEmail
	 *            the _tutor email
	 */
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
	 * Gets the last accessed.
	 *
	 * @return the last accessed
	 */
	public String getLastAccessed() {
		return lastAccessed;
	}

	/**
	 * Sets the last accessed.
	 *
	 * @param lastAccessed
	 *            the new last accessed
	 */
	public void setLastAccessed(String lastAccessed) {
		this.lastAccessed = lastAccessed;
	}

	/**
	 * Adds the anonymous marking code.
	 *
	 * @param aMC
	 *            the a mc
	 * @return true, if successful
	 */
	public boolean addAnonymousMarkingCode(String aMC) {
		aMC = aMC.replaceAll("[\"]", "");
		if (!anonymousMarkingCode.contains(aMC)) {
			anonymousMarkingCode.add(aMC);
			return true;
		}
		return false;
	}

	/**
	 * Adds the results.
	 *
	 * @param result
	 *            the result
	 * @return true, if successful
	 */
	public boolean addResults(Result result) {
		if (!results.contains(result)) {
			results.add(result);
			return true;
		}
		return false;
	}

	/**
	 * Gets the anonymous marking codes.
	 *
	 * @return the anonymous marking codes
	 */
	public ArrayList<String> getAnonymousMarkingCodes() {
		return anonymousMarkingCode;
	}

	/**
	 * Gets the email address.
	 *
	 * @return the email address
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Gets the results.
	 *
	 * @return the results
	 */
	public ArrayList<Result> getResults() {
		return results;
	}
	
	/**
	 * Results size.
	 *
	 * @return the int
	 */
	public int resultsSize(){
		return results.size();
	}
	
	/**
	 * Gets the result.
	 *
	 * @param i
	 *            the i
	 * @return the result
	 */
	public Result getResult(int i){
		return results.get(i);
	}

	/**
	 * Gets the student name.
	 *
	 * @return the student name
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * Gets the student number.
	 *
	 * @return the student number
	 */
	public String getStudentNumber() {
		return studentNumber;
	}

	/**
	 * Gets the tutor email.
	 *
	 * @return the tutor email
	 */
	public String getTutorEmail() {
		return tutorEmail;
	}

	/**
	 * Sets the email address.
	 *
	 * @param emailAddress
	 *            the new email address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress.replaceAll("[\"]", "");
	}

	/**
	 * Sets the student name.
	 *
	 * @param studentName
	 *            the new student name
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName.replaceAll("[\"]", "").replaceAll("#", "");
	}

	/**
	 * Sets the student number.
	 *
	 * @param studentNumber
	 *            the new student number
	 */
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber.replaceAll("[\"]", "");
	}

	/**
	 * Sets the tutor email.
	 *
	 * @param tutorEmail
	 *            the new tutor email
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
