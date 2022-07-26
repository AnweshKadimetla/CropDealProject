package com.user.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.user.entity.User;

public interface UserRepository extends MongoRepository<User, Integer>{

	@Query("{name:?0}")
	Optional<User> finByUserName(String name);

	@Query("{phone:?0}")
	Optional<User> findByPhone(long phone);

}
