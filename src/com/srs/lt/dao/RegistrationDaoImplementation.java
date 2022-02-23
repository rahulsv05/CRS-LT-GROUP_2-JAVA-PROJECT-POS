package com.srs.lt.dao;

import com.srs.lt.bean.Student;
import com.srs.lt.bean.User;
import com.srs.lt.constant.SQLQueriesConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
/**
 * 
 * @author Group-2
 * 
 */
public class RegistrationDaoImplementation implements RegistrationDao {
	private static final Logger LOGGER = Logger.getLogger(AdminDaoImplementation.class);
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/crs";

	static final String USER = "root";
	static final String PASS = "password";

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet rs = null;

	@Override
	public void addUser(User user) throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(SQLQueriesConstants.ADD_USER);
			statement.setInt(1, user.getUserId());
			statement.setString(2,user.getName());
			statement.setString(3, user.getRole());
			statement.setString(4, user.getPassword());
			statement.execute();
			

		} catch (Exception e1) {
			LOGGER.error("User is not added");
		} finally {
			statement.close();
			connection.close();
		}
		
	}

	@Override
	public void addStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(SQLQueriesConstants.ADD_STUDENT);
			statement.setInt(1, student.getStudentId());
			statement.setString(2,student.getBranch());
			statement.setString(3, student.getBatch());
			statement.setInt(4, 0);
			statement.execute();
			

		} catch (Exception e1) {
			LOGGER.error("Student is not added");
		} finally {
			statement.close();
			connection.close();
		}
		
	}

	@Override
	public boolean updatePassword(int userId, String password) throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(SQLQueriesConstants.UPDATE_PASSWORD);
			statement.setString(1,password);
			statement.setInt(2, userId);
			statement.executeUpdate();
			return true;

		} catch (Exception e1) {
			LOGGER.error("Password not Updated");
		} finally {
			statement.close();
			connection.close();
		}
		return false;
	}

	@Override
	public User getUserDetails(int userId) throws SQLException {
		try {
			User user = new User();
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(SQLQueriesConstants.GET_USER_DETAILS);
			statement.setInt(1, userId);
			rs=statement.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				user.setPassword(rs.getString("password"));
			}
			return user;

		} catch (Exception e1) {
			LOGGER.error("User is not present");
		} finally {
			statement.close();
			connection.close();
		}
		return null;
	}


	
   
}
