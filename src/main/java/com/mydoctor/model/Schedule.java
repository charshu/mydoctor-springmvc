package com.das.obj;

public class Schedule {
	
	private String start_time,end_time,work_date,schedule_id;
	public Schedule(String schedule_id,String start_time,String end_time, String work_date) {
		// TODO Auto-generated constructor stub
		this.schedule_id = schedule_id;
		this.start_time = start_time;
		this.end_time = end_time;
		this.work_date = work_date;
	}
	public String getStart_time() {
		return start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public String getWork_date() {
		return work_date;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public void setWork_date(String work_date) {
		this.work_date = work_date;
	}
	public String getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(String schedule_id) {
		this.schedule_id = schedule_id;
	}
	

}
