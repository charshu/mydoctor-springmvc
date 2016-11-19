package com.mydoctor.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mydoctor.dao.PatientDaoImpl;
import com.mydoctor.model.Appointment;
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
				String patient_id = patientDaoImpl.retrievePatientId(username);
				return patientDaoImpl.retrievePatient(patient_id);
		}
		public ArrayList<Patient> retrieveAllPatients() throws SQLException {
			return patientDaoImpl.retrieveAllPatients();
			}
		public ArrayList<Appointment> retrieveAllAppointments(String username)throws SQLException{
			int patient_id = patientDaoImpl.retrievePatientId(username);
			return patientDaoImpl.retrieveAllAppointments(patient_id);
			
			

		}
		
		

}
