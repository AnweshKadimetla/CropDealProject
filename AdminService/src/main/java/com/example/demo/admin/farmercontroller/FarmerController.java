package com.example.demo.admin.farmercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.admin.exception.DataAlreadyExists;
import com.example.demo.admin.exception.UserNotFoundException;
import com.example.demo.admin.farmerentity.FarmerEntity;
import com.example.demo.admin.farmerservice.FarmerService;

@RestController
@RequestMapping("/farmers")
public class FarmerController {

	@Autowired
	FarmerService service;
	
	
	@GetMapping("/findAll")
	public List<FarmerEntity> getFarmerInfoService(){
		return service.getFarmerInfo();
	}
	
	@GetMapping("/findAll/{id}")  
	public FarmerEntity getFarmerInfoById(@PathVariable("id") int id) throws UserNotFoundException
	{  
		return service.getFarmerById(id);
	} 
	
	@PostMapping("/addFarmer")  
	public FarmerEntity addFarmerInfo(@RequestBody FarmerEntity farmer) throws DataAlreadyExists   
	{  
		service.addFarmerInfo(farmer); 
		return farmer;  
	}
	
	@PutMapping("/updateFarmer/{id}")  
	public FarmerEntity updateFarmerInfo(@PathVariable("id") int id,@RequestBody FarmerEntity farmer) throws UserNotFoundException   
	{  
		service.updateFarmerInfo(id,farmer);
	return farmer;  
	}  
	
	@DeleteMapping("/deleteFarmer/{id}")  
	public void deleteFarmerInfo(@PathVariable("id") int id)   
	{  
		 service.deleteFarmerInfo(id);  
	}  
}
