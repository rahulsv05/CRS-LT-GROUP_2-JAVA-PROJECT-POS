package com.srs.lt.exception;

public class UserNotApprovedException extends Exception{
	public String getMessage() {
		return "User not approved.";
	}

}
