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
@Table(name = "extrainfos")
public class ExtraInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private int id;
	
	@Column(name = "created_at")
    private String createdAt;
	
	@Column(name = "deleted_at")
    private String deletedAt;
	
	@Column(name = "moreInfo")
    private String moreInfo;
	
	@Column(name = "oldForms")
    private String oldForms;
	
	@Column(name = "sendForms")
    private String sendForms;
    
	@Column(name = "updated_at")
    private String updatedAt;
	
	@Column(name = "status_patient")
	private String status;
	
	@OneToOne
    @JoinColumn(name="patient_Id")
    private Patient patient;
	
	@OneToOne
    @JoinColumn(name="place_Id")
    private Place place;
	
	public ExtraInfo() {

	}

	public ExtraInfo(int id, String createdAt, String deletedAt, String moreInfo, String oldForms, String sendForms,
			String updatedAt, Patient patient, Place place) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
		this.moreInfo = moreInfo;
		this.oldForms = oldForms;
		this.sendForms = sendForms;
		this.updatedAt = updatedAt;
		this.patient = patient;
		this.place = place;
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

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

	public String getOldForms() {
		return oldForms;
	}

	public void setOldForms(String oldForms) {
		this.oldForms = oldForms;
	}

	public String getSendForms() {
		return sendForms;
	}

	public void setSendForms(String sendForms) {
		this.sendForms = sendForms;
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

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
}
