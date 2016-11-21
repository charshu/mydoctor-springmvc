package com.mydoctor.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Appointment {
	private int id;
	private Timestamp date;
	private  String symptom;
	private int doctorId;
	private int patientId;
	private final DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm");
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
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

	public Appointment(int id, Timestamp date, String symptom, int doctorId, int patientId) {
		super();
		this.id = id;
		this.date = date;
		this.symptom = symptom;
		this.doctorId = doctorId;
		this.patientId = patientId;
	}
	public String printDate(){
		return df.format(this.date);
	}
	@Override
	public String toString() {
		return "APTID: " + this.id + "DID: " + this.id + "PID: " + this.id + " ,Date: " + df.format(this.date) + " ,Symptom: " + this.symptom +"\n";
	}
	
}
