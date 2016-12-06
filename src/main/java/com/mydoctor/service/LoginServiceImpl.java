package com.mydoctor.service;

import java.sql.SQLException;
import java.util.Random;

import com.mydoctor.dao.LoginDaoImpl;
import com.mydoctor.model.Patient;



public class LoginServiceImpl 
{
		
		
		private LoginDaoImpl loginDaoImpl;
		
		public LoginDaoImpl getLoginDaoImpl() {
			return loginDaoImpl;
		}
		
		public void setLoginDaoImpl(LoginDaoImpl loginDaoImpl) {
			this.loginDaoImpl = loginDaoImpl;
		}

		public boolean isValidUser(String username, String password) throws SQLException
		{
			return loginDaoImpl.isValidUser(username, password);
		}

		public String getUserRole(String username) throws SQLException {
			return loginDaoImpl.getUserRole(username);
		}
		
		public String registerPatient(Patient patient)throws SQLException{
			Random rnd = new Random();
			int n = 10000000 + rnd.nextInt(90000000);
			String username = patient.getUsername1();
			System.out.println(username);
			String password = patient.getPassword1();
			String ssn = patient.getSsn();
			String name = patient.getName();
			String surname = patient.getSurname();
			String gender = patient.getGender();
			String birth_date = patient.getBirthdate();
			String address = patient.getAddress();
			System.out.println(address);
			String tel = patient.getTel();
			String email = patient.getEmail();
			String hospitalNumber = Integer.toString(n);
			
		
			int user_id = loginDaoImpl.registerUserId(username, password);
			if(user_id == -2)return "-2";
			int code = loginDaoImpl.registerPatient(ssn, name, surname, gender, birth_date, address, tel, email, hospitalNumber, user_id);
			if(code > 0){
				return hospitalNumber;
			}
			else return code+"";
			
			
	
		}
		
		public int createUserIdByHN(Patient patient)throws SQLException{
			String username = patient.getUsername1();
			String password = patient.getPassword1();
			String hospitalNumber = patient.getHospitalNumber();
			if(loginDaoImpl.hasUserIdByHN(hospitalNumber)!=0)return -5; //user id not NULL or not found hospital number
			int user_id = loginDaoImpl.registerUserId(username, password);
			if(user_id == -2)return -2;
			return loginDaoImpl.createUserIdByHN(user_id, hospitalNumber);
		}

		public int createUserIdBySSN(Patient patient)throws SQLException{
			
			String username = patient.getUsername1();
			String password = patient.getPassword1();
			String ssn = patient.getSsn();
			if(loginDaoImpl.hasUserIdBySSN(ssn)!=0)return -6; //user id not NULL or not found ssn
			int user_id = loginDaoImpl.registerUserId(username, password);
			if(user_id == -2)return -2;
			return loginDaoImpl.createUserIdBySSN(user_id, ssn);
		}

}
