package com.srs.lt.business;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.srs.lt.bean.Student;
import com.srs.lt.bean.User;
import com.srs.lt.dao.RegistrationDao;
import com.srs.lt.dao.RegistrationDaoImplementation;
/**
 * 
 * @author Group-2
 * 
 */
public class RegistrationServiceImplementation implements RegistrationService {
	private static final Logger LOGGER = Logger.getLogger(RegistrationServiceImplementation.class);
	RegistrationDao registrationDao=new RegistrationDaoImplementation();

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		try {
			registrationDao.addUser(user);
		} catch (Exception e) {
			LOGGER.error("User can't be added");

		}
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			registrationDao.addStudent(student);
		} catch (Exception e) {
			LOGGER.error("User can't be added");

		}
		}

	@Override
	public boolean updatePassword(int userId, String password) throws SQLException {
		// TODO Auto-generated method stub
		return registrationDao.updatePassword(userId, password);
	}

	@Override
	public User getUserDetails(int userId) throws SQLException {
		// TODO Auto-generated method stub
		return registrationDao.getUserDetails(userId);
	}

	
		
	}

	


		
	


