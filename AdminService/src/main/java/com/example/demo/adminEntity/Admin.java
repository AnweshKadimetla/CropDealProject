package com.example.demo.adminEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="Admin")
public class Admin {
	@Id
	private int id;
	private String name;
	private String permissions;
	
	public Admin() {
		super();
	}
	public Admin(int id, String name, String permissions) {
		super();
		this.id = id;
		this.name = name;
		this.permissions = permissions;
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
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	
	

}
