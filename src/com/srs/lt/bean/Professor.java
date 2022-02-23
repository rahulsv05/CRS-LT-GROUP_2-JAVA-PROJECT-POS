package com.srs.lt.bean;
/**
 * 
 * @author Group-2
 * 
 */
public class Professor extends User {
	private String department;
	private String designation;
	private String date;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
