package com.srs.lt.bean;
/**
 * 
 * @author Group-2
 * 
 */
public class Student extends User {
	private int studentId;
	private String branch;
	private String batch;
	private String grade;
	private Boolean isApproved = false;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Boolean getApproved() {
		return isApproved;
	}

	public void setApproved(Boolean approved) {
		isApproved = approved;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String batch) {
		this.grade = grade;
	}

}
