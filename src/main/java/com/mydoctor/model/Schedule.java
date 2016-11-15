package com.mydoctor.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Schedule {
	
	private String schedule_id;
	private Date start,end;
	public Schedule(String schedule_id,Date start,Date end) {
		// TODO Auto-generated constructor stub
		this.schedule_id = schedule_id;
		this.start = start;
		this.end = end;
	}
	public Date getStart_time() {
		return start;
	}
	public Date getEnd_time() {
		return end;
	}

	public void setStart_time(Date start_time) {
		this.start = start_time;
	}
	public void setEnd_time(Date end_time) {
		this.end = end_time;
	}
	public String getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(String schedule_id) {
		this.schedule_id = schedule_id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "The schedule id : " + this.schedule_id + " Start time : " + this.start.toString() + " End time : " + this.end.toString();
	}
	
	
	public boolean isAvailable(Date date){
		
		boolean start_time,end_time;
		start_time = date.after(this.start) || date.equals(this.start);
		end_time = date.before(this.end);
			
		return start_time && end_time;
		
	}
	public class main {
	
		
		
		

	}

	
}
