/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diu.PharmacyModel;

/**
 *
 * @author softbinDeveloper
 */
public class Employee {

	private String employeId;
	private String employeeName;
	private String fatherName;
	private String motherName;
	private String department;
	private String presentAddress;
	private String permanentAddress;
	private String contact;
	private String email;
	private String joinDate;
	private String reference;

	public Employee() {
	}

	public Employee(String employeId, String employeeName, String fatherName, String motherName, String department,
			String presentAddress, String permanentAddress, String contact, String email, String joinDate,
			String reference) {
		this.employeId = employeId;
		this.employeeName = employeeName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.department = department;
		this.presentAddress = presentAddress;
		this.permanentAddress = permanentAddress;
		this.contact = contact;
		this.email = email;
		this.joinDate = joinDate;
		this.reference = reference;
	}

	public String getEmployeId() {
		return employeId;
	}

	public void setEmployeId(String employeId) {
		this.employeId = employeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
}
