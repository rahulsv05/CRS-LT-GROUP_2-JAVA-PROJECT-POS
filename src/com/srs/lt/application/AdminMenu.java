package com.srs.lt.application;

import com.srs.lt.bean.Course;
import com.srs.lt.bean.Professor;
import com.srs.lt.business.AdminService;
import com.srs.lt.business.AdminServiceImplementation;
import com.srs.lt.exception.CourseNotFoundException;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
/**
 * 
 * @author Group-2
 * 
 */
public class AdminMenu {
	Scanner scanner = new Scanner(System.in);
	AdminService adminService = new AdminServiceImplementation();

	public void createMenu(int adminId) throws SQLException, CourseNotFoundException {
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Admin is logged in with Id " + adminId);
		System.out.println("Logged in Date and time "+now.format(formatter));
		Boolean adminMenuActive = true;

		while (adminMenuActive) {
			System.out.println("+++++++++++   Admin Menu   +++++++++++");
			System.out.println("1. View course");
			System.out.println("2. Add Course");
			System.out.println("3. Delete Course");
			System.out.println("4. Approve Student");
			System.out.println("5. Add Professor");
			System.out.println("6. Assign Courses To Professor");
			System.out.println("7. Exit admin menu");
			System.out.println("++++++++++++++++++++++++++++++++++++++++");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				viewCoursesInCatalogue();
				break;
			case 2:
				addCourseToCatalogue();
				break;
			case 3:
				deleteCourse();
				break;
			case 4:
				approveStudent();
				break;
			case 5:
				addProfessor();
				break;
			case 6:
				assignCourseToProfessor();
				break;
			case 7:
				adminMenuActive = false;
				return;
			default:
				System.out.println("***** Invalid Choice *****");
			}
		}
	}

	public void viewCoursesInCatalogue() throws SQLException, CourseNotFoundException {
		adminService.viewCoursesByCatalogId();
	}

	public void addCourseToCatalogue() {
		System.out.println("Enter Course Code:");
		String courseCode = scanner.next();
		scanner.nextLine();
		System.out.println("Enter Course Name:");
		String courseName = scanner.next();
		scanner.nextLine();
		System.out.println("Enter Number Of Seats:");
		int seat = scanner.nextInt();
		System.out.println("Enter Course Fees:");
		int fees = scanner.nextInt();
		Course course = new Course();
		course.setCourseCode(courseCode);
		course.setName(courseName);
		course.setSeats(seat);
		course.setFees(fees);
		adminService.addCourse(course);

	}

	public void deleteCourse() {
		System.out.println("Enter Course Code for deletion:");
		String courseCode = scanner.next();
		// String catalogId = "Test1";
		adminService.deleteCourse(courseCode);
	}

	public void addProfessor() {
		System.out.println("Enter Professor ID:");
		int prof_id = scanner.nextInt();
		System.out.println("Enter Professor Name:");
		String name = scanner.next();
		System.out.println("Enter designation:");
		String designation = scanner.next();
		System.out.println("Enter department:");
		String department = scanner.next();
		System.out.println("Enter password:");
		String password = scanner.next();
		Professor p1 = new Professor();
		p1.setUserId(prof_id);
		p1.setName(name);
		p1.setDepartment(department);
		p1.setDesignation(designation);
		p1.setRole("professor");
		p1.setDate(String.valueOf(java.time.LocalDate.now()));
		p1.setPassword(password);
		adminService.addProfessor(p1);

	}

	public void assignCourseToProfessor() {
		System.out.println("Enter Course Code: ");
		String courseCode = scanner.next();
		System.out.println("Enter ProfessorId: ");
		String professorId = scanner.next();
		adminService.assignCourse(courseCode, professorId);
	}

	public void approveStudent() {
		System.out.println("Enter StudentId for approval: ");
		int studentId = scanner.nextInt();
		adminService.approveStudent(studentId);
	}

}
