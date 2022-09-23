package com.example.demo.admin.dealercontroller;

import java.util.Arrays;
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
import org.springframework.web.client.RestTemplate;

import com.example.demo.admin.dealerentity.DealerEntity;
import com.example.demo.admin.dealerservice.DealerService;
import com.example.demo.admin.exception.DataAlreadyExists;
import com.example.demo.admin.exception.UserNotFoundException;

@RestController
@RequestMapping("/dealer")
public class DealerController {
	
	@Autowired
	public DealerService service;
	
	@GetMapping("/findAll")
	public List<DealerEntity> getDealerInfoService(){
			return service.getDealerInfo();
			
	}
	
	@GetMapping("/findAll/{id}")
	public DealerEntity getDealerInfoById(@PathVariable("id")int id) throws UserNotFoundException { 
		return service.getDealerById(id);
	}

	@PostMapping("/addDealer")
	public DealerEntity addDealerInfo(@RequestBody DealerEntity dealer)throws DataAlreadyExists {
		service.addDealerInfo(dealer);
		return dealer;
	}
	
	@PutMapping("/updateDealer/{id}")
	public DealerEntity updateDealerInfo(@PathVariable("id")int id,@RequestBody DealerEntity dealer)throws UserNotFoundException {
			service.updateDealerInfo(id, dealer);
			return dealer;
	}
	
	
	@DeleteMapping("/deleteDealer/{id}")
		public void deleteDealerInfo(@PathVariable("id") int id) {
			service.deleteDealerInfo(id);
		}
	
}
