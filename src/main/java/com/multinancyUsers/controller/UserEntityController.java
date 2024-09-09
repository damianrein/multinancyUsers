package com.multinancyUsers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multinancyUsers.model.UserEntity;
import com.multinancyUsers.service.UserEntityService;

@RestController
@RequestMapping("/v1")
public class UserEntityController {

	@Autowired
	private UserEntityService userService;

	public UserEntityController(UserEntityService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/")
	public ResponseEntity<?> userRegistry(@RequestBody UserEntity user){
		userService.registerUser(user);
		return ResponseEntity.created(null).build();
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserEntity>> findAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
}
