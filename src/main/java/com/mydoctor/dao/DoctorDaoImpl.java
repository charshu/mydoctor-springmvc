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

	public Doctor retrieveDoctor(String username) throws SQLException {
		return null;
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

		String query = "SELECT schedule.sch_id,schedule.start_date,schedule.end_date FROM doctor_schedule "
				+ "INNER JOIN schedule ON schedule.sch_id = doctor_schedule.sch_id "
				+ "WHERE doctor_schedule.doctor_id = ?";
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