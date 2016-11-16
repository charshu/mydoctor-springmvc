/**
 *
 */
package com.mydoctor.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mydoctor.model.Doctor;
import com.mydoctor.model.Patient;
import com.mydoctor.model.Schedule;



public interface HospitalService
{
	
	
	public ArrayList<Patient> retrievePatient(String username) throws SQLException;
	public ArrayList<Patient> retrieveAllPatients() throws SQLException;
	
	public Doctor retrieveDoctor(String username) throws SQLException;
	public ArrayList<Schedule> retriveAllSchedules(String username)throws SQLException;
	
		
}
