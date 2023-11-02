package com.duc.dto;

public class DetailSchedulePatientDto {
	private String nameP;
	private String time;
	private String date;
	private String created_At;
	private String max_booking;
	private String sum_booking;
	private int status;
	
	public DetailSchedulePatientDto(String nameP, String time, String date, String created_At, String max_booking,
			String sum_booking, int status) {
		super();
		this.nameP = nameP;
		this.time = time;
		this.date = date;
		this.created_At = created_At;
		this.max_booking = max_booking;
		this.sum_booking = sum_booking;
		this.status = status;
	}
	public String getNameP() {
		return nameP;
	}
	public void setNameP(String nameP) {
		this.nameP = nameP;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCreated_At() {
		return created_At;
	}
	public void setCreated_At(String created_At) {
		this.created_At = created_At;
	}
	public String getMax_booking() {
		return max_booking;
	}
	public void setMax_booking(String max_booking) {
		this.max_booking = max_booking;
	}
	public String getSum_booking() {
		return sum_booking;
	}
	public void setSum_booking(String sum_booking) {
		this.sum_booking = sum_booking;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
