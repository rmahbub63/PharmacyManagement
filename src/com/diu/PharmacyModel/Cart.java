package com.diu.PharmacyModel;

public class Cart {
	private String transictionNo;
	private String medicineCode;
	private String medicineName;
	private int quantity;
	private double unitPrice;
	private double totalPrice;
	
	public Cart() {

	}

	public Cart(String transictionNo, String medicineCode, String medicineName, int quantity, double unitPrice,
			double totalPrice) {
		this.transictionNo = transictionNo;
		this.medicineCode = medicineCode;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}

	public String getTransictionNo() {
		return transictionNo;
	}

	public void setTransictionNo(String transictionNo) {
		this.transictionNo = transictionNo;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
