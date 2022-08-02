package com.example.demo.dealerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dealerEntity.Dealer;
import com.example.demo.dealerService.DealerService;
@RestController
@RequestMapping("/dealer")
public class DealerController {
	
	@Autowired
	public DealerService dealerService;
	
	@GetMapping("/findAll")
	public List<Dealer> getDealerInfoService(){
		return dealerService.getDealerInfo();
	}
	
	@GetMapping("/findAll/{id}")  
	public Dealer getDealerInfoById(@PathVariable("id") int id)   
	{  
		return dealerService.getDealerById(id);
	} 
	
	@PostMapping("/addDealer")  
	public Dealer addDealerInfo(@RequestBody Dealer dealer)   
	{  
		dealerService.addDealerInfo(dealer); 
		return dealer;  
	}
	
	@PutMapping("/updateDealer/{id}")  
	public Dealer updateDealerInfo(@PathVariable("id") int id,@RequestBody Dealer dealer)   
	{  
		dealerService.updateDealerInfo(id,dealer);
	return dealer;  
	}  
	
	@DeleteMapping("/deleteDealer/{id}")  
	public void deleteDealerInfo(@PathVariable("id") int id)   
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
