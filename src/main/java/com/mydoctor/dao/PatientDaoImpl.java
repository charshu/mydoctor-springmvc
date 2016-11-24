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
	
	public int retrievePatientIdByHN(String hospitalNumber) throws SQLException {
		String query = "Select patient_id from patient where hospitalNumber = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, hospitalNumber);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return resultSet.getInt("patient_id");
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
	public String retrieveHospitalNumberById(int patient_id)throws SQLException{
		String query = "Select hospitalNumber from patient where patient_id = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, patient_id);
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
	
	public String retrievePatientNameByID(int patient_id)throws SQLException {
		//////////pls check attribute of patient name in database 
		String query = "Select name from patient where patient_id = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, patient_id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return rs.getString("name");
		}
		return "null";

	}

	public ArrayList<Appointment> retrieveAllAppointments(int patient_id) throws SQLException {
		String query = "SELECT patient.patient_id,patient.name as patient_name,doctor.doctor_id,doctor.name as doctor_name ,appointment.app_id,appointment.date,appointment.symptom,appointment.status "
				+ "FROM make_appointment "
				+ "INNER JOIN appointment "
				+ "INNER JOIN doctor "
				+ "INNER JOIN patient WHERE patient.patient_id=make_appointment.patient_id "
				+ "and make_appointment.app_id = appointment.app_id "
				+ "and doctor.doctor_id=make_appointment.doctor_id "
				+ "and make_appointment.patient_id = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, patient_id);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Appointment> appointments = new ArrayList<Appointment>();
		
		while (rs.next()) {
			Appointment appointment = new Appointment();
			
			appointment.setId(rs.getInt("app_id"));
			appointment.setPatientName(rs.getString("patient_name"));
			appointment.setDoctorName(rs.getString("doctor_name"));
			appointment.setDate(rs.getTimestamp("date"));
			appointment.setSymptom(rs.getString("symptom"));
			appointment.setStatus(rs.getString("status"));
			appointments.add(appointment);

		}
		return appointments;

	}

	public ArrayList<Appointment> retrieveAllDoctorAppointments(int doctor_id) throws SQLException {
		String query = "SELECT patient_id,doctor_id,appointment.app_id,appointment.date,appointment.symptom,appointment.status "
				+ "FROM make_appointment INNER JOIN appointment "
				+ "WHERE make_appointment.app_id = appointment.app_id and doctor_id = ? ORDER BY appointment.date DESC";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, doctor_id);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Appointment> appointments = new ArrayList<Appointment>();
		while (rs.next()) {
			
			Appointment appointment = new Appointment();
			if(!"waiting".equals(rs.getString("status")))continue;
			appointment.setId(rs.getInt("app_id"));
			appointment.setDate(rs.getTimestamp("date"));
			appointment.setSymptom(rs.getString("symptom"));
			appointment.setStatus(rs.getString("status"));
			appointments.add(appointment);
		}

		return appointments;

	}

	public int insertAppointment(Timestamp date, String symptom,String status) throws SQLException {
		String query = "INSERT INTO mydoctor.appointment (app_id, date, symptom,status) VALUES (NULL, ?, ? ,?);";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		pstmt.setTimestamp(1, date);
		pstmt.setString(2, symptom);
		pstmt.setString(3, status);
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}

	public int insertCreateAppointment(int patient_id, int doctor_id, int appointment_id) throws SQLException {
		String query = "INSERT INTO mydoctor.make_appointment (patient_id, doctor_id, app_id) VALUES (?, ?, ?);";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, patient_id);
		pstmt.setInt(2, doctor_id);
		pstmt.setInt(3, appointment_id);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		return updateCount;
	}

	public boolean hasAppointmentId(int patient_id,int appointment_id) throws SQLException {
		System.out.println("has -> patient : "+ patient_id+" appointment id : "+appointment_id);
		String query = "SELECT * FROM make_appointment "
				+ "WHERE make_appointment.patient_id = ? and make_appointment.app_id = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, patient_id);
		pstmt.setInt(2, appointment_id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;

	}
	public int deleteMakeAppointment(int patient_id,int appointment_id) throws SQLException {
		System.out.println("delete make_appointment -> patient : "+ patient_id+" appointment id : "+appointment_id);
		String query = "DELETE FROM make_appointment "
				+ "WHERE make_appointment.patient_id = ? and make_appointment.app_id = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, patient_id);
		pstmt.setInt(2, appointment_id);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		if (updateCount > 0)
			return updateCount;
		return -1;

	}
	public int deleteAppointment(int appointment_id)throws SQLException{
		System.out.println("delete appointment -> appointment id : "+appointment_id);
		String query = "DELETE FROM appointment WHERE appointment.app_id = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, appointment_id);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		if (updateCount > 0)
			return updateCount;
		return -1;
		
	}
	public int setStatusAppointment(Timestamp start,Timestamp end,String status)throws SQLException{
		String query = "Update appointment Set appointment.status = ? "
				+ "Where appointment.date BETWEEN ? and ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, status);
		pstmt.setTimestamp(2, start);
		pstmt.setTimestamp(3, end);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		return updateCount;
	}
	public int editPatientInfo(String name, String surname, String gender, String birth_date, String address, String tel, String email, int patient_id) throws SQLException {
		String query = "Update patient Set name = ?, surname = ?, gender = ?, birth_date = ?, address = ?, tel = ?, email = ? Where patient_id = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, name);
		pstmt.setString(2, surname);
		pstmt.setString(3, gender);
		pstmt.setString(4, birth_date);
		pstmt.setString(5, address);
		pstmt.setString(6, tel);
		pstmt.setString(7, email);
		pstmt.setInt(8, patient_id);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		return updateCount;

	}
}