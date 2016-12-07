package com.mydoctor.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.mydoctor.dao.PatientDaoImpl;
import com.mydoctor.model.Appointment;
import com.mydoctor.model.Patient;
import com.mydoctor.model.Schedule;
import com.mydoctor.util.EmailService;


public class PatientServiceImpl
{
		
		
		private PatientDaoImpl patientDaoImpl;
		private static DateTimeFormatter df = DateTimeFormat.forPattern("YYYY-MM-DD");
		public PatientDaoImpl getUserDao() {
			return patientDaoImpl;
		}
		public void setPatientDaoImpl(PatientDaoImpl patientDaoImpl) {
			this.patientDaoImpl = patientDaoImpl;
		}
		
		public Patient retrievePatient(String username) throws SQLException {
			int user_id = patientDaoImpl.retrieveUserId(username);
			int patient_id = patientDaoImpl.retrieveIdByUserId(user_id);
			return patientDaoImpl.retrievePatient(patient_id);
		}
		public Patient retrievePatientByHN(String hospitalNumber) throws SQLException {
	
			int patient_id = patientDaoImpl.retrievePatientIdByHN(hospitalNumber);
			return patientDaoImpl.retrievePatient(patient_id);
		}
		public Patient retrievePatientBySSN(String ssn) throws SQLException {
		
			int patient_id = patientDaoImpl.retrievePatientIdBySSN(ssn);
			return patientDaoImpl.retrievePatient(patient_id);
		}
		public ArrayList<Patient> retrieveAllPatients() throws SQLException {
			return patientDaoImpl.retrieveAllPatients();
			}
		public ArrayList<Appointment> retrieveAllAppointments(String username)throws SQLException{
			
			int user_id = patientDaoImpl.retrieveUserId(username);
			int patient_id = patientDaoImpl.retrieveIdByUserId(user_id);
			
			return patientDaoImpl.retrieveAllAppointments(patient_id);
			
		}
		public int retrieveId(String username)throws SQLException{
			int user_id = patientDaoImpl.retrieveUserId(username);
			return patientDaoImpl.retrieveIdByUserId(user_id);
		}
		public String retrieveHospitalNumberById(int patient_id)throws SQLException{
			if(patient_id==0)return null;
			return patientDaoImpl.retrieveHospitalNumberById(patient_id);
		}
		public int cancelAppointment(String username,int appointment_id)throws SQLException{
			int user_id = patientDaoImpl.retrieveUserId(username);
			int patient_id = patientDaoImpl.retrieveIdByUserId(user_id);
			if(patientDaoImpl.hasAppointmentId(patient_id,appointment_id)){
//				patientDaoImpl.deleteMakeAppointment(patient_id,appointment_id);
				patientDaoImpl.setStatusAppointment(appointment_id, "cancel");
				return 1;
			}
			System.out.println("error");
			return 0;
		}
		public int postponeAppointmentInSchedule(Schedule schedule)throws SQLException{
			ArrayList<Appointment> appointments = retrieveAppointmentByTimeRange(schedule.getStart(), schedule.getEnd());
			for(Appointment appointment:appointments){
				String email = patientDaoImpl.retrievePatientEmail(appointment.getPatientId());
				EmailService.emailPostponeAppointment(appointment,email,schedule);
			}
			return patientDaoImpl.setStatusAppointment(schedule.getStart(),schedule.getEnd(),"postpone");
		}
		public ArrayList<Appointment> retrieveAppointmentByTimeRange(Timestamp start,Timestamp end)throws SQLException{
			return patientDaoImpl.retrieveAppointmentByTimeRange(start, end);
		}
		
		

		public int edit_info(String username, Patient patient) throws SQLException {
			int patient_id = patientDaoImpl.retrieveIdByUserId(patientDaoImpl.retrieveUserId(username));
			System.out.println(patient_id);
			String name = patient.getName();
			String surname = patient.getSurname();
			String gender = patient.getGender();
			DateTime birthdate = df.parseDateTime(patient.getBirthdate());
		
			String address = patient.getAddress();
			String tel = patient.getTel();
			String email = patient.getEmail();
			
			return patientDaoImpl.editPatientInfo(name, surname, gender, birthdate, address, tel,email, patient_id);
	}

		public String retrievePatientNameByID(int id) throws SQLException {
			return patientDaoImpl.retrievePatientNameByID(id);
		}
			
		public int edit_info2(String hospitalNumber, Patient patient) throws SQLException {
			int patient_id = patientDaoImpl.retrievePatientIdByHN(hospitalNumber);
			System.out.println(patient_id);
			String name = patient.getName();
			String surname = patient.getSurname();
			String gender = patient.getGender();
			DateTime birthdate = df.parseDateTime(patient.getBirthdate());
			String address = patient.getAddress();
			String tel = patient.getTel();
			String email = patient.getEmail();
			
			return patientDaoImpl.editPatientInfo(name, surname, gender, birthdate, address, tel,email, patient_id);
	}
		


}
