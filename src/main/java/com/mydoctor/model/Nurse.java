package com.mydoctor.model;

public class Nurse extends User  {
	private String name,surname;
	
	public Nurse(){
		super();
	}
	
	public Nurse(String id,String username,String password, String type) {

		super(id,username, password, type);
	}
	public Nurse(String id,String username,String password,String name ,String surname,String type) {
		
		super(id,username, password, type);
		this.name = name;
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public void setName() {
		this.name = name;
	}
	public void setSurname() {
		this.surname = surname;
	}
}
