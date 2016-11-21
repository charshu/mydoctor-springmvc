package com.mydoctor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mydoctor.model.Appointment;
import com.mydoctor.model.Patient;
import com.mysql.jdbc.Statement;

public class PatientDaoImpl {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public int retrieveUserId(String username) throws SQLException {
		String query = "Select user_id from user where username = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, username);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return resultSet.getInt("user_id");
		else
			return -1;
	}
	public int retrieveIdByUserId(int user_id) throws SQLException {
		String query = "Select patient_id from patient where user_id = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, user_id);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return resultSet.getInt(1);
		else
			return -1;
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

	public Patient retrievePatient(int patient_id) throws SQLException {
		String query = "Select * from patient where patient_id = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, patient_id);
		ResultSet resultSet = pstmt.executeQuery();
		Patient patient = new Patient();
		if (resultSet.next()) {
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
	public ArrayList<Appointment> retrieveAllAppointments(int patient_id)throws SQLException{
		String query = "SELECT patient_id,doctor_id,appointment.app_id,appointment.date,appointment.symptom "
				+ "FROM make_appointment INNER JOIN appointment "
				+ "WHERE make_appointment.app_id = appointment.app_id and patient_id = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, patient_id);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Appointment> appointments = new ArrayList<Appointment>();
		while(rs.next()){
			Appointment appointment = new Appointment();
			appointment.setId(rs.getInt("app_id"));
			appointment.setDate(rs.getTimestamp("date"));
			appointment.setSymptom(rs.getString("symptom"));
			appointments.add(appointment);
			
		}
		return appointments;
		
		
	}
	public ArrayList<Appointment> retrieveAllDoctorAppointments(int doctor_id)throws SQLException{
		String query = "SELECT patient_id,doctor_id,appointment.app_id,appointment.date,appointment.symptom "
				+ "FROM make_appointment INNER JOIN appointment "
				+ "WHERE make_appointment.app_id = appointment.app_id and doctor_id = ? ORDER BY appointment.date DESC";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, doctor_id);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Appointment> appointments = new ArrayList<Appointment>();
		while(rs.next()){
			Appointment appointment = new Appointment();
			appointment.setId(rs.getInt("app_id"));
			appointment.setDate(rs.getTimestamp("date"));
			appointment.setSymptom(rs.getString("symptom"));
			appointments.add(appointment);
		}
		return appointments;
		
		
	}
	public int insertAppointment(Timestamp date,String symptom)throws SQLException{
		String query = "INSERT INTO mydoctor.appointment (app_id, date, symptom) VALUES (NULL, ?, ?);";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		pstmt.setTimestamp(1, date);
		pstmt.setString(2, symptom);
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}
	public int insertCreateAppointment(int patient_id,int doctor_id,int appointment_id)throws SQLException{
		String query = "INSERT INTO mydoctor.make_appointment (patient_id, doctor_id, app_id) VALUES (?, ?, ?);";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, patient_id);
		pstmt.setInt(2, doctor_id);
		pstmt.setInt(3, appointment_id);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		return updateCount;
	}
}