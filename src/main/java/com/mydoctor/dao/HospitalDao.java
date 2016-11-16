package com.mydoctor.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mydoctor.model.Doctor;
import com.mydoctor.model.Patient;
import com.mydoctor.model.Schedule;


public interface HospitalDao
{
		
		public Patient retrievePatient(String username) throws SQLException;
		public ArrayList<Patient> retrieveAllPatients() throws SQLException;
		
		public Doctor retrieveDoctor(String username)throws SQLException ;
		
		public ArrayList<Schedule> retriveSchedules(String username,String schedule_id)throws SQLException ;
		public ArrayList<Schedule> retriveAllSchedules(String username)throws SQLException ;
		
		
}
