package com.mydoctor.model;

public class Medicine  {
	private String medicineId, medicine;
	
	public Medicine(){
		
	}
	
	public Medicine(String medicineId,String medicine) {
		this.medicineId = medicineId;
		this.medicine = medicine;
	}

	public String getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}


}
