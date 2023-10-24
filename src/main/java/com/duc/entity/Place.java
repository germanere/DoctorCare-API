package com.duc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "places")
public class Place {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "created_at")
    private String createdAt;
	
	@Column(name = "deleted_at")
    private String deletedAt;
	
	@Column(name = "updated_at")
    private String updatedAt;
	
	@OneToOne(mappedBy = "place")
	private ExtraInfo extraInfo;
	
	public Place() {
		
	}

	public Place(int id, String name, String createdAt, String deletedAt, String updatedAt, ExtraInfo extraInfo) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
		this.updatedAt = updatedAt;
		this.extraInfo = extraInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public ExtraInfo getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(ExtraInfo extraInfo) {
		this.extraInfo = extraInfo;
	}
	
}
