package com.example.demo.farmerEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Hi")
public class Farmer {
	@Id
	private int id;
	private String cropType;
	private String name;
	private String quantity;
	private int price;
	private String location;
	//Default constructor
	public Farmer() {
		super();
	}
	//Parameterized constructor
	public Farmer(int id, String cropType, String quantity, String location, int price,String name) {
		super();
		this.id = id;
		this.cropType = cropType;
		this.quantity = quantity;
		this.price = price;
		this.location = location;
		this.name=name;
	}
	//Getter and Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCropType() {
		return cropType;
	}

	public void setCropType(String cropType) {
		this.cropType = cropType;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
