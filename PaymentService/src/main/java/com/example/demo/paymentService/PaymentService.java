package com.example.demo.paymentService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.paymentEntity.Payment;
import com.example.demo.paymentRepository.PaymentRepository;
@Service
public class PaymentService {
	@Autowired
	public PaymentRepository repo;
	
	//get all Farmer info
	public List<Payment> getPaymentInfo()   
	{  
	List<Payment> payment = new ArrayList<Payment>();  
	repo.findAll().forEach(payment1 -> payment.add(payment1));  
	return payment;  
	}
	
	//get Farmer by id
	public Payment getPaymentById(int id) {
		return repo.findById(id).get();
	}
	
	//post Farmer info
	public void addPaymentInfo(Payment payment) {  
	repo.save(payment);  
	}  
	
	//deleting Farmer by id
	public void deletePaymentInfo(int id) {
		repo.deleteById(id);
	}
	
	//updating the Farmer
	public void updatePaymentInfo(int id,Payment payment) {
		repo.save(payment);
	}	

}
