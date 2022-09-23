package com.example.demo.admin.farmerentity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="FarmersDetails")
public class FarmerEntity {
	private int id;
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private String address;
	
	public FarmerEntity() {
		super();
	}

	
	public FarmerEntity(int id, String firstName, String lastName, int phoneNumber, String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
