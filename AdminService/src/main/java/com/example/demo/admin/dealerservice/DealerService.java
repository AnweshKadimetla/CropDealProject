package com.example.demo.admin.dealerservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.admin.dealerentity.DealerEntity;
import com.example.demo.admin.dealerrepository.DealerRepo;
import com.example.demo.admin.exception.DataAlreadyExists;
import com.example.demo.admin.exception.UserNotFoundException;
import com.example.demo.admin.farmerentity.FarmerEntity;

@Service
public class DealerService {
	
	@Autowired
	public DealerRepo repo;
	
	public List<DealerEntity> getDealerInfo()   
	{  
	List<DealerEntity> dealer = new ArrayList<DealerEntity>();  
	repo.findAll().forEach(dealer1 -> dealer.add(dealer1));  
	return dealer;  
	}
	
	//get Dealer by id
	public DealerEntity getDealerById(int id) {
		return repo.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found"));
	}
	
	//post Dealer info
	public void addDealerInfo(DealerEntity dealer)throws DataAlreadyExists {  
		if(repo.existsById(dealer.getId()))throw new DataAlreadyExists(" Data Already Exists "+dealer.getId()+" use update to change ");
	repo.save(dealer);  
	}  
	
	//deleting Dealer by id
	public void deleteDealerInfo(int id) {
		repo.deleteById(id);
	}
	
	//updating the Dealer
	public void updateDealerInfo(int id,DealerEntity dealer)throws UserNotFoundException{
		DealerEntity f=repo.findById(dealer.getId()).orElseThrow(()-> new UserNotFoundException("Data not found in the database"));
		repo.save(dealer);
	}
}
