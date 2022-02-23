package com.srs.lt.business;

import com.srs.lt.bean.Course;
import com.srs.lt.bean.EnrolledStudent;
import com.srs.lt.dao.ProfessorDao;
import com.srs.lt.dao.ProfessorDaoImplementation;
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
public class ProfessorServiceImplementation implements ProfessorService {
	/*
	 * This is professor service implementation
	 *
	 */
	ProfessorDao professorDao = new ProfessorDaoImplementation();

	@Override
	public Boolean addGrade(int studentId, String courseCode, String grade) throws SQLException, GradeNotAddedException {
		return professorDao.addGrade(studentId, courseCode, grade);
	}

	@Override
	public List<Course> getCourses(int profId) throws SQLException, CourseNotFoundException {
		List<Course> professorCourses = professorDao.getCoursesByProfessorId(profId);
		return professorCourses;
	}

	@Override
	public List<EnrolledStudent> viewEnrolledStudents(int profId) throws SQLException, StudentNotFindException {
		return professorDao.getEnrolledStudents(profId);
	}

}
