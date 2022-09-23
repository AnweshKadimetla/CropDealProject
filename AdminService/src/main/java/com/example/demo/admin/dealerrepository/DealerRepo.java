package com.example.demo.admin.dealerrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.admin.dealerentity.DealerEntity;

public interface DealerRepo extends MongoRepository<DealerEntity, Integer> {

}
