package com.mydoctor.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mydoctor.dao.PatientDaoImpl;
import com.mydoctor.model.Appointment;
import com.mydoctor.model.Patient;
import com.mydoctor.model.Schedule;

@Service
public class AppointmentServiceImpl
{
		
		private PatientDaoImpl patientDaoImpl;
		private static String department;
		private static int doctor_id;
		private static List<Schedule> schedules = new ArrayList<Schedule>();
		
		public PatientDaoImpl getUserDao() {
			return patientDaoImpl;
		}
		public void setPatientDaoImpl(PatientDaoImpl patientDaoImpl) {
			this.patientDaoImpl = patientDaoImpl;
		}
		
		public Patient retrieveDepartmentSchedule(String department) throws SQLException {
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
		public Timestamp findNearestTime(String username,Appointment appointment)throws SQLException{
			
			return 0;
		}
		public int cancelAppointment(String username,int appointment_id)throws SQLException{
			
			
			return 0;
		}
		
		

}
