package com.duc.dto;

public class AddDoctorAccDto {
	private String namedoctor;
	private int phone;
	private String address;
	private String gender;
	private String email;
	private String password;
	private int roleid;
	private int clinicid;
	
	public AddDoctorAccDto() {
		
	}
	
	public AddDoctorAccDto(String namedoctor,int phone, String address, String gender, String email,
			String password, int roleid, int clinicid) {
		super();
		this.namedoctor = namedoctor;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.roleid = roleid;
		this.clinicid = clinicid;
	}
	public String getNamedoctor() {
		return namedoctor;
	}
	public void setNamedoctor(String namedoctor) {
		this.namedoctor = namedoctor;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public int getClinicid() {
		return clinicid;
	}
	public void setClinicid(int clinicid) {
		this.clinicid = clinicid;
	}
	
}
