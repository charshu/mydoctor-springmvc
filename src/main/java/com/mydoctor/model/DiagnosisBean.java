package com.mydoctor.model;


public class DiagnosisBean {
	
	private int id;
	private String disease_id;
	private String symptom;
	private int doctorId;
	private int patientId;
	public int getId() {
		return id;
	}
//	
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
	
	public String getDisease_id() {
		return disease_id;
	}
	public void setDisease_id(String disease_id) {
		this.disease_id = disease_id;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public DiagnosisBean() {
		super();
		
	}
	public DiagnosisBean(int id, String disease_id, String symptom, int doctorId, int patientId) {
		super();
		this.id = id;
		this.disease_id = disease_id;
		this.symptom = symptom;
		this.doctorId = doctorId;
		this.patientId = patientId;
	}
	
	
	
	

}
