package com.duc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "createdAt")
    private String createdAt;
	
	@Column(name = "date")
    private String date;
	
	@Column(name = "deletedAt")
    private String deletedAt;
	
	@Column(name = "maxBooking")
    private String maxBooking;
	
	@Column(name = "sumBooking")
    private String sumBooking;
	
	@Column(name = "time")
    private String time;
	
	@Column(name = "updatedAt")
    private String updatedAt;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "descript")
	private String descript; // 1 la cho xac nhan, 2 la da nhan, 3 la bi huy
	
	@ManyToOne
	@JoinColumn(name = "user_Id")
	private User users;
	
	public Schedule() {
		
	}

	public Schedule(int id, String createdAt, String date, String deletedAt, String maxBooking, String sumBooking,
			String time, String updatedAt, int status, String descript, User users) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.date = date;
		this.deletedAt = deletedAt;
		this.maxBooking = maxBooking;
		this.sumBooking = sumBooking;
		this.time = time;
		this.updatedAt = updatedAt;
		this.status = status;
		this.descript = descript;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getMaxBooking() {
		return maxBooking;
	}

	public void setMaxBooking(String maxBooking) {
		this.maxBooking = maxBooking;
	}

	public String getSumBooking() {
		return sumBooking;
	}

	public void setSumBooking(String sumBooking) {
		this.sumBooking = sumBooking;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}
	
}
