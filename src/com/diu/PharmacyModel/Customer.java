package com.diu.PharmacyModel;

public class Customer {
	private String customerId;
	private String customername;
	private String customerGender;
	private String customerNID;
	private String customerContact;
	private String customerDateOfBirth;
	private String customeraddress;
	private String customerEmail;
	private String customerRegistrationDate;

	public Customer() {
	}

	public Customer(String customerId, String customername, String customerGender, String customerNID,
			String customerContact, String customerDateOfBirth, String customeraddress, String customerEmail,
			String customerRegistrationDate) {
		this.customerId = customerId;
		this.customername = customername;
		this.customerGender = customerGender;
		this.customerNID = customerNID;
		this.customerContact = customerContact;
		this.customerDateOfBirth = customerDateOfBirth;
		this.customeraddress = customeraddress;
		this.customerEmail = customerEmail;
		this.customerRegistrationDate = customerRegistrationDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerNID() {
		return customerNID;
	}

	public void setCustomerNID(String customerNID) {
		this.customerNID = customerNID;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getCustomerDateOfBirth() {
		return customerDateOfBirth;
	}

	public void setCustomerDateOfBirth(String customerDateOfBirth) {
		this.customerDateOfBirth = customerDateOfBirth;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerRegistrationDate() {
		return customerRegistrationDate;
	}

	public void setCustomerRegistrationDate(String customerRegistrationDate) {
		this.customerRegistrationDate = customerRegistrationDate;
	}
}
