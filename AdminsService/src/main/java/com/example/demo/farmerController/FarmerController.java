package com.example.demo.farmerController;

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


import com.example.demo.farmerEntity.Farmer;
import com.example.demo.farmerService.FarmerService;
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
	public Farmer getFarmerInfoById(@PathVariable("id") int id)   
	{  
		return farmerService.getFarmerById(id);
	} 
	
	@PostMapping("/addFarmer")  
	public Farmer addFarmerInfo(@RequestBody Farmer farmer)   
	{  
		farmerService.addFarmerInfo(farmer); 
		return farmer;  
	}
	
	@PutMapping("/updateFarmer/{id}")  
	public Farmer updateFarmerInfo(@PathVariable("id") int id,@RequestBody Farmer farmer)   
	{  
		farmerService.updateFarmerInfo(id,farmer);
	return farmer;  
	}  
	
	@DeleteMapping("/deleteFarmer/{id}")  
	public void deleteFarmerInfo(@PathVariable("id") int id)   
	{  
		farmerService.deleteFarmerInfo(id);  
	}  

}
