package com.srs.lt.dao;

import com.srs.lt.bean.Course;
import com.srs.lt.bean.EnrolledStudent;
import com.srs.lt.exception.CourseNotFoundException;
import com.srs.lt.exception.GradeNotAddedException;
import com.srs.lt.exception.StudentNotFindException;

import java.util.List;
import java.sql.SQLException;
/**
 * 
 * @author Group-2
 * 
 */
public interface ProfessorDao {

	public List<Course> getCoursesByProfessorId(int userId) throws SQLException, CourseNotFoundException;

	public List<EnrolledStudent> getEnrolledStudents(int profId) throws SQLException, StudentNotFindException;

	public Boolean addGrade(int studentId, String courseCode, String grade) throws SQLException, GradeNotAddedException;

}
