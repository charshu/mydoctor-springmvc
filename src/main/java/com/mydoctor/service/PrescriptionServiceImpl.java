package com.mydoctor.service;


import java.sql.SQLException;
import java.util.ArrayList;

import com.mydoctor.dao.PharmacistDaoImpl;
import com.mydoctor.dao.PrescriptionDaoImpl;
import com.mydoctor.model.Doctor;
import com.mydoctor.model.Pharmacist;
import com.mydoctor.model.Prescription;


public class PrescriptionServiceImpl
{
		
		private PrescriptionDaoImpl prescriptionDaoImpl;
		private static ArrayList<Prescription> prescriptionHistory = new ArrayList<Prescription>();

		public PrescriptionDaoImpl getPrescriptionDaoImpl() {
			return prescriptionDaoImpl;
		}

		public void setPrescriptionDaoImpl(PrescriptionDaoImpl prescriptionDaoImpl) {
			this.prescriptionDaoImpl = prescriptionDaoImpl;
		}
		
		
		public Prescription retrievePrescription(String username)throws SQLException{
			
			return prescriptionDaoImpl.retrievePrescription(username);
		}

		
		public ArrayList<Prescription> retrieveAllPrescription()throws SQLException{
			return prescriptionDaoImpl.retriveAllwaitPrescription();
			
		}

		public ArrayList<Prescription> findPrescriptionHistory(String username,Prescription findprescriptionh)throws SQLException{
			int userid = findprescriptionh.getUserid();
			System.out.println(userid);
			return prescriptionDaoImpl.retrievePrescriptionHistory(userid);
		}
		

//		public Prescription createPrescription(String prescriptionId,String medicineId,String medicine,String instruction, String amount) {
//			return new Prescription(prescriptionId, medicineId, medicine, instruction, amount);
//		}
		
		
		
		

}
