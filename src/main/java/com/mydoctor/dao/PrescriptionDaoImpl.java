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
	public ArrayList<Prescription> retriveAllwaitPrescription() throws SQLException {
		
		String query = "SELECT prescript_id , status FROM prescription "
				+ "WHERE prescription.status = ? group by prescript_id";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1,"wait");
		ResultSet rs = pstmt.executeQuery();	
		ArrayList<Prescription> prescripList = new ArrayList<Prescription>();
		while(rs.next()){
			Prescription pres = new Prescription();
			pres.setPrescriptionId(rs.getInt("prescript_id"));
			pres.setStatus(rs.getString("status"));
			prescripList.add(pres);
		}		
		
		return prescripList;
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