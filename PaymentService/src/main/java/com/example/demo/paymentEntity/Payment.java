package com.example.demo.paymentEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Payment")
public class Payment {
	@Id
	private int t_id;
	private String s_name;
	private String r_name;
	private long amount;
	
	//Default constructor
	public Payment() {
		super();
	}
	//Parameterized constructor
	public Payment(int t_id, String s_name, String r_name,int amount) {
		super();
		this.t_id = t_id;
		this.s_name = s_name;
		this.r_name = r_name;
		this.amount = amount;
	}
	//Getter and Setter
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	
	

}
