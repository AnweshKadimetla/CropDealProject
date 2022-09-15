package com.example.demo.farmerController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.DataAlreadyExists;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.farmerEntity.Farmer;
import com.example.demo.farmerService.FarmerService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/farmers")
public class FarmerController {
	
	@Autowired
	public FarmerService farmerService;
	
	@GetMapping("/findAll")
	public List<Farmer> getFarmerInfoService(){
		return farmerService.getFarmerInfo();
	}
	
	@GetMapping("/findAll/{id}")  
	public ResponseEntity<Farmer> getFarmerInfoById(@PathVariable("id") int id) throws ResourceNotFound  
	{  
		Farmer farmer= farmerService.getFarmerById(id);
		return new ResponseEntity<Farmer>(farmer,HttpStatus.OK);
	} 
	
	@PostMapping("/addFarmer")  
	public Farmer addFarmerInfo(@RequestBody Farmer farmer)throws DataAlreadyExists    
	{  
		farmerService.addFarmerInfo(farmer); 
		return farmer;  
	}
	
	@PutMapping("/updateFarmer/{id}")  
	public void updateFarmerInfo(@PathVariable("id") int id,@RequestBody Farmer farmer)throws ResourceNotFound      
	{  
		farmerService.updateFarmerInfo(id,farmer);
		
	}  
	
	@DeleteMapping("/deleteFarmer/{id}")  
	public String deleteFarmerInfo(@PathVariable("id") int id)   
	{  
		farmerService.deleteFarmerInfo(id);  
		return "Deleted";
	}  
}
