package PRA;

public class Result {
	private String examModule, assModule, candKey, examMark, examGrade;
	private Student student;

	public Result(String _examModule, String _assModule, String _candKey,
			String _examMark, String _examGrade) {
		examModule = _examModule;
		assModule = _assModule;
		candKey = _candKey;
		examMark = _examMark;
		// possible extension: TODO convert examGrade to enum datatype
		examGrade = _examGrade;
		student = null;
	}
	
	public Result() {
		student = null;
	}

	@Override
	public String toString() {
		return "Result [examModule=" + examModule + ", assModule=" + assModule
				+ ", candKey=" + candKey + ", examMark=" + examMark
				+ ", examGrade=" + examGrade + "]";
	}


	public String getExamModule() {
		return examModule;
	}

	public void setExamModule(String examModule) {
		this.examModule = examModule;
	}

	public String getAssModule() {
		return assModule;
	}

	public void setAssModule(String assModule) {
		this.assModule = assModule;
	}

	public String getCandKey() {
		if(student!=null){
			return student.getStudentNumber();
		}
		return candKey;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	public void setCandKey(String candKey) {
		this.candKey = candKey;
	}

	public String getExamMark() {
		return examMark;
	}

	public void setExamMark(String examMark) {
		this.examMark = examMark;
	}

	public String getExamGrade() {
		return examGrade;
	}

	public void setExamGrade(String examGrade) {
		this.examGrade = examGrade;
	}

}