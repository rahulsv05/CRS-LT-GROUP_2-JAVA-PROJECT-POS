package com.srs.lt.exception;

public class CourseNotFoundException extends Exception{
	public String getMessage() 
	{
		return "Course not found.";
	}

}
