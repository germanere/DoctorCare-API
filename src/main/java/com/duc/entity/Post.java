package com.duc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private int id;
	
	@Column(name = "confirmedByDoctor")
    private boolean confirmedByDoctor;
	
	@Column(name = "contentHTML")
    private String contentHTML;
	
	@Column(name = "createdAt")
    private String createdAt;
	
	@Column(name = "deletedAt")
    private String deletedAt;
	
	@Column(name = "image")
    private String image;
	
	@Column(name = "title")
    private String title;
    
    @Column(name = "updatedAt")
    private String updatedAt;
    
    @Column(name = "booking")
    private int booking;
    
    @OneToOne
    @JoinColumn(name="clinic_Id")   
    private Clinic clinic;
	
    @OneToOne
    @JoinColumn(name="specialization_Id")
    private Specialization specialization;
    
	@ManyToOne
	@JoinColumn(name = "user_Id")
    private User users;
	
	public Post() {
		
	}

	public Post(int id, boolean confirmedByDoctor, String contentHTML, String createdAt, String deletedAt, String image,
			String title, String updatedAt, Clinic clinic, Specialization specialization, User users) {
		super();
		this.id = id;
		this.confirmedByDoctor = confirmedByDoctor;
		this.contentHTML = contentHTML;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
		this.image = image;
		this.title = title;
		this.updatedAt = updatedAt;
		this.clinic = clinic;
		this.specialization = specialization;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isConfirmedByDoctor() {
		return confirmedByDoctor;
	}

	public void setConfirmedByDoctor(boolean confirmedByDoctor) {
		this.confirmedByDoctor = confirmedByDoctor;
	}

	public String getContentHTML() {
		return contentHTML;
	}

	public void setContentHTML(String contentHTML) {
		this.contentHTML = contentHTML;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}
	
}
