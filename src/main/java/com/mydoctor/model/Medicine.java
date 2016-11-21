package com.mydoctor.model;

public class Medicine  {
	private String  medicine,instruction;
	private int medicineId,amount;
	public Medicine(){
		
	}
	
	public Medicine(int medicineId,String medicine) {
		this.medicineId = medicineId;
		this.medicine = medicine;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAmount() {
		return amount;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}


}
