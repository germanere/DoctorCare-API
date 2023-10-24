package com.duc.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "created_at")
    private String createdAt;
	
	@Column(name = "deleted_at")
    private String deletedAt;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "updated_at")
    private String updatedAt;
	
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
    private List<User> users ;

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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
    
    public Role() {
    	
    }

	public Role(int id, String createdAt, String deletedAt, String name, String updatedAt, List<User> users) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
		this.name = name;
		this.updatedAt = updatedAt;
		this.users = users;
	}
    
}
