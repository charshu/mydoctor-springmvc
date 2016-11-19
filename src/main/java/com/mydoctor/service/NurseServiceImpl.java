package com.mydoctor.service;


import java.sql.SQLException;

import com.mydoctor.dao.NurseDaoImpl;
import com.mydoctor.model.Doctor;
import com.mydoctor.model.GeneralInfo;
import com.mydoctor.model.Nurse;


public class NurseServiceImpl
{
		
		private NurseDaoImpl nurseDaoImpl;
		private GeneralInfo generalInfo;

		public NurseDaoImpl getNurseDaoImpl() {
			return nurseDaoImpl;
		}

		public void setNurseDaoImpl(NurseDaoImpl nurseDaoImpl) {
			this.nurseDaoImpl = nurseDaoImpl;
		}
		
		public Nurse retrieveNurse(String username)throws SQLException{
			return nurseDaoImpl.retrieveNurse(username);
		}
		
		public int retrieveId(String username)throws SQLException{
			return nurseDaoImpl.retrieveId(username);
		}
		
		public int add_info(String username, GeneralInfo generalInfo)throws SQLException{
			//dao 1 fn to insert general infp
			//get patient id then insert to patient_info table
			String hospitalNumber = generalInfo.getHospitalNumber();
			double weight = generalInfo.getWeight();
			double height = generalInfo.getHeight();
			int heart_rate = generalInfo.getHeart_rate();
			int pressureH = generalInfo.getPressureH();
			int pressureL = generalInfo.getPressureL();
			String congemital = generalInfo.getCongemital();
			String med_allergy = generalInfo.getMed_allergy();
			String symptom = generalInfo.getSymptom();
			
			int patient_id = nurseDaoImpl.retrievePatientId(hospitalNumber);
			if(patient_id == -1){
				System.out.println("[ERROR] No Patient Found");
				return 0;
			}
			if(nurseDaoImpl.insertInfo(hospitalNumber, weight,  height, heart_rate,pressureH, pressureL, congemital, med_allergy, symptom) > 0)return 1;

			
			return 0;
			
		}
		
		

}
