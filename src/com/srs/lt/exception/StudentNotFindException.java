package com.srs.lt.exception;

public class StudentNotFindException extends Exception{

	public String getMessage() 
	{
		return "Students not found.";
	}
}
