package com.mydoctor.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Size;

public class GeneralInfo {

	// @Size(min = 1, message = "Enter Username.")
	private double weight;
	private double height;
	private int heart_rate;
	private Timestamp recordDate;
	private int pressureH;
	private int pressureL;
	private String congemital;
	private String med_allergy;
	private String symptom;
	private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	
	public GeneralInfo(){
		
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
	public Timestamp getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Timestamp recordDate) {
		this.recordDate = recordDate;
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
	public DateFormat getDf() {
		return df;
	}
	public GeneralInfo(double weight, double height, int heart_rate, Timestamp recordDate, int pressureH, int pressureL,
			String congemital, String med_allergy, String symptom) {
		super();
		this.weight = weight;
		this.height = height;
		this.heart_rate = heart_rate;
		this.recordDate = recordDate;
		this.pressureH = pressureH;
		this.pressureL = pressureL;
		this.congemital = congemital;
		this.med_allergy = med_allergy;
		this.symptom = symptom;
	}

}


