package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CartEntity;
import com.example.demo.service.CartService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	public CartService Service;
	
	@GetMapping("/findAll")
	public List<CartEntity> getEntityInfoService(){
		return Service.getCartInfo();
	}
	
	@GetMapping("/findAll/{id}")  
	public CartEntity getEntityInfoById(@PathVariable("id") int id)   
	{  
		return Service.getCartById(id);
	} 
	
	@PostMapping("/addCart")  
	public CartEntity addCartEntityInfo(@RequestBody CartEntity cartentity)   
	{  
		Service.addCartInfo(cartentity); 
		return cartentity;  
	}
	
	@PutMapping("/updateCart/{id}")  
	public CartEntity updateCartEntityInfo(@PathVariable("id") int id,@RequestBody CartEntity cartentity)   
	{  
		Service.updateCartInfo(id,cartentity);
	return cartentity;  
	}  
	
	@DeleteMapping("/deleteCart/{id}")  
	public void deleteCartEntityInfo(@PathVariable("id") int id)   
	{  
		Service.deleteCartEntityInfo(id);  
	}  
}
