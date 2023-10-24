package com.duc.dto;

public class UserDto {
	private String fullname;
	private String gender;
	private String email;
	private int phone;
	private String address;
	private String password;
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDto(String fullname, String gender, String email, int phone, String address, String password) {
		super();
		this.fullname = fullname;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.password = password;
	}
	public UserDto() {
	}
}
