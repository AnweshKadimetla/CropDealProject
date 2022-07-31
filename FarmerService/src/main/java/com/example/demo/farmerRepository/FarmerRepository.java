package com.example.demo.farmerRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.farmerEntity.Farmer;

public interface FarmerRepository extends MongoRepository<Farmer, Integer>{

}
