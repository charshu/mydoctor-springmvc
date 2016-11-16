package com.mydoctor.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mydoctor.dao.DoctorDaoImpl;
import com.mydoctor.dao.HospitalDao;
import com.mydoctor.dao.LoginDaoImpl;
import com.mydoctor.model.Doctor;
import com.mydoctor.model.Patient;
import com.mydoctor.model.Schedule;
import com.mydoctor.model.User;


public class DoctorServiceImpl
{
		
		
		private DoctorDaoImpl doctorDaoImpl;
		
		
		public DoctorDaoImpl getDoctorDaoImpl() {
			return doctorDaoImpl;
		}
		public void setDoctorDaoImpl(DoctorDaoImpl doctorDaoImpl) {
			this.doctorDaoImpl = doctorDaoImpl;
		}
		
		
		public ArrayList<Schedule> retriveAllSchedules(String username)throws SQLException{
			return doctorDaoImpl.retriveAllSchedules(username);
		}
	
		public ArrayList<Patient> retrievePatient(String username) throws SQLException {
		return null;
		}
	
		public ArrayList<Patient> retrieveAllPatients() throws SQLException {
		return null;
		}
	
		public Doctor retrieveDoctor(String username) throws SQLException {
		return doctorDaoImpl.retrieveDoctor(username);
		}
		public void test(){
			
		}
		
		
	
		

}
