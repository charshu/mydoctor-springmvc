package com.mydoctor.model;

import java.util.ArrayList;

public class Doctor extends User {
	
	
	private String department;
	private String name,surname;
	private ArrayList<Schedule> schedules;
	
	public Doctor() {

		super();
	}
	public Doctor(int id,String username,String password, String type) {

		super(id,username, password, type);
	}
	public Doctor(int id,String username,String password, String type,String name ,String surname, String department) {
		
		super(id,username, password, type);
		this.department = department;
		this.name = name;
		this.surname = surname;
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
