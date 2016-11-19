package com.mydoctor.service;


import java.sql.SQLException;

import com.mydoctor.dao.PharmacistDaoImpl;
import com.mydoctor.dao.PrescriptionDaoImpl;
import com.mydoctor.model.Pharmacist;
import com.mydoctor.model.Prescription;


public class PrescriptionServiceImpl
{
		
		private PrescriptionDaoImpl prescriptionDaoImpl;

		public PrescriptionDaoImpl getPrescriptionDaoImpl() {
			return prescriptionDaoImpl;
		}

		public void setPrescriptionDaoImpl(PrescriptionDaoImpl prescriptionDaoImpl) {
			this.prescriptionDaoImpl = prescriptionDaoImpl;
		}
		
		public Prescription retrievePrescription(String username)throws SQLException{
			return prescriptionDaoImpl.retrievePrescription(username);
		}
		
		public Prescription createPrescription(String prescriptionId,String medicineId,String medicine,String instruction, String amount) {
			return new Prescription(prescriptionId, medicineId, medicine, instruction, amount);
		}
		
		
		
		

}
