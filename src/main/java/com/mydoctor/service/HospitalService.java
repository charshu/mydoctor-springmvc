/**
 *
 */
package com.mydoctor.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mydoctor.model.Patient;



public interface HospitalService
{
	public ArrayList<Patient> retrieveAllPatients() throws SQLException;

		
}
