package com.example.demo.dealerController;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dealerEntity.Dealer;
import com.example.demo.dealerRepository.DealerRepository;



@RestController

@RequestMapping("/dealer")
public class DealerController {
	@Autowired
	private DealerRepository repository;
	
	@PostMapping("/addDealer")
	public String saveDealer(@RequestBody Dealer dealer) {
		repository.save(dealer);
		return "Successfully dealer is added";
	}
	@GetMapping("/findAll")
	public List<Dealer> getDealer(){
		return repository.findAll();
	}
	@GetMapping("/findAll/{id}")
	public Optional<Dealer> getDealer(@PathVariable int id){
		return repository.findById(id);
	}
	@PutMapping("/updateDealer")
	public Dealer updateDealer(@RequestBody Dealer dealer) {
		return repository.save(dealer);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteDealer(@PathVariable int id) {
		 repository.deleteById(id);
		 return "Dealer deleted";
	}
	
}
