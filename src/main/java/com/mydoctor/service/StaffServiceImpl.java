package com.mydoctor.service;


import java.sql.SQLException;
import java.util.Random;

import com.mydoctor.dao.NurseDaoImpl;
import com.mydoctor.dao.StaffDaoImpl;
import com.mydoctor.model.Doctor;
import com.mydoctor.model.GeneralInfo;
import com.mydoctor.model.Nurse;
import com.mydoctor.model.Patient;
import com.mydoctor.model.ViewInfo;


public class StaffServiceImpl
{
		
		private StaffDaoImpl staffDaoImpl;

		public StaffDaoImpl getStaffDaoImpl() {
			return staffDaoImpl;
		}

		public void setStaffDaoImpl(StaffDaoImpl staffDaoImpl) {
			this.staffDaoImpl = staffDaoImpl;
		}
		
	
		
		public GeneralInfo findPatientGenInfo(ViewInfo viewinfo) throws SQLException{
			int record_id = staffDaoImpl.retrieveRecordId(viewinfo.getHospitalNumber());
			System.out.println(record_id);
			return staffDaoImpl.retriveGenInfo(record_id);
		}
		
		public Patient findPatientInfo(ViewInfo viewinfo) throws SQLException{
			int patient_id = staffDaoImpl.retrievePatientId(viewinfo.getHospitalNumber());
			System.out.println(patient_id);
			return staffDaoImpl.retriveInfo(patient_id);
		}
		
		public String registerPatient(String username, Patient patient)throws SQLException{
			Random rnd = new Random();
			int n = 10000000 + rnd.nextInt(90000000);
			
			String ssn = patient.getSsn();
			String name = patient.getName();
			String surname = patient.getSurname();
			String gender = patient.getGender();
			String birth_date = patient.getBirthdate();
			String address = patient.getAddress();
			String tel = patient.getTel();
			String email = patient.getEmail();
			String hospitalNumber = Integer.toString(n);
			int code = staffDaoImpl.registerPatient(ssn, name, surname, gender, birth_date, address, tel, email, hospitalNumber);
			if(code > 0){
				return hospitalNumber;
			}else 
			return code+"";
		}

		

}
