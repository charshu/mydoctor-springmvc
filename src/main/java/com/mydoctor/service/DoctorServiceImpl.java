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
		public int retrieveId(String username)throws SQLException{
			return doctorDaoImpl.retrieveId(username);
		}
		public ArrayList<Schedule> retriveAllSchedules(String username)throws SQLException{
			int doctor_id = retrieveId(username);
			return doctorDaoImpl.retriveAllSchedules(doctor_id);
		}
		public int saveSchedule(String username,Schedule schedule)throws SQLException{
			
			int schedule_id = doctorDaoImpl.insertSchedule(schedule);
			if(schedule_id == -1){
				System.out.println("[ERROR] cannot retrieve schedule_id");
				return 0;
			}
			int doctor_id = doctorDaoImpl.retrieveId(username);
			if(doctor_id == -1){
				System.out.println("[ERROR] cannot retrieve doctor_id");
				return 0;
			}
			if(doctorDaoImpl.insertDoctorSchedule(doctor_id, schedule_id) > 0)return 1;
			
			return 0;
		}
	
		
		
		
		
	
		

}
