package com.mydoctor.model;

import java.util.ArrayList;


public class Doctor extends User {
	
	
	private String department;
	private String name,surname,tel;
	private ArrayList<Schedule> schedules;
	private String username1,password1;
	public Doctor() {

		super();
	}
	public Doctor(int id,String username,String password, String type) {

		super(id,username, password, type);
	}
	public Doctor(int id,String username,String password, String type,String name ,String surname, String department,String tel) {
		
		super(id,username, password, type);
		this.department = department;
		this.name = name;
		this.surname = surname;
		this.tel = tel;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getDepartment() {
		return department;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public ArrayList<Schedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(ArrayList<Schedule> schedules) {
		this.schedules = schedules;
	}
	
	public void addSchedule(Schedule schedule){
		schedules.add(schedule);
		//DAO
	}
	public void addSchedules(ArrayList<Schedule> schedules){
		for(Schedule schedule:schedules ){
			this.addSchedule(schedule);
		}
	}
	
	public void removeSchedule(String schedule_id){
		for(int i=0; i < schedules.size() ;i++){
			if( schedule_id.equals(schedules.get(i).getId() ) ){
				schedules.remove(i);
			}
		}
	}
	public void clearAllSchedule() {
		this.schedules = new ArrayList<Schedule>();
	}
	
	
	
	
	

}
