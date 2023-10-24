package com.duc.dto;

public class UserinfoDto {
	private String name;
	private String address;
	private String gender;
	private String email;
	private int phone;
	
	public UserinfoDto() {
		
	}
	
	public UserinfoDto(String name, String address, String gender, String email, int phone) {
		super();
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
}
