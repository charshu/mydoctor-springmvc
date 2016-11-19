package com.mydoctor.model;

import java.sql.Timestamp;

public class Appointment {
	private int id;
	private Timestamp date;
	private  String symptom;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public Appointment(){
		super();
	}
	public Appointment(int id, Timestamp date, String symptom) {
		super();
		this.id = id;
		this.date = date;
		this.symptom = symptom;
	}
	
	
}
