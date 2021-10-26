package com.hospital.model;

public class Medicine {
	
	private int medicineId;
	private String medicineName;
	private String medicineDescription;
	private String manufacturingDate;
	private String expiryDate;
	private int qty;
	

	public Medicine(int medicineId, String medicineName, String medicineDescription, String manufacturingDate,
			String expiryDate, int qty) {
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicineDescription = medicineDescription;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.qty = qty;
	}

	public Medicine() {
		
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineDescription() {
		return medicineDescription;
	}

	public void setMedicineDescription(String medicineDescription) {
		this.medicineDescription = medicineDescription;
	}

	public String getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
