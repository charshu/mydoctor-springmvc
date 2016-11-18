package com.mydoctor.model;

public class Pharmacist extends User  {
	private String name,surname;
	
	public Pharmacist(){
		super();
	}
	
	public Pharmacist(String id,String username,String password, String type) {

		super(id,username, password, type);
	}
	public Pharmacist(String id,String username,String password,String name ,String surname,String type) {
		
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
