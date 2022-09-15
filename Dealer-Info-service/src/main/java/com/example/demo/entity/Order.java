package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OrderDetails")
public class Order {
	
	private String farmerId;
	private String cropType;
	private String orderId;
	private String location;
	private String cropName;
	private int quantity;
	private int price;
	
	public Order() {
		super();
	}
	
	public Order(String orderId, String location, String farmerId,String cropType,String name, int quantity, int price) {
		super();
		this.orderId = orderId;
		this.location = location;
		this.cropName = name;
		this.quantity = quantity;
		this.price = price;
		this.farmerId=farmerId;
		this.cropType=cropType;
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
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String string) {
		this.orderId = string;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return cropName;
	}
	public void setName(String name) {
		this.cropName = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "DealerEntity [orderId=" + orderId + ", location=" + location + ", name=" + cropName + ", quantity="
				+ quantity + ", price=" + price + ",farmerId="+farmerId+",CropType="+cropType+"]";
	}
	

}
