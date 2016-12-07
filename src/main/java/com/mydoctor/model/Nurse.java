package com.mydoctor.model;

import javax.validation.constraints.NotNull;

public class Nurse extends User  {
	@NotNull
	private String name,surname;
	@NotNull
	private String username1,password1;
	
	public Nurse(){
		super();
	}
	
	public Nurse(int id,String username,String password, String type) {

		super(id,username, password, type);
	}
	public Nurse(int id,String username,String password,String name ,String surname,String type) {
		
		super(id,username, password, type);
		this.name = name;
		this.surname = surname;
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

	public String getUsername1() {
		return username1;
	}

	public void setUsername1(String username1) {
		this.username1 = username1;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	

}
