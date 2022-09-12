package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.CartEntity;

public interface CartRepository extends MongoRepository<CartEntity, Integer>{

}
