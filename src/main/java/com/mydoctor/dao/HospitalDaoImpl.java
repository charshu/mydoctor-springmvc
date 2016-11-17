package com.mydoctor.dao;

import javax.sql.DataSource;


public class HospitalDaoImpl
{
		
	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
}
