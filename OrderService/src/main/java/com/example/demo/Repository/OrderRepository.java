package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Entity.Order;

public interface OrderRepository extends MongoRepository<Order,Integer>{

}
