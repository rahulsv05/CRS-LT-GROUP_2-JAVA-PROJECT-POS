package com.srs.lt.dao;

import com.srs.lt.bean.Course;
import com.srs.lt.bean.Grade;
import com.srs.lt.exception.CourseNotFoundException;
import com.srs.lt.exception.GradeNotAddedException;

import java.sql.SQLException;
import java.util.List;
/**
 * 
 * @author Group-2
 * 
 */
public interface StudentDao {
	public boolean addCourse(String courseCode, int studentId) throws SQLException, CourseNotFoundException;

	public boolean dropCourse(String courseCode, int studentId) throws SQLException, CourseNotFoundException;

	public List<Course> viewCourses(int studentId) throws SQLException, CourseNotFoundException;

	public List<Course> viewRegisteredCourses(int studentId) throws SQLException, CourseNotFoundException;

	public List<Grade> viewGradeCard(int studentId) throws SQLException, GradeNotAddedException;

	public boolean makePayment(int studentId) throws SQLException;

}
