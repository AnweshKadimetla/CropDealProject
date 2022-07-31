package com.example.demo.paymentEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Payment")
public class Payment {
	@Id
	private int id;
	private int amount;
	private String status;
	
	public Payment() {
		super();
		
	}
	public Payment(int id, int amount, String status) {
		super();
		this.id = id;
		this.amount = amount;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
