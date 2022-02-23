package com.srs.lt.application;

import com.srs.lt.bean.Course;
import com.srs.lt.bean.EnrolledStudent;
import com.srs.lt.business.ProfessorService;
import com.srs.lt.business.ProfessorServiceImplementation;
import com.srs.lt.exception.CourseNotFoundException;
import com.srs.lt.exception.StudentNotFindException;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author Group-2
 * 
 */
public class ProfessorMenu {
	ProfessorService professorService = new ProfessorServiceImplementation();
	Scanner scanner = new Scanner(System.in);

	public void createMenu(int profId) {
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Professor is logged in with Id : " + profId);
		System.out.println("Logged in Date and time "+now.format(formatter));
		Boolean professorMenuActive = true;
		int input;
		while (professorMenuActive) {
			System.out.println("++++++++++++++++++++Professor Menu++++++++++++++++++");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("1. View Courses");
			System.out.println("2. View Enrolled Students");
			System.out.println("3. Add grade");
			System.out.println("4. Exit professor Menu");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

			// input user
			input = scanner.nextInt();
			switch (input) {
			case 1:
				// view courses taught by professor
				try {
					getCourses(profId);
				} catch (Exception e) {
					System.out.println("Please provide proper inputs");
				}
				break;
			case 2:
				// view enrolled students for the course
				try {
					viewEnrolledStudents(profId);
				} catch (Exception e) {
					System.out.println("Please provide proper inputs");
				}
				break;
			case 3:
				// add grade for a student
				try {
					addGrade(profId);
				} catch (Exception e) {
					System.out.println("Please provide proper inputs");
				}
				break;
			case 4:
				professorMenuActive = false;
				return;
			default:
				System.out.println("++++++++++ Invalid Choice ++++++++++");
			}
		}

	}

	public void getCourses(int profId) throws SQLException, CourseNotFoundException {
		//System.out.println("GET COURSES METHOD CALLED");

		List<Course> courses = professorService.getCourses(profId);
		System.out.println("------------------------------------------------");
		System.out.print(String.format("%-20s %-20s","COURSE CODE", "COURSE NAME"));
		System.out.println();
		System.out.println("------------------------------------------------");
		for (Course course : courses) {
			System.out.print(String.format("%-20s %-20s",course.getCourseCode(), course.getName()));
			
			System.out.println();
		}
	}

	public void addGrade(int profId) throws SQLException {
		System.out.println("ADD GRADES METHOD CALLED");

		try {
			System.out.println("Enter Course Code:");
			String courseCode = scanner.next();
			System.out.println("Enter Student Id:");
			int studentId = scanner.nextInt();
			System.out.println("Enter Grade:");
			String grade = scanner.next();
			scanner.nextLine();

			Boolean isGradeAdded = professorService.addGrade(studentId, courseCode, grade);
			if (isGradeAdded) {
				System.out.println("Grade succesfully added for Student: " + String.valueOf(studentId));
			} else {
				System.out.println("Grade not updated for Student: " + String.valueOf(studentId));
			}
		} catch (Exception e) {
			System.out.println("Please provide proper inputs");
		}
	}

	public void viewEnrolledStudents(int profId) throws SQLException, StudentNotFindException {
		System.out.println("VIEW COURSES ENROLLED METHOD IS CALLED");

		List<EnrolledStudent> enrolledStudentList = professorService.viewEnrolledStudents(profId);
		System.out.println("------------------------------------------------");
		System.out.print(String.format("%-20s %-20s","COURSE CODE", "COURSE NAME"));
		System.out.println();
		System.out.println("------------------------------------------------");
		for (EnrolledStudent enrolledStudent : enrolledStudentList) {

			System.out.print(String.format("%-20s %-20s",String.valueOf(enrolledStudent.getStudentId()), String.valueOf(enrolledStudent.getCourseCode())));
			
			System.out.println();
		}
	}

}