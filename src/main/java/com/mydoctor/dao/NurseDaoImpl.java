package com.mydoctor.dao;



import java.sql.SQLException;

import javax.sql.DataSource;

import com.mydoctor.model.Nurse;

public class NurseDaoImpl {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Nurse retrieveNurse(String username)throws SQLException{
		//Find nurse
		return new Nurse();
	}
	
	
	

}