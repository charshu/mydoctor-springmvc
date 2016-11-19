package com.mydoctor.service;


import java.sql.SQLException;

import com.mydoctor.dao.NurseDaoImpl;
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
		
		public int add_info(GeneralInfo generalInfo)throws SQLException{
			return nurseDaoImpl.insertInfo(generalInfo);
		}
		
		

}
