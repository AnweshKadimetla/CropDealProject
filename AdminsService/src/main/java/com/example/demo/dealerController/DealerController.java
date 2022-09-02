package com.example.demo.dealerController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dealerEntity.Dealer;
import com.example.demo.dealerService.DealerService;
import com.example.demo.exception.DataAlreadyExists;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.farmerEntity.Farmer;
@RestController
@RequestMapping("/dealer")
public class DealerController {
	///Rest Template
	@Autowired
	private RestTemplate restTemplate;
	private static String url="http://localhost:8070/farmers/findAll";
	private static String url1="http://localhost:8070/dealer/findAll";
	@GetMapping("/farmer")
	public List<Object> getFarmer(){
		Object[] farmer=restTemplate.getForObject(url,Object[].class);
		return Arrays.asList(farmer);
	}
	@GetMapping("/dealerinfo")
	public List<Object> getDealer(){
		Object[] dealer=restTemplate.getForObject(url1,Object[].class);
		return Arrays.asList(dealer);
	}
	//////////////
	@Autowired
	public DealerService dealerService;
	
	@GetMapping("/findAll")
	public List<Dealer> getDealerInfoService(){
		return dealerService.getDealerInfo();
	}
	
	@GetMapping("/findAll/{id}")  
	public ResponseEntity<Dealer> getDealerInfoById(@PathVariable("id") int id) throws ResourceNotFound   
	{  
		 Dealer dealer= dealerService.getDealerById(id);
		 return new ResponseEntity<Dealer>(dealer,HttpStatus.OK);//Exception
	} 
	
	@PostMapping("/addDealer")  
	public Dealer addDealerInfo(@RequestBody Dealer dealer)throws DataAlreadyExists   
	{  
		dealerService.addDealerInfo(dealer); 
		return dealer;  
	}
	
	@PutMapping("/updateDealer/{id}")  
	public void updateDealerInfo(@PathVariable("id") int id,@RequestBody Dealer dealer)throws ResourceNotFound   
	{  
		dealerService.updateDealerInfo(id,dealer);
		
	}  
	

	@DeleteMapping("/deleteDealer/{id}")  
	public void deleteFarmerInfo(@PathVariable("id") int id)   
	{  
		dealerService.deleteDealerInfo(id);  
	}  
	
	/*
	 * @GetMapping("/admin-info") public List<AdminEntity> getAdminInfoService(){
	 * return this.adminrepo.findAll();
	 * 
	 * }
	 * 
	 * @GetMapping("/admin-info/{id}") public AdminEntity
	 * getAdminById(@PathVariable(value="id")Integer id) { return
	 * adminrepo.findById(id); }
	 * 
	 * @PostMapping("/admin-save") public AdminEntity addAdminInfo(@RequestBody
	 * AdminEntity adminEntity) { return this.adminrepo.save(adminEntity); }
	 * 
	 * @RequestMapping("/info") public String getAdminInfo() {
	 * 
	 * return "This Is Admin-Info"; }
	 */
}
