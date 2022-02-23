package com.srs.lt.dao;

import com.srs.lt.bean.Course;
import com.srs.lt.bean.Professor;
import com.srs.lt.constant.SQLQueriesConstants;
import com.srs.lt.exception.CourseNotAssignedToProfessorException;
import com.srs.lt.exception.CourseNotDeletedException;
import com.srs.lt.exception.CourseNotFoundException;
import com.srs.lt.exception.ProfessorNotAddedException;
import com.srs.lt.exception.UserNotApprovedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.apache.log4j.Logger;
/**
 * 
 * @author Group-2
 * 
 */
public class AdminDaoImplementation implements AdminDao {
	private static final Logger LOGGER = Logger.getLogger(AdminDaoImplementation.class);
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/crs";

	static final String USER = "root";
	static final String PASS = "password";

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet rs = null;

	@Override
	public List<Course> viewCoursesByCatalogId() throws SQLException,CourseNotFoundException {
		List<Course> uniqueCoursesList1 = new ArrayList<Course>();
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(SQLQueriesConstants.VIEW_COURSES_ADMIN);
			rs = statement.executeQuery();

			while (rs.next()) {
				Course c1 = new Course();
				c1.setCourseCode(rs.getString("courseCode"));
				c1.setName(rs.getString("courseName"));
				uniqueCoursesList1.add(c1);
			}

		} catch (Exception e1) {
			LOGGER.error("No Course is present");
		} finally {
			statement.close();
			connection.close();
		}

		return uniqueCoursesList1;
	}

	@Override
	public void addCourse(Course course) throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(SQLQueriesConstants.ASSIGN_COURSES_ADMIN);
			statement.setString(1, course.getCourseCode());
			statement.setString(2, course.getName());
			statement.setInt(3, 0);
			statement.setInt(4, course.getSeats());
			statement.setInt(5, course.getFees());
			statement.execute();
		} catch (Exception e1) {
			LOGGER.error("Unable to add Course");
		} finally {
			statement.close();
			connection.close();
		}
	}

	@Override
	public void addProfessor(Professor professor) throws SQLException,ProfessorNotAddedException {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(SQLQueriesConstants.ADD_USER);
			statement.setInt(1, professor.getUserId());
			statement.setString(2, professor.getName());
			statement.setString(3, professor.getRole());
			statement.setString(4, professor.getPassword());
			statement.execute();
			statement = connection.prepareStatement(SQLQueriesConstants.ADD_PROFESSOR);
			statement.setInt(1, professor.getUserId());
			statement.setString(2, professor.getDepartment());
			statement.setString(3, professor.getDesignation());
			statement.setString(4, professor.getDate());
			statement.execute();
		} catch (Exception e1) {
			LOGGER.error("Unable to add Professor");
		} finally {
			statement.close();
			connection.close();
		}
	}

	@Override
	public void approveStudent(int studentId) throws SQLException,UserNotApprovedException {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(SQLQueriesConstants.APPROVE_STUDENT_ADMIN);
			statement.setInt(1, 1);
			statement.setInt(2, studentId);
			statement.executeUpdate();
		} catch (Exception e1) {
			LOGGER.error("Unable to approve Student");
		} finally {
			statement.close();
			connection.close();
		}
	}

	@Override
	public void assignCourse(String courseCode, String professorId) throws SQLException,CourseNotAssignedToProfessorException {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(SQLQueriesConstants.ADD_PROFESSOR_TO_COURSE_ADMIN);
			statement.setInt(1, Integer.valueOf(professorId));
			statement.setString(2, courseCode);
			statement.executeUpdate();
		} catch (Exception e1) {
			LOGGER.error(e1.getMessage());
		} finally {
			statement.close();
			connection.close();
		}

	}

	@Override
	public void deleteCourse(String courseCode) throws SQLException,CourseNotDeletedException {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(SQLQueriesConstants.DELETE_COURSE_ADMIN);
			statement.setString(1, courseCode);
			statement.execute();
			System.out.println("DELETE");
		} catch (Exception e1) {
			LOGGER.error("Unable to Delete Course");
		} finally {
			statement.close();
			connection.close();
		}
	}

}
