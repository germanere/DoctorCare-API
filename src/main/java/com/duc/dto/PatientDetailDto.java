package com.duc.dto;

public class PatientDetailDto {
	private String nameDoctor;
	private String name;
	private String benhly;
	private String descript;
	private String date;
	private String time;
	
	public PatientDetailDto(String nameDoctor,String name, String benhly, String descript, String date, String time) {
		super();
		this.nameDoctor= nameDoctor;
		this.name = name;
		this.benhly = benhly;
		this.descript = descript;
		this.date = date;
		this.time = time;
	}

	public PatientDetailDto() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNameDoctor() {
		return nameDoctor;
	}

	public void setNameDoctor(String nameDoctor) {
		this.nameDoctor = nameDoctor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBenhly() {
		return benhly;
	}

	public void setBenhly(String benhly) {
		this.benhly = benhly;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
