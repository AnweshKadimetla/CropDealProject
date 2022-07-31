package com.example.demo.paymentController;

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
import com.example.demo.paymentEntity.Payment;
import com.example.demo.paymentRepository.PaymentRepository;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentRepository repository;
	
	@PostMapping("/addPayment")
	public String savePayment(@RequestBody Payment payment) {
		repository.save(payment);
		return "Successfully Payment is added";
	}
	@GetMapping("/findAll")
	public List<Payment> getPayment(){
		return repository.findAll();
	}
	@GetMapping("/findAll/{id}")
	public Optional<Payment> getPayment(@PathVariable int id){
		return repository.findById(id);
	}
	@PutMapping("/updatePayment")
	public Payment updatePayment(@RequestBody Payment payment) {
		return repository.save(payment);
	}
	@DeleteMapping("/delete/{id}")
	public String deletePayment(@PathVariable int id) {
		 repository.deleteById(id);
		 return "Payment deleted";
	}
}
