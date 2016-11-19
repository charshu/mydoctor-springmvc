package com.mydoctor.model;

public class Patient extends User {
	
	
	private String ssn,name,surname,gender,email,tel,birthdate,address,hospitalNumber;

	public Patient() {
		super();
		
	}

	public Patient(String id, String username, String password, String role) {
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
