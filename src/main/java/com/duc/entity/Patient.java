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
@Table(name = "patients")
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "status") 
    private int status; // 0 la khoa , 1 la hoat dong
	
	@Column(name = "descript")
	private String descript;
	
	@Column(name = "pathology")
	private String pathology;
	
	@Column(name = "pathologydetail")
	private String pathologydetail;
	
	@OneToOne
    @JoinColumn(name="user_id")
    private User users;
	
	@OneToOne(mappedBy = "patient")
	private ExtraInfo extraInfo;
	
	@OneToOne(mappedBy = "patient")
	private SupporterLog supporterLog;
	
	public Patient() {
		
	}

	public Patient(int id, String name, int status, String pathology, String pathologydetail, User users,String descript,
			ExtraInfo extraInfo, SupporterLog supporterLog) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.pathology = pathology;
		this.pathologydetail = pathologydetail;
		this.descript=descript;
		this.users = users;
		this.extraInfo = extraInfo;
		this.supporterLog = supporterLog;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public ExtraInfo getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(ExtraInfo extraInfo) {
		this.extraInfo = extraInfo;
	}

	public SupporterLog getSupporterLog() {
		return supporterLog;
	}

	public void setSupporterLog(SupporterLog supporterLog) {
		this.supporterLog = supporterLog;
	}

	public String getPathology() {
		return pathology;
	}

	public void setPathology(String pathology) {
		this.pathology = pathology;
	}

	public String getPathologydetail() {
		return pathologydetail;
	}

	public void setPathologydetail(String pathologydetail) {
		this.pathologydetail = pathologydetail;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}
		
}
