package com.mydoctor.model;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Schedule {
	
	private int id;
	//Date stores in format milliseconds -> 1000022311231
	@NotNull
	@DateTimeFormat(pattern = "E dd-MM-YYYY HH:mm")
	private Timestamp start;
	@NotNull
	@DateTimeFormat(pattern = "E dd-MM-YYYY HH:mm")
	private Timestamp end;
	private final DateFormat df = new SimpleDateFormat("E dd-MM-YYYY HH:mm");
	
	public Schedule(){
	
	}

	public Schedule(int id, Timestamp start, Timestamp end) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getStart() {
		return start;
	}
	public void setStart(Timestamp start) {
		this.start = start;
	}
	public Timestamp getEnd() {
		return end;
	}
	public void setEnd(Timestamp end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "ID: " + this.id + " ,Start: " + df.format(this.start) + " ,End: " + df.format(this.end) + "\n";
	}
	public long duration(){
		return this.end.getTime() - this.start.getTime();
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
