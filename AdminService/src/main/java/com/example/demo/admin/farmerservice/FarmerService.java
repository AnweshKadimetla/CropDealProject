package com.example.demo.admin.farmerservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.admin.exception.DataAlreadyExists;
import com.example.demo.admin.exception.UserNotFoundException;
import com.example.demo.admin.farmerentity.FarmerEntity;
import com.example.demo.admin.farmerrepository.FarmerRepos;

@Service
public class FarmerService {
	
	@Autowired
	FarmerRepos repo;
	
	public List<FarmerEntity> getFarmerInfo()   
	{  
	List<FarmerEntity> farmer = new ArrayList<FarmerEntity>();  
	repo.findAll().forEach(farmer1 -> farmer.add(farmer1));  
	return farmer;  
	}
	
	//get Farmer by id
	public FarmerEntity getFarmerById(int id) {
		return repo.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found"));
	}
	
	//post Farmer info
	public FarmerEntity addFarmerInfo(FarmerEntity farmer) throws DataAlreadyExists {  
		if(repo.existsById(farmer.getId()))throw new DataAlreadyExists(" Data Already Exists "+farmer.getId()+" use update to change ");
	return repo.save(farmer); 
	}  
	
	//deleting Farmer by id
	public void deleteFarmerInfo(int id) {
		repo.deleteById(id);
	}
	
	//updating the Farmer
	public FarmerEntity updateFarmerInfo(int id,FarmerEntity farmer) throws UserNotFoundException{
		FarmerEntity f=repo.findById(farmer.getId()).orElseThrow(()-> new UserNotFoundException("Data not found in the database"));
		farmer.setFirstName(f.getFirstName());
		return repo.save(farmer);
	}

}
