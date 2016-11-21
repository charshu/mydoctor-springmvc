package com.mydoctor.model;


import javax.validation.constraints.Size;

import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;



public class GeneralInfo {

    @Size(min=8, max=8, message = "Please Correct Hospital Number")
	private String hospitalNumber;
    @Min(1)
    @Max(1000)
	private double weight;
   

    @Min(1)
    @Max(1000)
	private int height;
    @Min(1)
    @Max(400)
	private int heart_rate;
    @Min(1)
    @Max(400)
	private int pressureH;
    @Min(1)
    @Max(400)
	private int pressureL;
    @Size(max=500, message = "Congemital is too long")
	private String congemital;
    @Size(max=500, message = "Medicine allergy is too long")
	private String med_allergy;
    @Size(max=500, message = "Symptom is too long")
	private String symptom;
    
	private Date date;
	
	public GeneralInfo(){
		
	}

	public String getHospitalNumber() {
		return hospitalNumber;
	}

	public void setHospitalNumber(String hospitalNumber) {
		this.hospitalNumber = hospitalNumber;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeart_rate() {
		return heart_rate;
	}

	public void setHeart_rate(int heart_rate) {
		this.heart_rate = heart_rate;
	}

	public int getPressureH() {
		return pressureH;
	}

	public void setPressureH(int pressureH) {
		this.pressureH = pressureH;
	}

	public int getPressureL() {
		return pressureL;
	}

	public void setPressureL(int pressureL) {
		this.pressureL = pressureL;
	}

	public String getCongemital() {
		return congemital;
	}

	public void setCongemital(String congemital) {
		this.congemital = congemital;
	}

	public String getMed_allergy() {
		return med_allergy;
	}

	public void setMed_allergy(String med_allergy) {
		this.med_allergy = med_allergy;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}

	public GeneralInfo(String hospitalNumber, double weight, int height, int heart_rate, int pressureH,
			int pressureL, String congemital, String med_allergy, String symptom) {
		super();
		this.hospitalNumber = hospitalNumber;
		this.weight = weight;
		this.height = height;
		this.heart_rate = heart_rate;
		this.pressureH = pressureH;
		this.pressureL = pressureL;
		this.congemital = congemital;
		this.med_allergy = med_allergy;
		this.symptom = symptom;
		
	}
	
	public GeneralInfo(String hospitalNumber, double weight, int height, int heart_rate, int pressureH,
			int pressureL, String congemital, String med_allergy, String symptom, Date date) {
		super();
		this.hospitalNumber = hospitalNumber;
		this.weight = weight;
		this.height = height;
		this.heart_rate = heart_rate;
		this.pressureH = pressureH;
		this.pressureL = pressureL;
		this.congemital = congemital;
		this.med_allergy = med_allergy;
		this.symptom = symptom;
		this.date =date;
		
	}

}


