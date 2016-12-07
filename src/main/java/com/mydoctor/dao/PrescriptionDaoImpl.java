package com.mydoctor.dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;


import com.mydoctor.model.Prescription;
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
	
//	public MedicineBean retriveMedicine(int med_id) throws SQLException {
//		String query = "Select * from medicine where prescription_id = ? ";
//		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
//		pstmt.setInt(1, med_id);
//		ResultSet rs = pstmt.executeQuery();
//		if(rs.next()){
//			return new MedicineBean(med_id, rs.getString("med_name"), rs.getString("amount"));
//		}
//		return null;
//	}
	
	public int insertPrescription(int med_id, String amount, String instruction)throws SQLException{
		String query = "INSERT INTO mydoctor.prescription (prescription_id, med_id, amount, instruction, status) "
				+ "VALUES ('0', ?, ?, ?, 'wait');";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.setInt(1, med_id);
		pstmt.setString(2, amount);
		pstmt.setString(3, instruction);
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()){
			return rs.getInt(1);
		}
		return -1;
	}

	public ArrayList<Prescription> retriveAllwaitPrescription() throws SQLException {

		String query = "SELECT *  FROM prescription "				
				+ "INNER JOIN create_prescription ON create_prescription.prescription_id = prescription.prescription_id "
				+ "INNER JOIN patient ON create_prescription.patient_id = patient.patient_id "
				+ "WHERE prescription.status = ? group by prescription.prescription_id";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1,"wait");
		ResultSet rs = pstmt.executeQuery();	
		ArrayList<Prescription> prescripList = new ArrayList<Prescription>();
		while(rs.next()){
			Prescription pres = new Prescription();
			pres.setPrescriptionId(rs.getInt("prescription.prescription_id"));
			pres.setMedicineId(rs.getInt("prescription.med_id"));
			pres.setAmount(rs.getInt("prescription.amount"));
			pres.setInstruction(rs.getString("prescription.instruction"));
			pres.setStatus(rs.getString("prescription.status"));
			pres.setPatientName(rs.getString("patient.name"));
			pres.setPatientSurname(rs.getString("patient.surname"));
			prescripList.add(pres);
		}		
		
		return prescripList;
	}
	public ArrayList<Prescription> retrievePrescriptionHistory(String hospitalNumber)throws SQLException{
		//Find Prescription

		String query = "Select create_prescription.prescription_id, medicine , amount , instruction,patient.hospitalNumber FROM create_prescription "
						+	"INNER JOIN prescription ON create_prescription.prescription_id = prescription.prescription_id  "
						+	"INNER JOIN medicine ON prescription.med_id = medicine.med_id  "
						+	"INNER JOIN patient ON create_prescription.patient_id = patient.patient_id  "
						+	"WHERE patient.hospitalNumber = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, hospitalNumber);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Prescription> prescriptionhistory = new ArrayList<Prescription>();
		while(rs.next()) {
			Prescription prescriptionlist = new Prescription();
			prescriptionlist.setHospitalNumber(rs.getString("hospitalNumber"));
			prescriptionlist.setPrescriptionId(rs.getInt("prescription_id"));
			prescriptionlist.setMedicinename(rs.getString("medicine"));
			prescriptionlist.setAmount(rs.getInt("amount"));
			prescriptionlist.setInstruction(rs.getString("instruction"));
			prescriptionhistory.add(prescriptionlist);
		}
		
		return prescriptionhistory;
	}
	public void updateStatus(int prescription_id) throws SQLException{
		
		String query = "UPDATE prescription SET status = ?"
				+" WHERE prescription.prescription_id = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1,"Complete");
		pstmt.setInt(2,prescription_id);
		pstmt.executeUpdate();
		
	}
	
	public int insertCreatePrescription(int doctor_id, int patient_id, int prescription_id)throws SQLException{
		String query = "INSERT INTO mydoctor.create_prescription (doctor_id, patient_id, prescription_id)"
				+ "VALUES (?, ?, ?);";
	
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.setInt(1, doctor_id);
		pstmt.setInt(2, patient_id);
		pstmt.setInt(3, prescription_id);
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()){
		
			return rs.getInt(1);
		}
		return -1;
	}
	

	
	

}