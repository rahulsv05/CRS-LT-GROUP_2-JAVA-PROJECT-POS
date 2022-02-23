/**
 *
 */
package com.srs.lt.business;

import com.srs.lt.bean.Course;
import com.srs.lt.bean.EnrolledStudent;
import com.srs.lt.exception.CourseNotFoundException;
import com.srs.lt.exception.GradeNotAddedException;
import com.srs.lt.exception.StudentNotFindException;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author Group-2
 * 
 */
public interface ProfessorService {
	public Boolean addGrade(int studentId, String courseCode, String grade) throws SQLException, GradeNotAddedException;

	public List<Course> getCourses(int profId) throws SQLException, CourseNotFoundException;

	public List<EnrolledStudent> viewEnrolledStudents(int profId) throws SQLException, StudentNotFindException;

}
