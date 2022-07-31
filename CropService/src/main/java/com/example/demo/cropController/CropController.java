package com.example.demo.cropController;

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
import com.example.demo.cropEntity.Crop;
import com.example.demo.cropRepository.CropRepository;

@RestController
@RequestMapping("/crop")
public class CropController {
	@Autowired
	private CropRepository repository;
	
	@PostMapping("/addCrop")
	public String saveCrop(@RequestBody Crop crop) {
		repository.save(crop);
		return "Successfully Crop is added";
	}
	@GetMapping("/findAll")
	public List<Crop> getCrop(){
		return repository.findAll();
	}
	@GetMapping("/findAll/{id}")
	public Optional<Crop> getCrop(@PathVariable int id){
		return repository.findById(id);
	}
	@PutMapping("/updateCrop")
	public Crop updateCrop(@RequestBody Crop crop) {
		return repository.save(crop);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteCrop(@PathVariable int id) {
		 repository.deleteById(id);
		 return "Crop deleted";
	}
}
