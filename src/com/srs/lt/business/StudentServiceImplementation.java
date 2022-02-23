package com.srs.lt.business;

import com.srs.lt.bean.Course;
import com.srs.lt.bean.Grade;
import com.srs.lt.dao.StudentDao;
import com.srs.lt.dao.StudentDaoImplementation;
import com.srs.lt.exception.CourseNotFoundException;
import com.srs.lt.exception.GradeNotAddedException;

import java.sql.SQLException;
import java.util.List;
/**
 * 
 * @author Group-2
 * 
 */
public class StudentServiceImplementation implements StudentService {
	/*
	 * This is Student service implementation
	 *
	 */

	StudentDao studentDao = new StudentDaoImplementation();

	@Override
	public boolean addCourse(String courseCode, int studentId) throws SQLException, CourseNotFoundException {
		Boolean courseStatus = studentDao.addCourse(courseCode, studentId);
		return courseStatus;
	}

	@Override
	public boolean dropCourse(String courseCode, int studentId) throws SQLException, CourseNotFoundException {
		Boolean courseStatus = studentDao.dropCourse(courseCode, studentId);
		return courseStatus;
	}

	@Override
	public List<Course> viewCourses(int studentId) throws SQLException, CourseNotFoundException {
		return studentDao.viewCourses(studentId);
	}

	@Override
	public List<Course> viewRegisteredCourses(int studentId) throws SQLException, CourseNotFoundException {
		return studentDao.viewRegisteredCourses(studentId);
	}

	@Override
	public List<Grade> viewGradeCard(int studentId) throws SQLException, GradeNotAddedException {
		return studentDao.viewGradeCard(studentId);
	}

	@Override
	public boolean makePayment(int studentId) throws SQLException {
		return studentDao.makePayment(studentId);
	}

}
