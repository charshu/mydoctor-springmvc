package com.mydoctor.service;

import java.sql.SQLException;

import com.mydoctor.dao.PatientDaoImpl;

import com.mydoctor.model.Patient;


public class PatientServiceImpl
{
		
		
		private PatientDaoImpl patientDaoImpl;
		
		public PatientDaoImpl getUserDao() {
			return patientDaoImpl;
		}
		public void setPatientDaoImpl(PatientDaoImpl patientDaoImpl) {
			this.patientDaoImpl = patientDaoImpl;
		}
		
		public Patient retrievePatient(String username) throws SQLException {
				return patientDaoImpl.retrievePatient(username);
		}
		

}
