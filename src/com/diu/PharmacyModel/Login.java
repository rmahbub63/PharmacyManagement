package com.diu.PharmacyModel;

public class Login {

	private String userName;
	private String passWord;
	private String status;
	private String role;

	public Login(){
	}
	public Login(String userName, String passWord, String status, String role) {
		this.userName = userName;
		this.passWord = passWord;
		this.status = status;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
