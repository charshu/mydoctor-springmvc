package com.mydoctor.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Size;

public class GeneralInfo {

	// @Size(min = 1, message = "Enter Username.")
	private String hospitalNumber;
	private double weight;
	private double height;
	private int heart_rate;
	
	private int pressureH;
	private int pressureL;
	private String congemital;
	private String med_allergy;
	private String symptom;
	private Date date;
	//private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
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
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate(Date date) {
		return date;
	}

	public GeneralInfo(String hospitalNumber, double weight, double height, int heart_rate, int pressureH,
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
		this.date = date;
	}

}


