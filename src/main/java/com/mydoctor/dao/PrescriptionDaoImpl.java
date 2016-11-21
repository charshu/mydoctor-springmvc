package com.mydoctor.dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mydoctor.model.MedicineBean;
import com.mydoctor.model.Schedule;
import com.mysql.jdbc.Statement;


public class PrescriptionDaoImpl {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public String retrievePrescriptionId(String username)throws SQLException {
		String query = "Select prescription_id from presciption where username = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, username);
		ResultSet resultSet = pstmt.executeQuery();
		if(resultSet.next()){
			return resultSet.getString(1);
		}
		return null;
	}
	
	public MedicineBean retriveMedicine(int med_id) throws SQLException {
		String query = "Select * from medicine where prescription_id = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, med_id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			//return new MedicineBean(med_id, rs.getString("med_name"), rs.getString("amount"));
		}
		return null;
	}
	
	public int insertPrescription(int med_id, String amount, String instruction)throws SQLException{
		String query = "INSERT INTO mydoctor.prescription (prescription_id, med_id, amount, instruction) "
				+ "VALUES ('0', ?, ?, ?);";
		//System.out.println("pass0");
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.setInt(1, med_id);
		pstmt.setString(2, amount);
		pstmt.setString(3, instruction);
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()){
			//System.out.println("pass00");
			return rs.getInt(1);
		}
		return -1;
	}
	
	public int insertCreatePrescription(int doctor_id, int patient_id, int prescription_id)throws SQLException{
		String query = "INSERT INTO mydoctor.createprescription (doctor_id, patient_id, prescription_id)"
				+ "VALUES (?, ?, ?);";
		System.out.println("pass11");
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.setInt(1, doctor_id);
		pstmt.setInt(2, patient_id);
		pstmt.setInt(3, prescription_id);
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()){
			//System.out.println("pass12");
			return rs.getInt(1);
		}
		return -1;
	}
	
//	public ArrayList<MedicineBean> retriveAllSchedules(int doctor_id) throws SQLException {
//		
//		String query = "SELECT schedule.sch_id,schedule.start_date,schedule.end_date FROM doctor_schedule "
//				+ "INNER JOIN schedule ON schedule.sch_id = doctor_schedule.sch_id "
//				+ "WHERE doctor_schedule.doctor_id = ?";
//		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
//		pstmt.setInt(1, doctor_id);
//		ResultSet rs = pstmt.executeQuery();
//		ArrayList<Schedule> schedules = new ArrayList<Schedule>();
//		while(rs.next()){
//			Schedule schedule = new Schedule();
//			schedule.setId(rs.getInt("sch_id"));
//			schedule.setStart(rs.getTimestamp("start_date"));
//			schedule.setEnd(rs.getTimestamp("end_date"));
//			schedules.add(schedule);
//		}
//		return null;//schedules;
//	}
	
//	public int insertMedicine(MedicineBean medicineBean)throws SQLException{
//		String query = "INSERT INTO mydoctor.schedule (sch_id, start_date, end_date) "
//				+ "VALUES ('0', ?, ?);";
//		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
//		ResultSet rs = pstmt.getGeneratedKeys();
//		if(rs.next()){
//			return rs.getInt(1);
//		}
//		return -1;
//	}
	
	

}