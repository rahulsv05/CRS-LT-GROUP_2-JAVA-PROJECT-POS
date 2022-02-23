/**
 *
 */
package com.srs.lt.business;

import com.srs.lt.bean.Course;
import com.srs.lt.bean.Professor;
import com.srs.lt.exception.CourseNotFoundException;

import java.sql.SQLException;
/**
 * 
 * @author Group-2
 * 
 */
public interface AdminService {

	public void addCourse(Course course);

	public void addProfessor(Professor professor);

	public void approveStudent(int studentId);

	public void assignCourse(String courseCode, String professorId);

	public void deleteCourse(String courseCode);

	public void viewCoursesByCatalogId() throws SQLException, CourseNotFoundException;
}
