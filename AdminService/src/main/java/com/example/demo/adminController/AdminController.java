package com.example.demo.adminController;

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
import com.example.demo.adminEntity.Admin;
import com.example.demo.adminRepository.AdminRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminRepository repository;
	
	@PostMapping("/addAdmin")
	public String saveAdmin(@RequestBody Admin admin) {
		repository.save(admin);
		return "Successfully Admin is added";
	}
	@GetMapping("/findAll")
	public List<Admin> getAdmin(){
		return repository.findAll();
	}
	@GetMapping("/findAll/{id}")
	public Optional<Admin> getAdmin(@PathVariable int id){
		return repository.findById(id);
	}
	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin) {
		return repository.save(admin);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteAdmin(@PathVariable int id) {
		 repository.deleteById(id);
		 return "Admin deleted";
	}
	
}
