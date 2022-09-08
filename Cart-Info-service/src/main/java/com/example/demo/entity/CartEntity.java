package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Cart")
public class CartEntity {
	private int id;
	private String CropName;
	private String CropType;
	private int CropPrice;
	private String CropLocation;
	private int Quantity;
	
	public CartEntity(int id, String cropName, String cropType, int cropPrice, String cropLocation, int quantity) {
		super();
		this.id = id;
		CropName = cropName;
		CropType = cropType;
		CropPrice = cropPrice;
		CropLocation = cropLocation;
		Quantity = quantity;
	}
	public CartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCropName() {
		return CropName;
	}
	public void setCropName(String cropName) {
		CropName = cropName;
	}
	public String getCropType() {
		return CropType;
	}
	public void setCropType(String cropType) {
		CropType = cropType;
	}
	public int getCropPrice() {
		return CropPrice;
	}
	public void setCropPrice(int cropPrice) {
		CropPrice = cropPrice;
	}
	public String getCropLocation() {
		return CropLocation;
	}
	public void setCropLocation(String cropLocation) {
		CropLocation = cropLocation;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	
}