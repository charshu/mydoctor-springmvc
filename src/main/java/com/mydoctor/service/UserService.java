/**
 *
 */
package com.mydoctor.service;

import java.sql.SQLException;


import com.mydoctor.model.User;

/**
 * @author CENTAUR
 *
 */
public interface UserService
{
	public boolean isValidUser(String username, String password) throws SQLException;
	public String getUserRole(String username) throws SQLException;
	public User retrieveUser(String username)throws SQLException;
		
}
