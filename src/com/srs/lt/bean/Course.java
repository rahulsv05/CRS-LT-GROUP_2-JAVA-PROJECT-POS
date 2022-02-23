package com.srs.lt.bean;


/**
 * 
 * @author Group-2
 * 
 */
public class Course {
	private String courseCode;
	private String name;
	private Boolean isOffered;
	private String instructorId;
	private int seats;
	private int fees;

	public Course() {

	}

	public Course(String courseCode, String courseName, String instructorId, int seats,int fees) {
		super();
		this.courseCode = courseCode;
		this.name = courseName;
		this.setInstructorId(instructorId);
		this.seats = seats;
		this.fees=fees;
	}
	
	

	public Boolean getIsOffered() {
		return isOffered;
	}

	public void setIsOffered(Boolean isOffered) {
		this.isOffered = isOffered;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getOffered() {
		return isOffered;
	}

	public void setOffered(Boolean offered) {
		isOffered = offered;
	}

	public String getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
}
