package com.mydoctor.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


public class Patient extends User {
	@Email(message = "Please correct Email")
    @Size(min=1,max=255, message = "Please correct Email")
	private String email;

	@Size(max=13, min=7, message = "Please correct SSN")
	private String ssn;

	@Size(min=1,max=30, message = "Please correct Patient Name")
	private String name;

	@Size(min=1,max=30, message = "Please correct Patient Surname")
	private String surname;

	@Size(min=1,max=12, message = "Please correct Gender length")
	private String gender;
	
	@Size(min=9, max=12, message = "Please correct Telephone Number")
	private String tel;
	
	private String birthdate;

	@Size(min=1,max=255, message = "Please correct Address")
	private String address;

	private String hospitalNumber;

	public Patient() {
		super();
		
	}

	public Patient(int id, String username, String password, String role) {
		super(id, username, password, role);
		
	}

	public Patient(String ssn, String name, String surname, String gender, String email, String tel, String birthdate,
			String address, String hospitalNumber) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.email = email;
		this.tel = tel;
		this.birthdate = birthdate;
		this.address = address;
		this.hospitalNumber = hospitalNumber;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHospitalNumber() {
		return hospitalNumber;
	}

	public void setHospitalNumber(String hospitalNumber) {
		this.hospitalNumber = hospitalNumber;
	}

	


}
