package com.srs.lt.exception;

public class CourseNotAssignedToProfessorException extends Exception{
	public String getMessage() {
		return "Course not assigned to professor.";
	}
	

}
