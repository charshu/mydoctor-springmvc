package com.mydoctor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import java.sql.Connection;
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


	public boolean isValidUser(String username, String password) {
		Connection conn = null;
		try{
		conn = dataSource.getConnection();
		String query = "Select * from user where username = ? and password = ?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return (resultSet.getInt(1) > 0);
		else
			return false;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
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
		
	public int registerUserId(String username, String password,String role) {
		try{
		String query = "INSERT INTO user (user_id, username, password, role) VALUES('0',?,?,?);";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1,username);
		pstmt.setString(2,password);
		pstmt.setString(3,role);
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()){
			return rs.getInt(1);
		}
		return -1;
		}catch(SQLException e){
			System.out.println(e.getMessage());
			return -2;
		}
		
	}
	
	public int registerPatient( String ssn, String name, String surname, String gender, String birth_date, String address, String tel, String email, String hospitalNumber, int user_id)throws SQLException {
		try{
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
		catch(SQLException e){
			System.out.println(e.getMessage());
			if(e.getMessage().contains("for key 'ssn'")){
				deleteUserId(user_id);
				return -3;
			}
			else if(e.getMessage().contains("for key 'email'")){
				deleteUserId(user_id);
				return -4;
			}
			
			else return -5;
		}

	}
	public int deleteUserId(int user_id)throws SQLException{
		String query = "DELETE FROM user "
				+ "WHERE user_id = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, user_id);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		if (updateCount > 0)
			return updateCount;
		return -1;
	}
	public int createUserIdByHN(int user_id, String hospitalNumber) throws SQLException{
		try{
		String query = "Update patient Set user_id = ? where hospitalNumber = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, user_id);
		pstmt.setString(2, hospitalNumber);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		return updateCount;
		}
		catch(SQLException e){
			deleteUserId(user_id);
			return -7;
		}
	}
	
	public int createUserIdBySSN(int user_id, String ssn) throws SQLException{
		try{
		String query = "Update patient Set user_id = ? where ssn = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, user_id);
		pstmt.setString(2, ssn);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		return updateCount;
		}catch(SQLException e){
			deleteUserId(user_id);
			return -7;
		}
	}
	public int hasUserIdByHN(String hospitalNumber)throws SQLException{
		String query = "Select user_id from patient where hospitalNumber = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, hospitalNumber);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next()){
			return resultSet.getInt(1);
		}
		else
			return -1;
	}
	public int hasUserIdBySSN(String ssn)throws SQLException{
		String query = "Select user_id from patient where ssn = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, ssn);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return resultSet.getInt(1);
		else
			return -1;
	}
	public int insertNurse(int nurse_id,String name,String surname) {
		try{
		String query = "INSERT INTO nurse (nurse_id, name,surname)" + "VALUES (?,?,?);";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1,nurse_id);
		pstmt.setString(2,name);
		pstmt.setString(3,surname);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		if(updateCount>0)return updateCount;
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()){
			return rs.getInt(1);
		}
		return -1;
		}catch(SQLException e){
			System.out.println(e.getMessage());
			return -8; //insert nurse problem
		}
	}


	public int insertDoctor(int doctor_id, String name, String surname, String department, String tel) {
		try{
			String query = "INSERT INTO doctor (doctor_id, name,surname,department,tel)" + "VALUES (?,?,?,?,?);";
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setInt(1,doctor_id);
			pstmt.setString(2,name);
			pstmt.setString(3,surname);
			pstmt.setString(4,department);
			pstmt.setString(5,tel);
			pstmt.executeUpdate();
			int updateCount = pstmt.getUpdateCount();
			if(updateCount>0)return updateCount;
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				return rs.getInt(1);
			}
			return -1;
			}catch(SQLException e){
				System.out.println(e.getMessage());
				return -9; //insert doctor problem
			}
	}
}
