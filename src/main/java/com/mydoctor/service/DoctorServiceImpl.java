package com.mydoctor.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mydoctor.dao.DoctorDaoImpl;

import com.mydoctor.model.Doctor;
import com.mydoctor.model.Schedule;


public class DoctorServiceImpl
{
		
		
		private DoctorDaoImpl doctorDaoImpl;
		
		
		public DoctorDaoImpl getDoctorDaoImpl() {
			return doctorDaoImpl;
		}
		public void setDoctorDaoImpl(DoctorDaoImpl doctorDaoImpl) {
			this.doctorDaoImpl = doctorDaoImpl;
		}
		
		public Doctor retrieveDoctor(String username) throws SQLException {
			return doctorDaoImpl.retrieveDoctor(username);
			}
		public String retrieveId(String username)throws SQLException{
			return doctorDaoImpl.retrieveId(username);
		}
		public ArrayList<Schedule> retriveAllSchedules(String username)throws SQLException{
			String doctor_id = retrieveId(username);
			return doctorDaoImpl.retriveAllSchedules(doctor_id);
		}
		public boolean saveSchedule(String username,Schedule schedule)throws SQLException{
			String doctor_id = retrieveId(username);
			return doctorDaoImpl.saveSchedule(doctor_id,schedule);
		}
	
		
		
		
		
	
		

}
