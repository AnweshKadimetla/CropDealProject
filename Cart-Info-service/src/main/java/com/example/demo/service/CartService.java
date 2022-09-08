package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CartEntity;
import com.example.demo.exception.DataAlreadyExists;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.repository.CartRepository;
@Service
public class CartService {
	

	@Autowired
	public CartRepository cartRepository;
	
	//get all Farmer info
	public List<CartEntity> getCartInfo()   
	{  
	List<CartEntity> cart = new ArrayList<CartEntity>();  
	cartRepository.findAll().forEach(cart1 -> cart.add(cart1));  
	return cart;  
	}
	
	//get Farmer by id
	public CartEntity getCartById(int id) throws ResourceNotFound{
		return cartRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Record not found"));
	}
	
	//post Farmer info
	public CartEntity addCartInfo(CartEntity cart) throws DataAlreadyExists {  
		if(cartRepository.existsById(cart.getId()))throw new DataAlreadyExists("Data Already exists"+cart.getId()+"use update to change");
		return cartRepository.save(cart);
	}  
	
	//deleting Farmer by id
	public String deleteCartEntityInfo(int id) {
		cartRepository.deleteById(id);
		return "Deleted";
	}
	
	//updating the Farmer
	public Optional<CartEntity> updateCartInfo(int id,CartEntity cart) throws ResourceNotFound{
		CartEntity f = cartRepository.findById(cart.getId()).orElseThrow(()-> new ResourceNotFound("Data not found in the database"));
		cartRepository.save(cart);
		return Optional.empty();
	}

}
