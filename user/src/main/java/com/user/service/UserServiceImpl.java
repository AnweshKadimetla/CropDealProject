package com.user.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.exception.PhoneNumberAlreadyExistingException;
import com.user.exception.UserNameAlreadyExistingException;
import com.user.exception.UserNotFoundException;
import com.user.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	Logger logger=org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {
		Optional<User>optionalUser=userRepository.finByUserName(user.getName());
			logger.warn("adding user");
		
		if(optionalUser.isPresent()) {
			throw new UserNameAlreadyExistingException("Username already exists with name "+user.getName());
		}
		Optional<User> userByPhone = userRepository.findByPhone(user.getPhone());
		if (userByPhone.isPresent()) {
			throw new PhoneNumberAlreadyExistingException("Phone number already exists " + user.getPhone());
		}
		return userRepository.save(user);
	}

	@Override
	public User getUser(int userId) {
		Optional<User> optionalUser= userRepository.findById(userId);
		if(optionalUser.isPresent()) {
			logger.warn("This is an warning message for get user by Id");
		}
		if(optionalUser.isEmpty()) {
			throw new UserNotFoundException("User not found with Id: "+userId);
		}
		return optionalUser.get();
	}

	@Override
	public void deleteUser(int userId) {
		Optional<User> optionalUser=userRepository.findById(userId);
		if(optionalUser.isEmpty()) {
			logger.warn("This is an warning message for delete user by Id");
			logger.trace("user with this id");
			throw new UserNotFoundException("User not found with Id: "+userId);
		}
		userRepository.deleteById(userId);		
	}

	@Override
	public User modifyUser(User user) {
		Optional<User> optionalUser= userRepository.findById(user.getUserId());
		if(optionalUser.isEmpty()) {
			throw new UserNotFoundException("User not found with Id: "+user.getUserId());
		}
		return userRepository.save(user);
	}

}
