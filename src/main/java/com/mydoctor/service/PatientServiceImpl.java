package com.mydoctor.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mydoctor.dao.PatientDaoImpl;

import com.mydoctor.model.Patient;
import com.mydoctor.model.Prescription;


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
				String patient_id = patientDaoImpl.retrievePatientId(username);
				return patientDaoImpl.retrievePatient(patient_id);
		}
		public ArrayList<Patient> retrieveAllPatients() throws SQLException {
			return patientDaoImpl.retrieveAllPatients();
		}
		
//		public ArrayList<Prescription> retrivePrescriptionHistory(String patient_id) throws SQLException {
//			Patient patient = patientDaoImpl.retrievePatient(patient_id);
//			String id = patientDaoImpl.retrievePatientId(patient.getId());
//			return "";
//		}
		

}
