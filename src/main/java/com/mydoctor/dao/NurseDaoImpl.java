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
	
	public int insertInfo(GeneralInfo generalInfo)throws SQLException{
		String query = "INSERT INTO mydoctor.patient_info (record_id, hospitalNumber, weight, height, heart_rate, pressureH, pressureL, congemital, med_allergy, symptom, date)"
				+ "VALUES ('0',?, ?, ?, ?,?, ?, ?, ?,?);";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.executeUpdate();
		
		return -1;
	}
	

}