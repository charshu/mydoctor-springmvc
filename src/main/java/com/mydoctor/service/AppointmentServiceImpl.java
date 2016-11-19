package com.mydoctor.service;

import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mydoctor.dao.DoctorDaoImpl;
import com.mydoctor.dao.PatientDaoImpl;
import com.mydoctor.model.Appointment;
import com.mydoctor.model.Patient;
import com.mydoctor.model.Schedule;

@Service
public class AppointmentServiceImpl {

	private PatientDaoImpl patientDaoImpl;
	private DoctorDaoImpl doctorDaoImpl;
	// private static String department;
	// private static int doctor_id;
	private static List<Schedule> schedules = new ArrayList<Schedule>();

	static {

	}

	public PatientDaoImpl getUserDao() {
		return patientDaoImpl;
	}

	public void setPatientDaoImpl(PatientDaoImpl patientDaoImpl) {
		this.patientDaoImpl = patientDaoImpl;
	}

	public void loadAllSchedule() throws SQLException {
		schedules = doctorDaoImpl.retriveAllSchedules();
		
	}
	public void loadAllDoctorSchedule(int doctor_id) throws SQLException {
		schedules = doctorDaoImpl.retriveAllDoctorSchedules(doctor_id);
		
	}
	public void loadDepartmentSchedule(String department) throws SQLException {
		schedules = doctorDaoImpl.retriveAllDepartmentSchedules(department);
	}

	
	public Timestamp findDoctorAvailableTime(int doctor_id) throws SQLException {
		loadAllDoctorSchedule(doctor_id);
		Timestamp today = new Timestamp(new Date().getTime());
		
		for(Schedule schedule:schedules){
			
			if(schedule.getStart().after(today) ){
				
			}
			
			
		}
		return new Timestamp(1);
	}

	public int cancelAppointment(String username, int appointment_id) throws SQLException {

		return 0;
	}

}
