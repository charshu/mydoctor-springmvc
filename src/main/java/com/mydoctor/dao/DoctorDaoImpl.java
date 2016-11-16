package com.mydoctor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mydoctor.model.Doctor;
import com.mydoctor.model.Patient;
import com.mydoctor.model.Schedule;

public class DoctorDaoImpl {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Patient retrievePatient(String patient_id) throws SQLException {
		String query = "Select * from patient where patient_id = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, patient_id);
		ResultSet resultSet = pstmt.executeQuery();
		Patient patient = new Patient();
		if (resultSet.next()) {
			patient.setId(patient_id);
			patient.setSsn(resultSet.getString("ssn"));
			patient.setName(resultSet.getString("name"));
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
	
	public ArrayList<Patient> retrieveAllPatients() throws SQLException {
		
		return null;
	}

	public String getDoctorId(String username)throws SQLException {
		String query = "Select user_id from user where username = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, username);
		ResultSet resultSet = pstmt.executeQuery();
		if(resultSet.next()){
			return resultSet.getString(1);
		}
		return null;
	}
	public Schedule getSchedule(String sche_id)throws SQLException {
		String query = "Select * from schedule where schedule_id = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, sche_id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return new Schedule(rs.getString("sche_id"), rs.getDate("start_time"), rs.getDate("end_time"));
		}
		return null;
	}

	public Doctor retrieveDoctor(String username) throws SQLException {
		return null;
	}

	public ArrayList<Schedule> retriveSchedules(String username, String schedule_id) throws SQLException {
		String query = "Select sch_id from doctor_schedule where doctor_id = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, getDoctorId(username));
		ResultSet resultSet = pstmt.executeQuery();
		return null;
	}

	public ArrayList<Schedule> retriveAllSchedules(String username) throws SQLException {
		return new ArrayList<Schedule>();

	}
	

}