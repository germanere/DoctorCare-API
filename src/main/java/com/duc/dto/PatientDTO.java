package com.duc.dto;

public class PatientDTO {
	 private String name;
	 private String gender;
	 private String address;
	 private String pathology;
	 private String pathologydetail;
	 
	public PatientDTO(String name, String gender, String address, String pathology, String pathologydetail) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.pathology = pathology;
		this.pathologydetail = pathologydetail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPathology() {
		return pathology;
	}

	public void setPathology(String pathology) {
		this.pathology = pathology;
	}

	public String getPathologydetail() {
		return pathologydetail;
	}

	public void setPathologydetail(String pathologydetail) {
		this.pathologydetail = pathologydetail;
	}
	 
}
