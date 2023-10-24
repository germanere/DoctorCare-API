package com.duc.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "address")
	private String address;
	
	@Column(name="avatar")
	private String avatar;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "descript")
	private String descript;
	
	@Column(name = "created_at")
    private String createdAt;
	
	@Column(name = "deleted_at")
    private String deletedAt;
	
	@Column(name = "email")
    private String email;
	
	@Column(name="gender")
    private String gender;
	
	@Column(name = "password")
    private String password;
	
	@Column(name="phone")
    private int phone;
	
	@Column(name = "status")
    private int status;
	
	@Column(name = "updated_at")
    private String updatedAt;
	
    @ManyToOne
    @JoinColumn(name="role_id") 
    private Role role;
    
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "users")
    private Patient patient;
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "users")
    private List<Schedule> schedules;
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "users")
    private List<Post> posts;
    
    @OneToOne(mappedBy = "users")
    private DoctorUser doctorUser;
    
    @OneToOne(mappedBy = "users")
    private SupporterLog supporterLog;
    
    public User() {
		
	}

	public User(int id, String address, String avatar, String name, String descript, String createdAt, String deletedAt,
			String email, String gender, String password, int phone, int status, String updatedAt, Role role,
			Patient patient, List<Schedule> schedules, List<Post> posts, DoctorUser doctorUser,
			SupporterLog supporterLog) {
		super();
		this.id = id;
		this.address = address;
		this.avatar = avatar;
		this.name = name;
		this.descript = descript;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.phone = phone;
		this.status = status;
		this.updatedAt = updatedAt;
		this.role = role;
		this.patient = patient;
		this.schedules = schedules;
		this.posts = posts;
		this.doctorUser = doctorUser;
		this.supporterLog = supporterLog;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public DoctorUser getDoctorUser() {
		return doctorUser;
	}

	public void setDoctorUser(DoctorUser doctorUser) {
		this.doctorUser = doctorUser;
	}

	public SupporterLog getSupporterLog() {
		return supporterLog;
	}

	public void setSupporterLog(SupporterLog supporterLog) {
		this.supporterLog = supporterLog;
	}
    
}
