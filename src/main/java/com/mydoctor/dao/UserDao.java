package com.mydoctor.dao;

import java.sql.SQLException;

import com.mydoctor.model.Patient;

/**
 * @author CENTAUR
 * This interface will be used to communicate with the
 * Database
 */
public interface UserDao
{
		public boolean isValidUser(String username, String password) throws SQLException;
		public String getUserRole(String username) throws SQLException;
		public String getPatientID(String username)throws SQLException ;
		public Patient getPatient(String username) throws SQLException;
		
}
