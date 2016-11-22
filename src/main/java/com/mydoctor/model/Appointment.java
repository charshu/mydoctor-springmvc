package com.mydoctor.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Appointment {
	private int id;
	private Timestamp date;
	
	//@Size(min=1 , message="please fill symptom")
	private  String symptom;
	
	private int patientId;
	private String patientName;
	private String patientSurname;
	private String patientGender;
	private String patientHospitalNumber;
	
	private int doctorId;
	private String doctorName;
	private String doctorSurname;
	
	private final DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm");
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}


	public String getPatientHospitalNumber() {
		return patientHospitalNumber;
	}
	public void setPatientHospitalNumber(String patientHospitalNumber) {
		this.patientHospitalNumber = patientHospitalNumber;
	}
	public String getPatientSurname() {
		return patientSurname;
	}
	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
	}
	public String getDoctorSurname() {
		return doctorSurname;
	}
	public void setDoctorSurname(String doctorSurname) {
		this.doctorSurname = doctorSurname;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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


	public Appointment(int id, Timestamp date, String symptom, int doctorId, String patientName, String doctorName,
			int patientId) {
		super();
		this.id = id;
		this.date = date;
		this.symptom = symptom;
		this.doctorId = doctorId;
		this.patientName = patientName;
		this.doctorName = doctorName;
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
