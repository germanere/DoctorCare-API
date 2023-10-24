package com.duc.dto;

public class SearchDocterDto {
	private int iduser;
	private String name;
	private String specliaztion;
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecliaztion() {
		return specliaztion;
	}
	public void setSpecliaztion(String specliaztion) {
		this.specliaztion = specliaztion;
	}
	public SearchDocterDto(int iduser, String name, String specliaztion) {
		super();
		this.iduser = iduser;
		this.name = name;
		this.specliaztion = specliaztion;
	}
	
}
