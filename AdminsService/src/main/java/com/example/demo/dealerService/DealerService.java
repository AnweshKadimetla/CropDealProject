package com.example.demo.dealerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dealerEntity.Dealer;
import com.example.demo.dealerRepository.DealerRepository;
import com.example.demo.exception.DataAlreadyExists;
import com.example.demo.exception.ResourceNotFound;

@Service
public class DealerService {
	@Autowired
	public DealerRepository dealerRepository;
	
	//get all Dealer info
	public List<Dealer> getDealerInfo()   
	{  
	List<Dealer> dealer = new ArrayList<Dealer>();  
	dealerRepository.findAll().forEach(dealer1 -> dealer.add(dealer1));  
	return dealer;  
	}
	
	//get Dealer by id
	public Dealer getDealerById(int id) {
		return dealerRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Record Not Found"));
		
	}
	
	//post Dealer info
	public Dealer addDealerInfo(Dealer dealer)throws DataAlreadyExists  {  
		if(dealerRepository.existsById(dealer.getId()))throw new DataAlreadyExists(" Data Already Exists "+dealer.getId()+" use update to change ");
		return dealerRepository.save(dealer);   
	}  
	
	//deleting Farmer by id
		public void deleteDealerInfo(int id) {
			dealerRepository.deleteById(id);
	}
	
	//updating the Dealer
	public void updateDealerInfo(int id,Dealer dealer)throws ResourceNotFound {
		Dealer f=dealerRepository.findById(dealer.getId()).orElseThrow(()-> new ResourceNotFound("Data not found in the database"));
		dealerRepository.save(dealer);
	}

}
