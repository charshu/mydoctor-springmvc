package com.mydoctor.model;


import javax.validation.constraints.Size;



public class ViewInfo {

	 @Size(min=8, max=8, message = "Please Correct Hospital Number")
	private String hospitalNumber;
	 
	public ViewInfo(){
		
	}

	public String getHospitalNumber() {
		return hospitalNumber;
	}

	public void setHospitalNumber(String hospitalNumber) {
		this.hospitalNumber = hospitalNumber;
	}

	public ViewInfo(String hospitalNumber) {
		super();
		this.hospitalNumber = hospitalNumber;
	}
	 

}


