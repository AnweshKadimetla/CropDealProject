package com.example.demo.dealerRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.dealerEntity.Dealer;

public interface DealerRepository extends MongoRepository<Dealer,Integer>{

}
