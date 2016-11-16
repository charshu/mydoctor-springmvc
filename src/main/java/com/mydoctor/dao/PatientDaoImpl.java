package com.mydoctor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mydoctor.model.Patient;

public class PatientDaoImpl {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
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
	public Patient retrievePatient(String username) throws SQLException {
		String query = "Select * from patient where patient_id = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		String patient_id = getId(username);
		pstmt.setString(1, patient_id);
		ResultSet resultSet = pstmt.executeQuery();
		Patient patient = new Patient();
		if (resultSet.next()) {
			patient.setId(patient_id);
			patient.setSsn(resultSet.getString("ssn"));
			patient.setName(resultSet.getString("name"));

			String str = "";
			for (int i = 0; i < getPatientPasswordLength(username); i++) {
				str = str + "*";
			}
			patient.setPassword(str);
			patient.setSurname(resultSet.getString("surname"));
			patient.setGender(resultSet.getString("gender"));
			patient.setBirthdate(resultSet.getString("birth_date"));
			patient.setAddress(resultSet.getString("address"));
			patient.setTel(resultSet.getString("tel"));
			patient.setEmail(resultSet.getString("email"));
			patient.setHospitalNumber(resultSet.getString("hospitalNumber"));
			return patient;
		} else
			return null;
	}

}