/*
 * PRA Coursework - Deep Vein Thrombosis
 * @author  Vikash Kothary
 * @author  Toby Birkett
 */
package PRA;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Assessment.
 */
public class Assessment extends ArrayList<Result> {
	
	/** The ass module. */
	private String examModule, assModule;

	/**
	 * Instantiates a new assessment.
	 *
	 * @param _examModule
	 *            the _exam module
	 * @param _assModule
	 *            the _ass module
	 */
	public Assessment(String _examModule, String _assModule) {
		examModule = _examModule;
		assModule = _assModule;
	}

	/**
	 * Adds the result.
	 *
	 * @param result
	 *            the result
	 * @return true, if successful
	 */
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

	/**
	 * Gets the ass module.
	 *
	 * @return the ass module
	 */
	public String getAssModule() {
		return assModule;
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
	 * Sets the ass module.
	 *
	 * @param assModule
	 *            the new ass module
	 */
	public void setAssModule(String assModule) {
		this.assModule = assModule;
	}

	/**
	 * Sets the exam module.
	 *
	 * @param examModule
	 *            the new exam module
	 */
	public void setExamModule(String examModule) {
		this.examModule = examModule;
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#toString()
	 */
	@Override
	public String toString() {
		return examModule + " " + assModule;
	}

	// public boolean sameAssessment(Assessment ass){
	// return ass.getAssModule().equals(assModule);
	// }
}
