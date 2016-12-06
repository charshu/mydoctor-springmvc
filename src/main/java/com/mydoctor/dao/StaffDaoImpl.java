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
import com.mydoctor.model.Patient;
import com.mydoctor.model.Schedule;
import com.mydoctor.model.Staff;
import com.mysql.jdbc.Statement;

public class StaffDaoImpl {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Staff retrieveStaff(String username)throws SQLException{
		//Find nurse
		return new Staff();
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
		String query = "Select patient_id from patient where hospitalNumber = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, hostpitalNumber);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("patient_id");
		}
		return -1;

	}

	public GeneralInfo retriveGenInfo(int record_id) throws SQLException {

		String query = "Select hospitalNumber, weight, height, heart_rate, pressureH, pressureL, congemital, med_allergy, symptom, date FROM patient_info where record_id = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, record_id);
		ResultSet rs = pstmt.executeQuery();
		GeneralInfo generalInfo = new GeneralInfo();
		if(rs.next()) {
			generalInfo.setHospitalNumber(rs.getString("hospitalNumber"));
			generalInfo.setWeight(rs.getDouble("weight"));
			generalInfo.setHeight(rs.getInt("height"));
			generalInfo.setHeart_rate(rs.getInt("heart_rate"));
			generalInfo.setPressureH(rs.getInt("pressureH"));
			generalInfo.setPressureL(rs.getInt("pressureL"));
			generalInfo.setCongemital(rs.getString("congemital"));
			generalInfo.setMed_allergy(rs.getString("med_allergy"));
			generalInfo.setSymptom(rs.getString("symptom"));
			generalInfo.setDate(rs.getDate("date"));
		}
		return generalInfo;
	}
	
	public Patient retriveInfo(int patient_id) throws SQLException {
		String query = "Select hospitalNumber,ssn, name, surname, gender, birth_date, address, tel, email FROM patient where patient_id = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, patient_id);
		ResultSet rs = pstmt.executeQuery();
		Patient patientInfo = new Patient();
		if(rs.next()) {
			patientInfo.setHospitalNumber(rs.getString("hospitalNumber"));
			patientInfo.setSsn(rs.getString("ssn"));
			patientInfo.setName(rs.getString("name"));
			patientInfo.setSurname(rs.getString("surname"));
			patientInfo.setGender(rs.getString("gender"));
			patientInfo.setBirthdate(rs.getString("birth_date"));
			patientInfo.setAddress(rs.getString("address"));
			patientInfo.setTel(rs.getString("tel"));
			patientInfo.setEmail(rs.getString("email"));
		}
		return patientInfo;
	}
	
	public int retrieveRecordId(String hospitalNumber)throws SQLException {
		String query = "Select MAX(record_id) as record_id from patient_info where hospitalNumber = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, hospitalNumber);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("record_id");
		}
		return -1;

	}
	
	public int registerPatient(String ssn, String name, String surname, String gender, String birth_date, String address, String tel, String email, String hospitalNumber)throws SQLException {
		try{
		String query = "INSERT INTO patient (patient_id, ssn, name, surname, gender, birth_date, address, tel, email, hospitalNumber)"
				+ "VALUES ('0',?,?,?,?,?,?,?,?,?);";
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
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()){
			return rs.getInt(1);
		}
		return -1;
		}catch(SQLException e){
			System.out.println(e.getMessage());
			if(e.getMessage().contains("for key 'ssn'")){
				
				return -3;
			}
			else if(e.getMessage().contains("for key 'email'")){
				
				return -4;
			}
			
			else return -5;
		}

	}
}