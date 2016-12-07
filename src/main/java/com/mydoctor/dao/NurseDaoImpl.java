package com.mydoctor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mydoctor.model.GeneralInfo;
import com.mydoctor.model.Nurse;
import com.mydoctor.model.Patient;
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
	
	public int insertInfo(String hospitalNumber, double weight, int height, int heart_rate, int pressureH,
			int pressureL, String congemital, String med_allergy, String symptom)throws SQLException{
		String query = "INSERT INTO patient_info (record_id, hospitalNumber, weight, height, heart_rate, pressureH, pressureL, congemital, med_allergy, symptom)"
				+ "VALUES ('0',?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1,hospitalNumber);
		pstmt.setDouble(2,weight);
		pstmt.setInt(3,height);
		pstmt.setInt(4,heart_rate);
		pstmt.setInt(5,pressureH);
		pstmt.setInt(6,pressureL);
		pstmt.setString(7,congemital);
		pstmt.setString(8,med_allergy);
		pstmt.setString(9,symptom);
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()){
			return rs.getInt(1);
		}
		return -1;
	}
	
	public int addToCreatePatientInfo(int patient_id,int nurse_id,int record_id)throws SQLException{
		String query = "INSERT INTO create_patient_info (patient_id, nurse_id,record_id)" + "VALUES (?,?,?);";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1,patient_id);
		pstmt.setInt(2,nurse_id);
		pstmt.setInt(3,record_id);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		if(updateCount>0)return updateCount;
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()){
			return rs.getInt(1);
		}
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
		String query = "Select patient_id from patient where hospitalNumber = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, hostpitalNumber);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("patient_id");
		}
		return -1;

	}

	public GeneralInfo retriveGenInfo(int record_id,String hospitalNumber) throws SQLException {

		String query = "Select hospitalNumber, weight, height, heart_rate, pressureH, pressureL, congemital, med_allergy, symptom, date FROM patient_info where record_id = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, record_id);
		ResultSet rs = pstmt.executeQuery();
		GeneralInfo generalInfo = new GeneralInfo();
		if(rs.next()) {
			generalInfo.setHospitalNumber(hospitalNumber);
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

	
}