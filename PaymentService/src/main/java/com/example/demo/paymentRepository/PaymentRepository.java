package com.example.demo.paymentRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.paymentEntity.Payment;

public interface PaymentRepository extends MongoRepository<Payment, Integer>{
	

}
