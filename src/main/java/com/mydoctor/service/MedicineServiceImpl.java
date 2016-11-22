package com.mydoctor.service;


import java.sql.SQLException;
import java.util.ArrayList;

import com.mydoctor.dao.MedicineDaoImpl;
import com.mydoctor.dao.PharmacistDaoImpl;
import com.mydoctor.dao.PrescriptionDaoImpl;
import com.mydoctor.model.Medicine;
import com.mydoctor.model.Pharmacist;
import com.mydoctor.model.Prescription;


public class MedicineServiceImpl
{
		
		private MedicineDaoImpl medicineDaoImpl;

		public MedicineDaoImpl getMedicineDaoImpl() {
			return medicineDaoImpl;
		}

		public void setMedicineDaoImpl(MedicineDaoImpl medicineDaoImpl) {
			this.medicineDaoImpl = medicineDaoImpl;
		}
		
		public Medicine retrieveMedicine(String medicine_id)throws SQLException{
			return medicineDaoImpl.retrieveMedicine(medicine_id);
		}
		public ArrayList<Medicine> retrieveAllMedicine(int prescript_id)throws SQLException{
			
			return medicineDaoImpl.retrieveAllMedicineIDandName(prescript_id);
		}
		
//		public String getMedicineName(String medicine_id)throws SQLException{
//			return medicineDaoImpl.
//		}
		
		
//		public Prescription createPrescription(String prescriptionId,String medicineId,String medicine,String instruction, String amount) {
//			return new Prescription(prescriptionId, medicineId, medicine, instruction, amount);
//		}
		
		
		
		

}
