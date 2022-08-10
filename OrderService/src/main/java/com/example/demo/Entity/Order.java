package com.example.demo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Order")
public class Order {
	@Id
	private int id;
	private String cropType;
	private String name;
	private int quantity;
	private int price;
	private String location;
	//Default constructor
	public Order() {
		super();
	}
	//Parameterized constructor
	public Order(int id, String cropType, int quantity, int price, String location,String name) {
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
