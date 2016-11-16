/**
 *
 */
package com.mydoctor.service;

import java.sql.SQLException;


public interface UserService
{
	public boolean isValidUser(String username, String password) throws SQLException;
	public String getUserRole(String username) throws SQLException;
	
		
}
