package com.duc.dto;

public class ClinicsDto {
	private String address;
	private String name;
	private String phone;
    private String description;
    private int price;
	public ClinicsDto(String address, String name, String phone, String description,int price) {
		super();
		this.address = address;
		this.name = name;
		this.phone = phone;
		this.description = description;
		this.price=price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
    
}
