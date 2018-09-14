package com.diu.PharmacyModel;

import java.util.Date;

public class Transiction {
	private String transictionNo;
	private String transictionDate;
	private String customerName;
	private String mobileNo;
	private String serviceProviderName;
	private double payableAmount;
	private double recievedAmount;
	private double returnAmount;

	public Transiction() {
	}

	public Transiction(String transictionNo, String transictionDate, String customerName, String mobileNo,
			String serviceProviderName, double payableAmount, double recievedAmount, double returnAmount) {
		this.transictionNo = transictionNo;
		this.transictionDate = transictionDate;
		this.customerName = customerName;
		this.mobileNo = mobileNo;
		this.serviceProviderName = serviceProviderName;
		this.payableAmount = payableAmount;
		this.recievedAmount = recievedAmount;
		this.returnAmount = returnAmount;
	}

	public String getTransictionNo() {
		return transictionNo;
	}

	public void setTransictionNo(String transictionNo) {
		this.transictionNo = transictionNo;
	}

	public String getTransictionDate() {
		return transictionDate;
	}

	public void setTransictionDate(String transictionDate) {
		this.transictionDate = transictionDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getServiceProviderName() {
		return serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}

	public double getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}

	public double getRecievedAmount() {
		return recievedAmount;
	}

	public void setRecievedAmount(double recievedAmount) {
		this.recievedAmount = recievedAmount;
	}

	public double getReturnAmount() {
		return returnAmount;
	}

	public void setReturnAmount(double returnAmount) {
		this.returnAmount = returnAmount;
	}
}
