package com.mydoctor.service;

import java.sql.SQLException;

import com.mydoctor.dao.LoginDaoImpl;



public class LoginServiceImpl 
{
		
		
		private LoginDaoImpl loginDaoImpl;
		
		public LoginDaoImpl getLoginDaoImpl() {
			return loginDaoImpl;
		}
		public void setLoginDaoImpl(LoginDaoImpl loginDaoImpl) {
			this.loginDaoImpl = loginDaoImpl;
		}

		public boolean isValidUser(String username, String password) throws SQLException
		{
				return loginDaoImpl.isValidUser(username, password);
		}

		public String getUserRole(String username) throws SQLException {
				return loginDaoImpl.getUserRole(username);
		}
		
		

}
