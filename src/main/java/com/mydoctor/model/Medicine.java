package com.mydoctor.model;

public class Medicine  {
	private String  medicine;
	private int medicineId;
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


}
