package PRA;

import java.util.ArrayList;

public class Assessment extends ArrayList<Result> {
	private String examModule, assModule;

	public Assessment(String _examModule, String _assModule) {
		examModule = _examModule;
		assModule = _assModule;
	}

	public boolean addResult(Result result) {
		if (result.getAssModule().equals(assModule)
				&& result.getExamModule().equals(examModule)) {
			add(result);
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) || this.toString().equals(obj.toString());
	}

	public String getAssModule() {
		return assModule;
	}

	/**
	 * @return the examModule
	 */
	public String getExamModule() {
		return examModule;
	}

	public void setAssModule(String assModule) {
		this.assModule = assModule;
	}

	/**
	 * @param examModule
	 *            the examModule to set
	 */
	public void setExamModule(String examModule) {
		this.examModule = examModule;
	}

	@Override
	public String toString() {
		return examModule + " " + assModule;
	}

	// public boolean sameAssessment(Assessment ass){
	// return ass.getAssModule().equals(assModule);
	// }
}
