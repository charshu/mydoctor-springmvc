/**
 *
 */
package com.mydoctor.service;

import com.mydoctor.dao.HospitalDaoImpl;



public class HospitalServiceImpl
{
	HospitalDaoImpl hospitalDaoImpl;

	public HospitalDaoImpl getHospitalDaoImpl() {
		return hospitalDaoImpl;
	}

	public void setHospitalDaoImpl(HospitalDaoImpl hospitalDaoImpl) {
		this.hospitalDaoImpl = hospitalDaoImpl;
	}
	
	
		
}
