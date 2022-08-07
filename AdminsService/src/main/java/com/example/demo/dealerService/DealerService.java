package com.example.demo.dealerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dealerEntity.Dealer;
import com.example.demo.dealerRepository.DealerRepository;
import com.example.demo.exception.ResourceNotFound;

@Service
public class DealerService {
	@Autowired
	public DealerRepository repo;
	
	//get all Dealer info
	public List<Dealer> getDealerInfo()   
	{  
	List<Dealer> dealer = new ArrayList<Dealer>();  
	repo.findAll().forEach(dealer1 -> dealer.add(dealer1));  
	return dealer;  
	}
	
	//get Dealer by id
	public Dealer getDealerById(int id) {
		Dealer dealer = repo.findById(id).orElseThrow(()-> new ResourceNotFound("Record Not Found"));
		return dealer;
	}
	
	//post Dealer info
	public void addDealerInfo(Dealer dealer) {  
	repo.save(dealer);  
	}  
	
	//deleting Dealer by id
	public void deleteDealerInfo(int id) {
		repo.deleteById(id);
	}
	
	//updating the Dealer
	public void updateDealerInfo(int id,Dealer dealer) {
		repo.save(dealer);
	}

}
