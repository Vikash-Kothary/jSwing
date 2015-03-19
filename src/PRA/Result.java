package PRA;

public class Result {
	private String examModule, assModule, candKey, examMark, examGrade;

	public Result(String _examModule, String _assModule, String _candKey,
			String _examMark, String _examGrade) {
		examModule = _examModule;
		assModule = _assModule;
		candKey = _candKey;
		examMark = _examMark;
		// TODO convert examGrade to enum datatype
		examGrade = _examGrade;
	}

	@Override
	public String toString() {
		return "Result [examModule=" + examModule + ", assModule=" + assModule
				+ ", candKey=" + candKey + ", examMark=" + examMark
				+ ", examGrade=" + examGrade + "]";
	}

	public Result() {
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
		return candKey;
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