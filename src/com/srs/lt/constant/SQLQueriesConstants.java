package com.srs.lt.constant;

public class SQLQueriesConstants {
	public static final String VIEW_PROFESSOR_COURSES = " select courseCode, courseName from course where instructorId = ?";
	public static final String VIEW_ENROLLED_STUDENTS = "select course.courseCode,course.courseName,registeredcourse.studentId from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where course.instructorId = ? order by course.courseCode";
	public static final String ADD_GRADE = "update registeredcourse set Grade=? where courseCode=? and studentId=?";
	public static final String VIEW_COURSES_ADMIN = "select courseCode, courseName from course";
	public static final String VIEW_COURSES_ALL = "select * from course";
	public static final String ADD_PROFESSOR_TO_COURSE_ADMIN = "update course set instructorId=? where courseCode=?";
	public static final String ASSIGN_COURSES_ADMIN = "insert into course (courseCode, courseName, instructorId,seat,fee)"
			+ "values(?,?,?,?,?)";
	public static final String APPROVE_STUDENT_ADMIN = "update student set isApproved =? where student_id=?";
	public static final String ADD_USER = "insert into user(user_id, name, role, password)\r\n" + "values(?,?,?,?)";
	public static final String ADD_PROFESSOR = "insert into professor(user_id, department, designation, DOJ)\r\n"
			+ "values(?,?,?,?);";
	public static final String ADD_STUDENT = "insert into student(student_id, branch, batch, isApproved)"
			+ "values(?,?,?,?)";
	public static final String DELETE_COURSE_ADMIN = "delete from course where courseCode = ?";
	public static final String ADD_COURSE_STUDENT = "insert into registeredcourse(courseCode, courseName, studentId, Grade)"
			+ "values (?,?,?,?)";
	public static final String DROP_COURSE_STUDENT = "delete from registeredcourse where courseCode =? and studentId=?";
	public static final String VIEW_REGISTERED_COURSES_STUDENT = " select courseCode, courseName from registeredcourse where studentId = ?";
	public static final String GET_TOTAL_FEE = "select registeredcourse.studentId,course.fee from registeredcourse \r\n"
			+ "inner join course on registeredcourse.courseCode=course.courseCode and registeredcourse.studentId=?";
	public static final String PAYMENT_RECORD = "insert into payment(studentId, amount, status)"
			+ "values(?,?,?)";
	public static final String VIEW_GRADE = "select courseCode, courseName, Grade from registeredcourse where studentId=?";
	public static final String UPDATE_PASSWORD ="update user set password=? where user_id=?";
	public static final String GET_USER_DETAILS ="select * from user where user_id=?";
}
