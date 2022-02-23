package com.srs.lt.business;

import java.sql.SQLException;

import com.srs.lt.bean.Student;
import com.srs.lt.bean.User;
/**
 * 
 * @author Group-2
 * 
 */
public interface RegistrationService {
	public void addUser(User user);
	public void addStudent(Student student);
	public boolean updatePassword(int userId,String password) throws SQLException;
	public User getUserDetails(int userId) throws SQLException;

}
