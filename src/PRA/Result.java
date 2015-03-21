/*
 * PRA Coursework - Deep Vein Thrombosis
 * @author  Vikash Kothary
 * @author  Toby Birkett
 */
package PRA;

// TODO: Auto-generated Javadoc
/**
 * The Class Result.
 */
public class Result {
	
	/** The exam grade. */
	private String examModule, assModule, candKey, examMark, examGrade;
	
	/** The student. */
	private Student student;

	/**
	 * Instantiates a new result.
	 */
	public Result() {
		student = null;
	}

	/**
	 * Instantiates a new result.
	 *
	 * @param _examModule
	 *            the _exam module
	 * @param _assModule
	 *            the _ass module
	 * @param _candKey
	 *            the _cand key
	 * @param _examMark
	 *            the _exam mark
	 * @param _examGrade
	 *            the _exam grade
	 */
	public Result(String _examModule, String _assModule, String _candKey,
			String _examMark, String _examGrade) {
		examModule = _examModule.replaceAll("[\"]", "").replaceAll("#", "");
		assModule = _assModule.replaceAll("[\"]", "").replaceAll("#", "");
		candKey = _candKey.replaceAll("[\"]", "").replaceAll("#", "");
		examMark = _examMark.replaceAll("[\"]", "");
		// possible extension: TODO convert examGrade to enum datatype
		examGrade = _examGrade.replaceAll("[\"]", "");
		student = null;
	}

	/**
	 * Gets the ass module.
	 *
	 * @return the ass module
	 */
	public String getAssModule() {
		return assModule;
	}

	/**
	 * Gets the cand key.
	 *
	 * @return the cand key
	 */
	public String getCandKey() {
		if (student != null) {
			return student.getStudentNumber();
		}
		return candKey;
	}

	/**
	 * Gets the exam grade.
	 *
	 * @return the exam grade
	 */
	public String getExamGrade() {
		return examGrade;
	}

	/**
	 * Gets the exam mark.
	 *
	 * @return the exam mark
	 */
	public String getExamMark() {
		return examMark;
	}

	/**
	 * Gets the exam module.
	 *
	 * @return the exam module
	 */
	public String getExamModule() {
		return examModule;
	}

	/**
	 * Gets the student.
	 *
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * Sets the ass module.
	 *
	 * @param assModule
	 *            the new ass module
	 */
	public void setAssModule(String assModule) {
		this.assModule = assModule.replaceAll("[\"]", "").replaceAll("#", "");
	}

	/**
	 * Sets the cand key.
	 *
	 * @param candKey
	 *            the new cand key
	 */
	public void setCandKey(String candKey) {
		this.candKey = candKey.replaceAll("[\"]", "").replaceAll("#", "");
	}

	/**
	 * Sets the exam grade.
	 *
	 * @param examGrade
	 *            the new exam grade
	 */
	public void setExamGrade(String examGrade) {
		this.examGrade = examGrade.replaceAll("[\"]", "");
	}

	/**
	 * Sets the exam mark.
	 *
	 * @param examMark
	 *            the new exam mark
	 */
	public void setExamMark(String examMark) {
		this.examMark = examMark.replaceAll("[\"]", "");
	}

	/**
	 * Sets the exam module.
	 *
	 * @param examModule
	 *            the new exam module
	 */
	public void setExamModule(String examModule) {
		this.examModule = examModule.replaceAll("[\"]", "").replaceAll("#", "");
	}

	/**
	 * Sets the student.
	 *
	 * @param student
	 *            the new student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String returnString = "Exam Module: " + examModule + "<br/>" + "Mark: " + examMark + "<br/>";
		if (examGrade.equals( "")){
			
		} else {
			returnString += "Grade: " + examGrade + "<br/>";
		}
		
		return returnString;
	}
	
	

}