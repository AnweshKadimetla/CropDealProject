package com.example.demo.Entity;


public class Farmer {
	private String farmerId;
	private String cropType;
	private String name;
	private String quantity;
	private int price;
	private String location;
	
	
	public Farmer() {
		super();
		
	}
	public Farmer(String farmerId, String cropType, String name, String quantity, int price, String location) {
		super();
		this.farmerId = farmerId;
		this.cropType = cropType;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.location = location;
	}
	public String getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(String farmerId) {
		this.farmerId = farmerId;
	}
	public String getCropType() {
		return cropType;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Farmer [farmerId=" + farmerId + ", cropType=" + cropType + ", name=" + name + ", quantity=" + quantity
				+ ", price=" + price + ", location=" + location + "]";
	}
	
	
}
