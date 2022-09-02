package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.user.dto.AuthenticationRequest;
import com.user.dto.AuthenticationResponse;
import com.user.entity.User;

import com.user.service.MyUserDetailsService;
import com.user.service.UserService;
import com.user.util.JwtUtil;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));

	}
	

	@PostMapping("/save")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User newUser = userService.saveUser(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(newUser, HttpStatus.OK);
		return responseEntity;

	}
	
	//@HystrixCommand(fallbackMethod = "getPassenger")
	@GetMapping("/find/{pId}")
	public ResponseEntity<Object> getUser(@PathVariable("pId") int userId) {
		ResponseEntity<Object> responseEntity = null;
		User user = userService.getUser(userId);
		responseEntity = new ResponseEntity<Object>(user, HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/modify")
	public ResponseEntity<User> modifyUser(@RequestBody User user) {
		User modifiedUser=userService.modifyUser(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(modifiedUser, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("delete/{pId}")
	public ResponseEntity<String> removeUser(@PathVariable("pId") int userId) {

		userService.deleteUser(userId);
		return new ResponseEntity<>("Passenger Deleted Successfully.", HttpStatus.OK);
	}

}
