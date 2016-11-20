package com.mydoctor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mydoctor.model.Patient;
import com.mydoctor.model.Pharmacist;
import com.mydoctor.model.Prescription;
import com.mydoctor.model.Schedule;

public class PrescriptionDaoImpl {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Prescription retrievePrescription(String prescription_id)throws SQLException{
		//Find Prescription
		return new Prescription();
	}
	public ArrayList<String> retriveDoctorPatientName(String prescrip_id) throws SQLException {
		
		String query = "SELECT diagnose.patient_id diagnose.doctor_id FROM create_prescription "
				+ "INNER JOIN diagnose ON create_prescription.diagnose_id = diagnose.diagnose_id "
				+ "INNER JOIN patient ON diagnose.patient_id = patient.user_id "
				+ "INNER JOIN user ON user.user_id = diagnose.doctor_id "
				+ "WHERE create_prescription = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, prescrip_id);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<String> name = new ArrayList<String>();
		
		
		if(rs.next()){
			String patId = rs.getString("patient_id");
			String docId = rs.getString("doctor_id");
		}
		return name;
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