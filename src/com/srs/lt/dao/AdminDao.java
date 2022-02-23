package com.srs.lt.dao;

import com.srs.lt.bean.Course;
import com.srs.lt.bean.Professor;
import com.srs.lt.exception.CourseNotAssignedToProfessorException;
import com.srs.lt.exception.CourseNotDeletedException;
import com.srs.lt.exception.CourseNotFoundException;
import com.srs.lt.exception.ProfessorNotAddedException;
import com.srs.lt.exception.UserNotApprovedException;

import java.sql.SQLException;
import java.util.List;
/**
 * 
 * @author Group-2
 * 
 */
public interface AdminDao {
	public List<Course> viewCoursesByCatalogId() throws SQLException, CourseNotFoundException;

	public void addCourse(Course course) throws SQLException;

	public void addProfessor(Professor professor) throws SQLException, ProfessorNotAddedException;

	public void approveStudent(int studentId) throws SQLException, UserNotApprovedException;

	public void assignCourse(String courseCode, String professorId) throws SQLException, CourseNotAssignedToProfessorException;

	public void deleteCourse(String courseCode) throws SQLException, CourseNotDeletedException;

}
