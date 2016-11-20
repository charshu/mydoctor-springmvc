package com.mydoctor.model;

public class Nurse extends User  {
	private String name,surname;
	
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

}
