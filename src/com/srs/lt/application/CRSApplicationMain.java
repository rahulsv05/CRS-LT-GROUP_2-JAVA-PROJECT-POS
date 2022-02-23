package com.srs.lt.application;

import com.srs.lt.bean.Student;
import com.srs.lt.bean.User;
import com.srs.lt.business.RegistrationService;
import com.srs.lt.business.RegistrationServiceImplementation;

import java.sql.SQLException;
import java.util.Scanner;
/**
 * 
 * @author Group-2
 * 
 */
public class CRSApplicationMain {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("*****************************************************************");
		System.out.println("           THIS IS THE MENU CLASS FOR CRS APPLICATION");
		System.out.println("*****************************************************************");
		// Testing admin implementation
		RegistrationService registrationService = new RegistrationServiceImplementation();
		AdminMenu am1 = new AdminMenu();
		ProfessorMenu pm1 = new ProfessorMenu();
		StudentMenu sm1 = new StudentMenu();
		getCRSMenu();
		System.out.println("Enter user input");
		int userInput = scanner.nextInt();

		// until user do not exit the application
		while (userInput != 4) {
			switch (userInput) {
			case 1:
				// Student Menu
				System.out.println("Enter  UserId: ");
				int userId = scanner.nextInt();
				if (registrationService.getUserDetails(userId).getUserId() <= 0) {
					System.out.println("Register as new user");
					break;
				}
				System.out.println("Enter Password: ");
				String password = scanner.next();
				if (!registrationService.getUserDetails(userId).getPassword().matches(password)) {
					System.out.println("Enter correct Password!!");
					break;
				}
				if (registrationService.getUserDetails(userId).getRole().equalsIgnoreCase("student")) {
					try {
						sm1.createMenu(userId);
					} catch (Exception e) {
						System.out.println("Provide valid input, falling back to main menu");
					}
					break;
				}
				// Professor Menu Check
				if (registrationService.getUserDetails(userId).getRole().equalsIgnoreCase("professor")) {
					try {
						pm1.createMenu(userId);
					} catch (Exception e) {
						System.out.println("Provide valid input, falling back to main menu");
					}
					break;
				}
				// Admin Menu Check
				if (registrationService.getUserDetails(userId).getRole().equalsIgnoreCase("admin")) {
					try {
						am1.createMenu(userId);
					} catch (Exception e) {
						System.out.println("Provide valid input, falling back to main menu");
					}

					break;
				}

				break;
			case 2:
				// Update Password
				System.out.println("Enter User ID");
				int user_Id = scanner.nextInt();
				System.out.println("Enter New Password: ");
				String pswd = scanner.next();
				registrationService.updatePassword(user_Id, pswd);
				break;
			case 3:
				String s = "Student";

				User user1 = new User();
				System.out.println("Enter User ID");
				int userId1 = scanner.nextInt();
				user1.setUserId(userId1);
				System.out.println("Enter Name: ");
				String name1 = scanner.next();
				user1.setName(name1);
				System.out.println("Enter Password: ");
				String password1 = scanner.next();
				user1.setPassword(password1);
				System.out.println("Enter  Role: ");
				String role1 = scanner.next();
				user1.setRole(role1);
				registrationService.addUser(user1);
				if (user1.getRole().equalsIgnoreCase(s)) {
					Student student = new Student();
					student.setStudentId(userId1);
					System.out.println("Enter Branch:");
					String branch = scanner.next();
					student.setBranch(branch);
					System.out.println("Enter Batch:");
					String batch = scanner.next();
					student.setBatch(batch);

					registrationService.addStudent(student);
				}

				break;
			default:
				System.out.println("Invalid Input");
			}

			getCRSMenu();
			userInput = scanner.nextInt();
		}
	}

	private static void getCRSMenu() {
		System.out.println("---------- Welcome to CRS System---------");
		System.out.println("1. Login");
		System.out.println("2. Update Password");
		System.out.println("3. Student Registration");
		System.out.println("4. Exit");

	}

}
