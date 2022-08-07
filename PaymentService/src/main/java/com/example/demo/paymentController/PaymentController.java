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
import com.example.demo.paymentService.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	

	@Autowired
	public PaymentService paymentService;
	
	@GetMapping("/findAll")
	public List<Payment> getPaymentInfoService(){
		return paymentService.getPaymentInfo();
	}
	
	@GetMapping("/findAll/{id}")  
	public Payment getPaymentInfoById(@PathVariable("id") int id)   
	{  
		return paymentService.getPaymentById(id);
	} 
	
	@PostMapping("/addPayment")  
	public Payment addFarmerInfo(@RequestBody Payment payment)   
	{  
		paymentService.addPaymentInfo(payment); 
		return payment;  
	}
	
	@PutMapping("/updatePayment/{id}")  
	public Payment updatePaymentInfo(@PathVariable("id") int id,@RequestBody Payment payment)   
	{  
		paymentService.updatePaymentInfo(id,payment);
	return payment;  
	}  
	
	@DeleteMapping("/deletePayment/{id}")  
	public void deletePaymentInfo(@PathVariable("id") int id)   
	{  
		paymentService.deletePaymentInfo(id);  
	}  
}
