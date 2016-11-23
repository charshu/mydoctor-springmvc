package com.mydoctor.service;


import java.sql.SQLException;
import java.util.ArrayList;

import com.mydoctor.dao.PharmacistDaoImpl;
import com.mydoctor.model.Pharmacist;
import com.mydoctor.model.Prescription;



public class PharmacistServiceImpl
{
		
		private PharmacistDaoImpl pharmacistDaoImpl;
			

		public PharmacistDaoImpl getPharmacistDaoImpl() {
			return pharmacistDaoImpl;
		}

		public void setPharmacistDaoImpl(PharmacistDaoImpl pharmacistDaoImpl) {
			this.pharmacistDaoImpl = pharmacistDaoImpl;
		}
		
		public Pharmacist retrievePharmacist(String username)throws SQLException{
			return pharmacistDaoImpl.retrievePharmacist(username);
		}
		

		public Prescription createPrescription(int prescriptionId,int medicineId,String medicine,String instruction, int amount,String status) {
			return new Prescription(prescriptionId, medicineId, medicine, instruction, amount,status);
		}
		


}
