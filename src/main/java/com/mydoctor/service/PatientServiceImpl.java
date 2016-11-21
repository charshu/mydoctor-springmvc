package com.mydoctor.service;

import java.sql.SQLException;
import java.sql.Timestamp;
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
				int patient_id = patientDaoImpl.retrievePatientId(username);
				return patientDaoImpl.retrievePatient(patient_id);
		}
		public ArrayList<Patient> retrieveAllPatients() throws SQLException {
			return patientDaoImpl.retrieveAllPatients();
			}
		public ArrayList<Appointment> retrieveAllAppointments(String username)throws SQLException{
			int patient_id = patientDaoImpl.retrievePatientId(username);
			return patientDaoImpl.retrieveAllAppointments(patient_id);
			
		}
	
		public int cancelAppointment(String username,int appointment_id)throws SQLException{
			
			
			return 0;
		}
		
		public int edit_info(String username, Patient patient) throws SQLException {
			int patient_id = patientDaoImpl.retrievePatientId(username);
			System.out.println(patient_id);
			String name = patient.getName();
			String surname = patient.getSurname();
			String gender = patient.getGender();
			String birthdate = patient.getBirthdate();
			String address = patient.getAddress();
			String tel = patient.getTel();
			String email = patient.getEmail();
			
			return patientDaoImpl.editPatientInfo(name, surname, gender, birthdate, address, tel,email, patient_id);
	}

}
