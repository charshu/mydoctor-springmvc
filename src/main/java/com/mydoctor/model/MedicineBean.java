package com.mydoctor.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MedicineBean  {
	@NotNull
	private int id;
	
	private String name;
	
	@Size(min = 1,message="error")
	private String amount;
	@Size(min = 1,message="error")
	private String instruction;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
	
	
	/**
	 * @param id
	 * @param name
	 * @param amount
	 * @param instruction
	 */
	public MedicineBean(){
		
	}
	public MedicineBean(int id, String name, String amount, String instruction) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.instruction = instruction;
	}
	


	
	


}
