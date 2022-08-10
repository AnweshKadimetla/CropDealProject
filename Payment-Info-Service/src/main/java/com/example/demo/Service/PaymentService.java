package com.example.demo.Service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Payment;
import com.example.demo.Repository.PaymentRepository;

@Service
public class PaymentService {
	 @Autowired
	    private PaymentRepository repository;

	    public Payment doPay(Payment payment){
	        payment.setPaymentStatus(paymentStatus());
	        payment.setTxId(UUID.randomUUID().toString());
	        return repository.save(payment);
	    }

	    private String paymentStatus(){
	        //mocking a 3rd party payment call like Gpay,Paytm,etc.
	        return new Random().nextBoolean()?"success":"failure";
	    }

}
