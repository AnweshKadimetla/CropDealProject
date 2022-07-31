package com.example.demo.adminRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.adminEntity.Admin;

public interface AdminRepository extends MongoRepository<Admin, Integer>{

}
