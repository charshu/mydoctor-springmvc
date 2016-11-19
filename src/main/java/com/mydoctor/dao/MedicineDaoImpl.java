package com.mydoctor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mydoctor.model.MedicineBean;


public class MedicineDaoImpl {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public MedicineBean retrieveMedicine(String medicine_id)throws SQLException{
		
		return new MedicineBean();
	}
	
	public String getMedicineName(String medicine_id) throws SQLException {
		String query = "Select med_name from medicine where med_id = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, medicine_id);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return resultSet.getString(1);
		else
			return null;
	}
	
	public String getMedicineId(String medicine) throws SQLException {
		String query = "Select med_id from medicine where med_name = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, medicine);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return resultSet.getString(1);
		else
			return null;

	}
	
	
//	public ArrayList<Prescription> retrieveAllPrescriptions(String patient_id) throws SQLException {
//		String query = "Select prescription_id from patient,  where user_id = ? ";
//		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
//		pstmt.setString(1, user_id);
//		ResultSet resultSet = pstmt.executeQuery();
//		if (resultSet.next())
//			return resultSet.getString(1);
//		else
//			return null;
//		for(int i=0; i<)
//		return null;
//	}
}