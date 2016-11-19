package com.mydoctor.service;


import java.sql.SQLException;

import com.mydoctor.dao.MedicineDaoImpl;
import com.mydoctor.model.MedicineBean;



public class MedicineServiceImpl
{
		
		private MedicineDaoImpl medicineDaoImpl;

		public MedicineDaoImpl getMedicineDaoImpl() {
			return medicineDaoImpl;
		}

		public void setMedicineDaoImpl(MedicineDaoImpl medicineDaoImpl) {
			this.medicineDaoImpl = medicineDaoImpl;
		}
		
		public MedicineBean retrieveMedicine(String medicine_id)throws SQLException{
			return medicineDaoImpl.retrieveMedicine(medicine_id);
		}
		
//		public String getMedicineName(String medicine_id)throws SQLException{
//			return medicineDaoImpl.
//		}
		
		
//		public Prescription createPrescription(String prescriptionId,String medicineId,String medicine,String instruction, String amount) {
//			return new Prescription(prescriptionId, medicineId, medicine, instruction, amount);
//		}
		
		
		
		

}
