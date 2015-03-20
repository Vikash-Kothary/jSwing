package PRA;

public class Result {
	private String examModule, assModule, candKey, examMark, examGrade;
	private Student student;

	public Result() {
		student = null;
	}

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

	public String getAssModule() {
		return assModule;
	}

	public String getCandKey() {
		if (student != null) {
			return student.getStudentNumber();
		}
		return candKey;
	}

	public String getExamGrade() {
		return examGrade;
	}

	public String getExamMark() {
		return examMark;
	}

	public String getExamModule() {
		return examModule;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	public void setAssModule(String assModule) {
		this.assModule = assModule.replaceAll("[\"]", "").replaceAll("#", "");
	}

	public void setCandKey(String candKey) {
		this.candKey = candKey.replaceAll("[\"]", "").replaceAll("#", "");
	}

	public void setExamGrade(String examGrade) {
		this.examGrade = examGrade.replaceAll("[\"]", "");
	}

	public void setExamMark(String examMark) {
		this.examMark = examMark.replaceAll("[\"]", "");
	}

	public void setExamModule(String examModule) {
		this.examModule = examModule.replaceAll("[\"]", "").replaceAll("#", "");
	}

	/**
	 * @param student
	 *            the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	


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