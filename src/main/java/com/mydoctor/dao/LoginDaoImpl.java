package com.mydoctor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.Statement;

/**
 * @author CENTAUR
 * This interface will be used to communicate with the
 * Database
 */
public class LoginDaoImpl
{
	DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public boolean isValidUser(String username, String password) throws SQLException {
		String query = "Select * from user where username = ? and password = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return (resultSet.getInt(1) > 0);
		else
			return false;
	}

	
	public String getUserRole(String username) throws SQLException {
		String query = "Select role from user where username = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, username);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return resultSet.getString(1);
		else
			return null;

	}

	
	public String getId(String username) throws SQLException {
		String query = "Select user_id from user where username = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, username);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return resultSet.getString(1);
		else
			return null;
	}

	public int getPatientPasswordLength(String username) throws SQLException {
		String query = "Select password from user where username = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, username);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return resultSet.getString(1).length();
		else
			return 0;

	}
		
	public int registerUserId(String username, String password)throws SQLException {
		String query = "INSERT INTO user (user_id, username, password, role) VALUES('0',?,?,'patient');";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1,username);
		pstmt.setString(2,password);
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()){
			return rs.getInt(1);
		}
		return -1;

	}
	
	public int registerPatient( String ssn, String name, String surname, String gender, String birth_date, String address, String tel, String email, String hospitalNumber, int user_id)throws SQLException {
		String query ="INSERT INTO `patient` (`patient_id`, `ssn`, `name`, `surname`, `gender`, `birth_date`, `address`, `tel`, `email`, `hospitalNumber`,`user_id` ) "
				+ "VALUES ('0', ?,  ?, ?, ?, ?, ?, ?, ?, ?,?);";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1,ssn);
		pstmt.setString(2,name);
		pstmt.setString(3,surname);
		pstmt.setString(4,gender);
		pstmt.setString(5,birth_date);
		pstmt.setString(6,address);
		pstmt.setString(7,tel);
		pstmt.setString(8,email);
		pstmt.setString(9,hospitalNumber);
		pstmt.setInt(10,user_id);
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()){
			return rs.getInt(1);
		}
		return -1;

	}
	
	public int createUserIdByHN(int user_id, String hospitalNumber) throws SQLException{
		String query = "Update patient Set user_id = ? where hospitalNumber = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, user_id);
		pstmt.setString(2, hospitalNumber);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		return updateCount;
	}
	
	public int createUserIdBySSN(int user_id, String ssn) throws SQLException{
		String query = "Update patient Set user_id = ? where ssn = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, user_id);
		pstmt.setString(2, ssn);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		return updateCount;
	}
}
