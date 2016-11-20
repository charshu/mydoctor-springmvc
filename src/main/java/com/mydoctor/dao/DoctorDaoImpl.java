package com.mydoctor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mydoctor.model.Doctor;
import com.mydoctor.model.GeneralInfo;
import com.mydoctor.model.Patient;
import com.mydoctor.model.Schedule;
import com.mysql.jdbc.Statement;

public class DoctorDaoImpl {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String retrieveDoctorId(String username) throws SQLException {
		String query = "Select user_id from user where username = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, username);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next()) {
			return resultSet.getString(1);
		}
		return null;
	}


	public Doctor retrieveDoctor(int doctor_id) throws SQLException {
		String query = "Select * from doctor where doctor_id = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, doctor_id);
		ResultSet rs = pstmt.executeQuery();
		Doctor doctor = new Doctor();
		if (rs.next()) {
			doctor.setName(rs.getString("name"));
			doctor.setSurname(rs.getString("surname"));
			doctor.setDepartment(rs.getString("department"));
			doctor.setTel(rs.getString("tel"));
		}
		return doctor;

	}
	public ArrayList<Doctor> retrieveAllDoctors() throws SQLException {
		String query = "Select * from doctor ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		while (rs.next()) {
			Doctor doctor = new Doctor();
			doctor.setId(rs.getInt("doctor_id"));
			doctor.setName(rs.getString("name"));
			doctor.setSurname(rs.getString("surname"));
			doctor.setDepartment(rs.getString("department"));
			doctors.add(doctor);
			
		}
		//System.out.print(doctors.size());
		return doctors;
	}
	public Schedule retriveSchedule(int schedule_id) throws SQLException {
		String query = "Select * from schedule where schedule_id = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, schedule_id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return new Schedule(schedule_id, rs.getTimestamp("start_date"), rs.getTimestamp("end_date"));
		}
		return null;
	}

	public ArrayList<Schedule> retriveAllDoctorSchedules(int doctor_id) throws SQLException {
		System.out.println("retrieve All Doctor Schedules");
		String query = "SELECT schedule.sch_id,schedule.start_date,schedule.end_date FROM doctor_schedule "
				+ "INNER JOIN schedule ON schedule.sch_id = doctor_schedule.sch_id "
				+ "WHERE doctor_schedule.doctor_id = ? ORDER BY schedule.start_date ASC";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, doctor_id);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Schedule> schedules = new ArrayList<Schedule>();
		while (rs.next()) {
			Schedule schedule = new Schedule();
			schedule.setId(rs.getInt("sch_id"));
			schedule.setStart(rs.getTimestamp("start_date"));
			schedule.setEnd(rs.getTimestamp("end_date"));
			schedules.add(schedule);
		}
		
		return schedules;
	}
	public ArrayList<Schedule> retriveAllDepartmentSchedules(String department) throws SQLException {

		String query = "SELECT doctor.department,doctor.doctor_id,schedule.sch_id,schedule.start_date,schedule.end_date "
				+ "FROM doctor INNER JOIN doctor_schedule INNER JOIN schedule "
				+ "WHERE doctor.doctor_id = doctor_schedule.doctor_id and doctor_schedule.sch_id = schedule.sch_id and doctor.department= ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, department);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Schedule> schedules = new ArrayList<Schedule>();
		while (rs.next()) {

			Schedule schedule = new Schedule();
			schedule.setId(rs.getInt("sch_id"));
			schedule.setStart(rs.getTimestamp("start_date"));
			schedule.setEnd(rs.getTimestamp("end_date"));
			schedules.add(schedule);
		}
		return schedules;
	}


	public ArrayList<Schedule> retriveAllSchedules() throws SQLException {

		String query = "SELECT schedule.sch_id,schedule.start_date,schedule.end_date FROM doctor_schedule "
				+ "INNER JOIN schedule ON schedule.sch_id = doctor_schedule.sch_id "
				+ "WHERE 1";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Schedule> schedules = new ArrayList<Schedule>();
		while (rs.next()) {
			Schedule schedule = new Schedule();
			schedule.setId(rs.getInt("sch_id"));
			schedule.setStart(rs.getTimestamp("start_date"));
			schedule.setEnd(rs.getTimestamp("end_date"));
			schedules.add(schedule);
		}
		return schedules;
	}


	public int retrieveId(String username) throws SQLException {
		String query = "Select user_id from user where username = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("user_id");
		}
		return -1;

	}

	public int insertSchedule(Schedule schedule) throws SQLException {
		String query = "INSERT INTO mydoctor.schedule (sch_id, start_date, end_date) " + "VALUES ('0', ?, ?);";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		pstmt.setTimestamp(1, schedule.getStart());
		pstmt.setTimestamp(2, schedule.getEnd());
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next()) {
			
			return rs.getInt(1);
		}
		return -1;
	}

	public int insertDoctorSchedule(int doctor_id, int schedule_id) throws SQLException {
		String query = "INSERT INTO mydoctor.doctor_schedule (doctor_id, sch_id) " + "VALUES (?, ?);";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, doctor_id);
		pstmt.setInt(2, schedule_id);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		if (updateCount > 0)
			return updateCount;
		return -1;
	}

	public int deleteDoctorSchedule(int doctor_id, int schedule_id) throws SQLException {
		String query = "DELETE FROM mydoctor.doctor_schedule "
				+ "WHERE doctor_schedule.doctor_id = ? and doctor_schedule.sch_id = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, doctor_id);
		pstmt.setInt(2, schedule_id);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		if (updateCount > 0)
			return updateCount;
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

	public int deleteSchedule(int schedule_id) throws SQLException {
		String query = "DELETE FROM mydoctor.schedule " + "WHERE sch_id = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, schedule_id);
		pstmt.executeUpdate();
		int updateCount = pstmt.getUpdateCount();
		if (updateCount > 0)
			return updateCount;
		return -1;
	}
	

}