package com.diu.PharmacyModel;

public class Medicine {

	private String medicineCode;
	private String medicineName;
	private String medicineGenericName;
	private String medicineCompanyName;
	private String medicineCategory;
	private double medicinePackTotalSize;
	private double medicinePackTotalPrice;
	private double medicineIndividualPrice;
	private String medicineInfo;

	public Medicine() {

	}

	public Medicine(String medicineCode, String medicineName, String medicineGenericName, String medicineCompanyName,
			String medicineCategory, double medicinePackTotalSize, double medicinePackTotalPrice,
			double medicineIndividualPrice, String medicineInfo) {
		this.medicineCode = medicineCode;
		this.medicineName = medicineName;
		this.medicineGenericName = medicineGenericName;
		this.medicineCompanyName = medicineCompanyName;
		this.medicineCategory = medicineCategory;
		this.medicinePackTotalSize = medicinePackTotalSize;
		this.medicinePackTotalPrice = medicinePackTotalPrice;
		this.medicineIndividualPrice = medicineIndividualPrice;
		this.medicineInfo = medicineInfo;
	}

	public String getMedicineCode() {
		return medicineCode;
	}

	public void setMedicineCode(String medicineCode) {
		this.medicineCode = medicineCode;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineGenericName() {
		return medicineGenericName;
	}

	public void setMedicineGenericName(String medicineGenericName) {
		this.medicineGenericName = medicineGenericName;
	}

	public String getMedicineCompanyName() {
		return medicineCompanyName;
	}

	public void setMedicineCompanyName(String medicineCompanyName) {
		this.medicineCompanyName = medicineCompanyName;
	}

	public String getMedicineCategory() {
		return medicineCategory;
	}

	public void setMedicineCategory(String medicineCategory) {
		this.medicineCategory = medicineCategory;
	}

	public double getMedicinePackTotalSize() {
		return medicinePackTotalSize;
	}

	public void setMedicinePackTotalSize(double medicinePackTotalSize) {
		this.medicinePackTotalSize = medicinePackTotalSize;
	}

	public double getMedicinePackTotalPrice() {
		return medicinePackTotalPrice;
	}

	public void setMedicinePackTotalPrice(double medicinePackTotalPrice) {
		this.medicinePackTotalPrice = medicinePackTotalPrice;
	}

	public double getMedicineIndividualPrice() {
		return medicineIndividualPrice;
	}

	public void setMedicineIndividualPrice(double medicineIndividualPrice) {
		this.medicineIndividualPrice = medicineIndividualPrice;
	}

	public String getMedicineInfo() {
		return medicineInfo;
	}

	public void setMedicineInfo(String medicineInfo) {
		this.medicineInfo = medicineInfo;
	}
}
