package com.duc.dto;

public class addScheldulesDto {
	private String namedoctor;
	private String time;
	private int iduser;
	private String name;
	private int phone;
	private String address;
	private String email;
	private String gender;
	
	public addScheldulesDto() {
		
	}
	public addScheldulesDto(String namedoctor, String time,int iduser ,String name, int phone, String address,String email,String gender) {
		super();
		this.namedoctor = namedoctor;
		this.time = time;
		this.iduser= iduser;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email= email;
		this.gender = gender;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getNamedoctor() {
		return namedoctor;
	}
	public void setNamedoctor(String namedoctor) {
		this.namedoctor = namedoctor;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
}
