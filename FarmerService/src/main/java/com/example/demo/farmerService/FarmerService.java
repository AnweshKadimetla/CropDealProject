package com.example.demo.farmerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.farmerEntity.Farmer;
import com.example.demo.farmerRepository.FarmerRepository;
@Service
public class FarmerService {
	
	@Autowired
	public FarmerRepository repo;
	
	//get all Farmer info
	public List<Farmer> getFarmerInfo()   
	{  
	List<Farmer> farmer = new ArrayList<Farmer>();  
	repo.findAll().forEach(farmer1 -> farmer.add(farmer1));  
	return farmer;  
	}
	
	//get Farmer by id
	public Farmer getFarmerById(int id) {
		return repo.findById(id).get();
	}
	
	//post Farmer info
	public void addFarmerInfo(Farmer farmer) {  
	repo.save(farmer);  
	}  
	
	//deleting Farmer by id
	public void deleteFarmerInfo(int id) {
		repo.deleteById(id);
	}
	
	//updating the Farmer
	public void updateFarmerInfo(int id,Farmer farmer) {
		repo.save(farmer);
	}

}
