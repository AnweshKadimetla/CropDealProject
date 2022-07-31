package com.example.demo.cropRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.cropEntity.Crop;

public interface CropRepository extends MongoRepository<Crop, Integer>{

}
