package com.example.demo.admin.farmerrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.admin.farmerentity.FarmerEntity;

public interface FarmerRepos extends MongoRepository<FarmerEntity, Integer>{

}
