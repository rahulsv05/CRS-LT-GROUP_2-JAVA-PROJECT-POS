package com.srs.lt.exception;

public class UserNotFoundException extends Exception{
	public String getMessage() {
		return "User not found.";
	}

}
