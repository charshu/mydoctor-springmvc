package com.mydoctor.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Schedule {
	
	private String id;
	//Date stores in format milliseconds -> 1000022311231
	private Date start,end;
	private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	
	public Schedule(){
	
	}

	public Schedule(String id, Date start, Date end) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "The schedule id : " + this.id + " Start time : " + df.format(start) + " End time : " + df.format(end);
	}
	
	
	public boolean isWithinRange(Date date){
		return date.after(start) && date.before(end);
	}
	public String printStart(){
		return df.format(this.start);
	}
	public String printEnd(){
		return df.format(this.end);
	}
	
}
