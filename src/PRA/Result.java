package PRA;

public class Result {
	private String examModule, assModule, candKey, examMark, examGrade;
	private Student student;

	public Result() {
		student = null;
	}
	
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

	public String getAssModule() {
		return assModule;
	}


	public String getCandKey() {
		if(student!=null){
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
		this.assModule = assModule;
	}

	public void setCandKey(String candKey) {
		this.candKey = candKey;
	}

	public void setExamGrade(String examGrade) {
		this.examGrade = examGrade;
	}

	public void setExamMark(String examMark) {
		this.examMark = examMark;
	}

	public void setExamModule(String examModule) {
		this.examModule = examModule;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Result [examModule=" + examModule + ", assModule=" + assModule
				+ ", candKey=" + candKey + ", examMark=" + examMark
				+ ", examGrade=" + examGrade + "]";
	}

}