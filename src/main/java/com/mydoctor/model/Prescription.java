package com.mydoctor.model;

public class Prescription  {
	private String instruction, status;
	private int prescriptionId, medicineId,amount;
	private Medicine medicine;
	
	public Prescription() {
		
	}
	
	public Prescription(int prescriptionId,int medicineId,String medicine,String instruction, int amount,String status) {
		this.prescriptionId = prescriptionId;
		this.medicineId = medicineId;
		this.instruction = instruction;
		this.amount = amount;
		this.status = status;
	}

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
