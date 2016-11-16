package com.mydoctor.service;

import java.sql.SQLException;

import com.mydoctor.dao.UserDao;
import com.mydoctor.model.Patient;


public class PatientServiceImpl implements UserService
{
		
		
		private UserDao userDao;
		
		public UserDao getUserDao() {
			return userDao;
		}
		public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
		}
		
		@Override
		public boolean isValidUser(String username, String password) throws SQLException
		{
				return userDao.isValidUser(username, password);
		}
		@Override
		public String getUserRole(String username) throws SQLException {
				return userDao.getUserRole(username);
		}
		@Override
		public Patient retrieveUser(String username) throws SQLException {
				return userDao.getPatient(username);
		}
		

}
