package com.mydoctor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mydoctor.model.Doctor;
import com.mydoctor.model.Schedule;

public class DoctorDaoImpl {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String retrieveDoctorId(String username)throws SQLException {
		String query = "Select user_id from user where username = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, username);
		ResultSet resultSet = pstmt.executeQuery();
		if(resultSet.next()){
			return resultSet.getString(1);
		}
		return null;
	}


	public Doctor retrieveDoctor(String username) throws SQLException {
		return null;
	}

	public Schedule retriveSchedule(String schedule_id) throws SQLException {
		String query = "Select * from schedule where schedule_id = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, schedule_id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return new Schedule(schedule_id, rs.getTimestamp("start_date"), rs.getTimestamp("end_date"));
		}
		return null;
	}
	
	public ArrayList<Schedule> retriveAllSchedules(String doctor_id) throws SQLException {
		
		String query = "SELECT schedule.sch_id,schedule.start_date,schedule.end_date FROM doctor_schedule "
				+ "INNER JOIN schedule ON schedule.sch_id = doctor_schedule.sch_id "
				+ "WHERE doctor_schedule.doctor_id = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, doctor_id);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Schedule> schedules = new ArrayList<Schedule>();
		while(rs.next()){
			Schedule schedule = new Schedule();
			schedule.setId(rs.getString("sch_id"));
			schedule.setStart(rs.getTimestamp("start_date"));
			schedule.setEnd(rs.getTimestamp("end_date"));
			schedules.add(schedule);
		}
		return schedules;
	}
	public String retrieveId(String username)throws SQLException {
		String query = "Select user_id from user where username = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return rs.getString("user_id");
		}
		return null;

	}
	

}