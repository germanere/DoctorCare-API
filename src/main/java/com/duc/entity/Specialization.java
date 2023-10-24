package com.duc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "specialiazations")
public class Specialization {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private int id;
	
	@Column(name = "created_at")
    private String createdAt;
	
	@Column(name = "deleted_at")
    private String deletedAt;
	
	@Column(name = "descript")
    private String description;
	
	@Column(name = "image")
    private String image;
	
	@Column(name = "namepk")
    private String name;
	
	@Column(name = "updated_at")
    private String updatedAt;
	
	@OneToOne(mappedBy = "specialization")
	private Post post;
	
	public Specialization() {
		
	}

	public Specialization(int id, String createdAt, String deletedAt, String description, String image, String name,
			String updatedAt, Post post) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
		this.description = description;
		this.image = image;
		this.name = name;
		this.updatedAt = updatedAt;
		this.post = post;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
