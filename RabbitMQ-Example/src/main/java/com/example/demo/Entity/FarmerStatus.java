package com.example.demo.Entity;


public class FarmerStatus {
	private Farmer farmer;
	private String status;
	private String message;
	
	public FarmerStatus() {
		super();
	}
	public FarmerStatus(Farmer farmer, String status, String message) {
		super();
		this.farmer = farmer;
		this.status = status;
		this.message = message;
	}
	public Farmer getFarmer() {
		return farmer;
	}
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "FarmerStatus [farmer=" + farmer + ", status=" + status + ", message=" + message + "]";
	}
	

}
