package com.mydoctor.service;


import java.sql.SQLException;

import com.mydoctor.dao.PharmacistDaoImpl;
import com.mydoctor.model.Pharmacist;


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
		
		
		
		

}
