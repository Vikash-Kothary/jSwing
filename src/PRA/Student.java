package PRA;

public class Student {

	private String firstName;
	private String lastName;
	private String studentNumber;
	private String emailAddress;
	private String tutorEmail;
	
	public Student(String _firstName, String _lastName, String _studentNumber, String _emailAddress, String _tutorEmail){
		firstName = _firstName;
		lastName = _lastName;
		studentNumber = _studentNumber;
		emailAddress = _emailAddress;
		tutorEmail = _tutorEmail;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName(){
		return this.firstName + " " + this.lastName;
	}
	
	/**
	 * @return the studentNumber
	 */
	public String getStudentNumber() {
		return studentNumber;
	}

	/**
	 * @param studentNumber the studentNumber to set
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
	 * @param emailAddress the emailAddress to set
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
	 * @param tutorEmail the tutorEmail to set
	 */
	public void setTutorEmail(String tutorEmail){
		this.tutorEmail = tutorEmail;
	}
	
	
	
}

