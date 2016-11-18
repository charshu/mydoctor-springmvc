package com.mydoctor.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mydoctor.model.Pharmacist;

public class PharmacistDaoImpl {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Pharmacist retrievePharmacist(String username)throws SQLException{
		//Find Pharmacist
		return new Pharmacist();
	}
}