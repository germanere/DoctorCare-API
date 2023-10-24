package com.duc.dto;

public class SearchResultDto {
	private int id;
	private String name;
	private String address;
	private int price;
	private String chuyenkhoa;
	
	public SearchResultDto(int id, String name, String address, int price, String chuyenkhoa) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.price = price;
		this.chuyenkhoa = chuyenkhoa;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getChuyenkhoa() {
		return chuyenkhoa;
	}
	public void setChuyenkhoa(String chuyenkhoa) {
		this.chuyenkhoa = chuyenkhoa;
	}
	
	
}
