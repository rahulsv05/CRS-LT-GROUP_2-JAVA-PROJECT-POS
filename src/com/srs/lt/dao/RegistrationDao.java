package com.srs.lt.dao;

import java.sql.SQLException;

import com.srs.lt.bean.Student;
import com.srs.lt.bean.User;
/**
 * 
 * @author Group-2
 * 
 */
public interface RegistrationDao {
	public void addUser(User user) throws SQLException;
	public void addStudent(Student student) throws SQLException;
	public boolean updatePassword(int userId,String password) throws SQLException;
	public User getUserDetails(int userId) throws SQLException;
}
