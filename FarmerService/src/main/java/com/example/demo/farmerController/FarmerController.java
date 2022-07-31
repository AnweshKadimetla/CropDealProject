package com.example.demo.farmerController;

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

import com.example.demo.farmerEntity.Farmer;
import com.example.demo.farmerRepository.FarmerRepository;
@RestController
@RequestMapping("/farmer")
public class FarmerController {
	@Autowired
	private FarmerRepository farmerRepository;
	@PostMapping("/addFarmer")
	public String saveFarmer(@RequestBody Farmer farmer) {
		farmerRepository.save(farmer);
		return "Farmer added";
	}
	
	@GetMapping("/findAll")
	public List<Farmer> getFarmer() {
		return farmerRepository.findAll();
	}
	@GetMapping("/findAll/{id}")
	public Optional<Farmer> getFarmer(@PathVariable int id) {
		return farmerRepository.findById(id);
	}
	
	@PutMapping("/updateFarmer")
	public Farmer updateFarmer(@RequestBody Farmer farmer) {
		return farmerRepository.save(farmer);	
	}
	@DeleteMapping("/delete/{id}")
	public String deleteFarmer(@PathVariable int id) {
		farmerRepository.deleteById(id);
		return "Farmer Deleted";
	}

}
