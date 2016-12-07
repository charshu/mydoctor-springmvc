package com.mydoctor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

import com.mydoctor.model.Medicine;
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
	
	public ArrayList<Medicine> retrieveAllMedicineIDandName(int prescription_id)throws SQLException{
		String query = "Select prescription.med_id , medicine.medicine , prescription.amount , prescription.instruction from prescription " 
						+ "inner join medicine ON prescription.med_id = medicine.med_id "
						+ "where prescription_id = ?"	;
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, prescription_id);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Medicine> allmed = new ArrayList<Medicine>();
		while(rs.next()){
			Medicine med = new Medicine();
			med.setMedicineId(rs.getInt("prescription.med_id"));
			med.setMedicine(rs.getString("medicine.medicine"));
			med.setAmount(rs.getInt("prescription.amount"));
			med.setInstruction(rs.getString("prescription.instruction"));
			allmed.add(med);
		}
		
		return allmed;
	}
	
	public String getMedicineName(int medicine_id) throws SQLException {
		String query = "Select medicine from medicine where med_id = ? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, medicine_id);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return resultSet.getString(1);
		else
			return null;
	}
	
	public ArrayList<MedicineBean> retrieveAllMedicine() throws SQLException{
		String query = "Select med_id, medicine from medicine";
		System.out.println("test1");
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("test2");
		ArrayList<MedicineBean> medicineBean = new ArrayList<MedicineBean>();
		while(rs.next()){
			MedicineBean med = new MedicineBean();
			med.setId(rs.getInt("med_id"));
			med.setName(rs.getString("medicine"));
			med.setAmount("");
			med.setInstruction("");
			medicineBean.add(med);
		}
		System.out.println("test3");
		return medicineBean;
	}
	
//	public int getMedicineId(String medicine_name) throws SQLException {
//		String query = "Select med_id from medicine where med_name = ? ";
//		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
//		pstmt.setString(1, medicine_name);
//		ResultSet resultSet = pstmt.executeQuery();
//		if (resultSet.next())
//			return resultSet.getInt(1);
//		else
//			return -1;
//
//	}
	
	
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