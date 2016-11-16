package com.mydoctor.model;

import java.util.ArrayList;

public class Doctor extends User {
	
	private String department;
	private String name,surname;
	private ArrayList<Schedule> schedule_arr;
	public Doctor() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Doctor(String id,String username,String password, String type) {
		// TODO Auto-generated constructor stub
		super(id,username, password, type);
	}
	public Doctor(String id,String username,String password, String type,String name ,String surname, String department) {
		// TODO Auto-generated constructor stub
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
	
	public void addSchedule(Schedule schedule){
		schedule_arr.add(schedule);
		//DAO
		
	}
	public void addSchedules(ArrayList<Schedule> schedules){
		for(Schedule schedule:schedules ){
			this.addSchedule(schedule);
		}
		
	}
	public void removeSchedule(String schedule_id){
		for(int i=0; i < schedule_arr.size() ;i++){
			if( schedule_id.equals(schedule_arr.get(i).getSchedule_id() ) ){
				schedule_arr.remove(i);
			}
		}
	}
	public ArrayList<Schedule> getSchedule_arr() {
		return schedule_arr;
	}
	public void setSchedule_arr(ArrayList<Schedule> schedule_arr) {
		this.schedule_arr = schedule_arr;
	}
	
	
	

}
