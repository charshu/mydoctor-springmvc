package com.mydoctor.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mydoctor.model.GeneralInfo;
import com.mydoctor.model.Nurse;
import com.mydoctor.model.Schedule;
import com.mysql.jdbc.Statement;

public class NurseDaoImpl {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Nurse retrieveNurse(String username)throws SQLException{
		//Find nurse
		return new Nurse();
	}
	
	public int insertInfo(String hospitalNumber, double weight, double height, int heart_rate, int pressureH,
			int pressureL, String congemital, String med_allergy, String symptom)throws SQLException{
		String query = "INSERT INTO patient_info (record_id, hospitalNumber, weight, height, heart_rate, pressureH, pressureL, congemital, med_allergy, symptom)"
				+ "VALUES ('0',?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1,hospitalNumber);
		pstmt.setDouble(2,weight);
		pstmt.setDouble(3,height);
		pstmt.setInt(4,heart_rate);
		pstmt.setInt(5,pressureH);
		pstmt.setInt(6,pressureL);
		pstmt.setString(7,congemital);
		pstmt.setString(8,med_allergy);
		pstmt.setString(9,symptom);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		if(updateCount>0)return updateCount;
		return -1;
	}
	
	public int retrieveId(String username)throws SQLException {
		String query = "Select user_id from user where username = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("user_id");
		}
		return -1;

	}
	public int retrievePatientId(String hostpitalNumber)throws SQLException {
		String query = "Select patient_id from patient where hospitalNumber = hostpitalNumber ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, hostpitalNumber);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("patient_id");
		}
		return -1;

	}

}