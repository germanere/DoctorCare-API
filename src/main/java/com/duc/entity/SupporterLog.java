package com.duc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "supporterlogs")
public class SupporterLog {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private int id;
	
	@Column(name = "content")
    private String content;
	
	@Column(name = "createdAt")
    private String createdAt;
	
	@Column(name = "deletedAt")
    private String deletedAt;
	
	@Column(name = "updatedAt")
    private String updatedAt;
	
	@OneToOne
	@JoinColumn(name = "patient_Id")
    private Patient patient;
	
	@OneToOne
	@JoinColumn(name = "user_Id")
    private User users;
	public SupporterLog() {
		
	}
	public SupporterLog(int id, String content, String createdAt, String deletedAt, String updatedAt, Patient patient,
			User users) {
		super();
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
		this.updatedAt = updatedAt;
		this.patient = patient;
		this.users = users;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	
}
