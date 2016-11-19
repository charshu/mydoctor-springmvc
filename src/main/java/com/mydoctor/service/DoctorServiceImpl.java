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
			return doctorDaoImpl.retriveAllDoctorSchedules(doctor_id);
		}
		public ArrayList<Schedule> retriveAllDepartmentSchedules(String department)throws SQLException{
			return doctorDaoImpl.retriveAllDepartmentSchedules(department);
		}
		public ArrayList<Schedule> retriveAllSchedules()throws SQLException{
	
			return doctorDaoImpl.retriveAllSchedules();
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
		public int deleteSchedule(String username,int schedule_id)throws SQLException{
			int doctor_id = doctorDaoImpl.retrieveId(username);
			
			int updateCount = doctorDaoImpl.deleteDoctorSchedule(doctor_id,schedule_id);
			if( updateCount == 0 ){
				System.out.println("[ERROR] cannot delete doctor_schedule "
						+ "(doctor_id:"+doctor_id+",schedule_id:"+schedule_id+")");
			}
			
			updateCount = doctorDaoImpl.deleteSchedule(schedule_id);
			if( updateCount == 0){
				System.out.println("[ERROR] cannot delete schedule, schedule_id:"+schedule_id);
			}
			
			System.out.println("[SUCCESS] delete doctor_schedule "
					+ "(doctor_id:"+doctor_id+",schedule_id:"+schedule_id+")");
			return 1;
		}
	
		
		
		
		
	
		

}
