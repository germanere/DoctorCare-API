package com.duc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "clinics")
public class Clinic {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private int id;
	
	@Column(name = "address")
    private String address;
	
	@Column(name = "created_At")
    private String createdAt;
	
	@Column(name = "descript")
    private String description;
	
	@Column(name = "image")
    private String image;
	
	@Column(name = "introduction")
    private String introduction;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "phone")
    private String phone;
	
	@Column(name="price")
	private int price;
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@OneToOne(mappedBy = "clinic")
	private Post post;
	
	@OneToOne(mappedBy = "clinic")
	private DoctorUser doctorUser;
	
	public Clinic() {
		
	}

	public Clinic(int id, String address, String createdAt, String description, String image, String introduction,
			String name, String phone, Post post, DoctorUser doctorUser) {
		super();
		this.id = id;
		this.address = address;
		this.createdAt = createdAt;
		this.description = description;
		this.image = image;
		this.introduction = introduction;
		this.name = name;
		this.phone = phone;
		this.post = post;
		this.doctorUser = doctorUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public DoctorUser getDoctorUser() {
		return doctorUser;
	}

	public void setDoctorUser(DoctorUser doctorUser) {
		this.doctorUser = doctorUser;
	}
	
}
