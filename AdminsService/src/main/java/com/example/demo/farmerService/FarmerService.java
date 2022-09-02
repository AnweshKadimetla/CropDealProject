package com.example.demo.farmerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.DataAlreadyExists;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.farmerEntity.Farmer;
import com.example.demo.farmerRepository.FarmerRepository;
@Service
public class FarmerService {
	
	@Autowired
	public FarmerRepository farmerRepository;
	
	//get all Farmer info
	public List<Farmer> getFarmerInfo()   
	{  
	List<Farmer> farmer = new ArrayList<Farmer>();  
	farmerRepository.findAll().forEach(farmer1 -> farmer.add(farmer1));  
	return farmer;  
	}
	
	//get Farmer by id
	public Farmer getFarmerById(int id) throws ResourceNotFound{
		return farmerRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Record not found"));
	}
	
	//post Farmer info
	public Farmer addFarmerInfo(Farmer farmer) throws DataAlreadyExists {  
		if(farmerRepository.existsById(farmer.getId()))throw new DataAlreadyExists("Data Already exists"+farmer.getId()+"use update to change");
		return farmerRepository.save(farmer);
	}  
	
	//deleting Farmer by id
	public void deleteFarmerInfo(int id) {
		farmerRepository.deleteById(id);
	}
	
	//updating the Farmer
	public void updateFarmerInfo(int id,Farmer farmer) throws ResourceNotFound{
		Farmer f = farmerRepository.findById(farmer.getId()).orElseThrow(()-> new ResourceNotFound("Data not found in the database"));
		farmerRepository.save(farmer);
	}

}
