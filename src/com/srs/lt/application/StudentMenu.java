package com.srs.lt.application;

import com.srs.lt.bean.Course;
import com.srs.lt.bean.Grade;
import com.srs.lt.business.StudentService;
import com.srs.lt.business.StudentServiceImplementation;
import com.srs.lt.dao.AdminDaoImplementation;
import com.srs.lt.exception.CourseNotFoundException;
import com.srs.lt.exception.GradeNotAddedException;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
/**
 * 
 * @author Group-2
 * 
 */
public class StudentMenu {
	private static final Logger LOGGER = Logger.getLogger(StudentMenu.class);
	Scanner scanner = new Scanner(System.in);
	StudentService studentService = new StudentServiceImplementation();

	public void createMenu(int studentId) throws SQLException, CourseNotFoundException, GradeNotAddedException {
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(String.format("Student is logged in with Id ", studentId));
		System.out.println("Logged in Date and time "+now.format(formatter));
		Boolean userMenuActive = true;
		while (userMenuActive) {
			System.out.println("++++++++++++++++++++Student Menu++++++++++++++++++");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("1. Course Registration");
			System.out.println("2. Add Course");
			System.out.println("3. Drop Course");
			System.out.println("4. View Course");
			System.out.println("5. View Registered Courses");
			System.out.println("6. View grade card");
			System.out.println("7. Make Payment");
			System.out.println("8. Logout");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				registerCourses(studentId);
				break;
			case 2:
				addCourse(studentId);
				break;
			case 3:
				dropCourse(studentId);
				break;
			case 4:
				viewCourses(studentId);
				break;
			case 5:
				viewRegisteredCourse(studentId);
				break;
			case 6:
				viewGradeCard(studentId);
				break;
			case 7:
				make_payment(studentId);
				break;
			case 8:
				userMenuActive = false;
				return;

			default:
				System.out.println("++++++++++ Invalid Choice ++++++++++");
			}
		}
	}

	public void make_payment(int studentId) throws SQLException, CourseNotFoundException {
		List<Course> coursesList = studentService.viewRegisteredCourses(studentId);
		if (coursesList.size() > 0) {
			if (studentService.makePayment(studentId)) {
				System.out.println("PAYMENT DONE");
			}
		} else {
			System.out.println("Currently student is not registered to any courses");
		}
	}

	public void viewGradeCard(int studentId) throws SQLException, GradeNotAddedException {

		List<Grade> gradesList = studentService.viewGradeCard(studentId);
		if (gradesList.size() > 0) {
			for (Grade grade : gradesList) {
				System.out.println("********************************************");
				System.out.println(String.format("StudentID %d",studentId));
				System.out.println(String.format("course Code %s",grade.getCourseCode()));
				System.out.println(String.format("Grade %s",grade.getGrade()));
				System.out.println("********************************************");
			
			}
		} else {
			System.out.println("Currently student is not registered to any courses");
		}

	}

	public void viewRegisteredCourse(int studentId) throws SQLException, CourseNotFoundException {
		List<Course> coursesList = studentService.viewRegisteredCourses(studentId);

		if (coursesList.size() > 0) {
			for (Course course : coursesList) {
				System.out.println(String.format("For StudentID %d ,Course with course Code %s is registered",
						studentId, course.getCourseCode()));
			}
		} else {
			System.out.println("Currently student is not registered to any courses");
		}
	}

	public void viewCourses(int studentId) throws SQLException, CourseNotFoundException {
		List<Course> courses = studentService.viewCourses(studentId);
		if (courses.size() > 0) {
			
			System.out.println("------------------------------------------------");
				System.out.print(String.format("%-20s %-20s","COURSE CODE", "COURSE NAME"));
				System.out.println("------------------------------------------------");
				System.out.println();
				for(Course obj : courses)
				{
					System.out.print(String.format("%-20s %-20s",obj.getCourseCode(), obj.getName()));
				
					System.out.println();
					
				}
			
		} else {
			System.out.println("Currently no courses available");
		}

	}

	public void dropCourse(int studentId) throws SQLException, CourseNotFoundException {
		System.out.println("Enter Course Code:");
		String courseCode = scanner.next();
		Boolean courseStatus = studentService.dropCourse(courseCode, studentId);
		if (courseStatus) {
			System.out.println(
					"Student with studentId " + String.valueOf(studentId) + " dropped from course" + courseCode);
		} else {
			System.out.println("Student with studentId " + String.valueOf(studentId) + " can't be dropped from course"
					+ courseCode);
		}
	}

	public void addCourse(int studentId) throws SQLException, CourseNotFoundException {
		System.out.println("Enter Course Code:");
		String courseCode = scanner.next();
		Boolean courseStatus = studentService.addCourse(courseCode, studentId);
		if (courseStatus) {
			System.out.println("Course successfully added");
		} else {
			System.out.println("Unable to add the course");
		}

	}

	public void registerCourses(int studentId) throws SQLException, CourseNotFoundException {
		System.out.println("Enter no of Courses to be registered:");
		int counter = 0;
		int count = scanner.nextInt();
		while (counter < count) {
			addCourse(studentId);
			counter++;
		}
		System.out.println("Finished registering the courses");
	}

}
