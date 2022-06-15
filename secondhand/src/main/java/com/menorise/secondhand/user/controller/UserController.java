package com.menorise.secondhand.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menorise.secondhand.user.dto.CreateUserRequest;
import com.menorise.secondhand.user.dto.UpdateUserRequest;
import com.menorise.secondhand.user.dto.UserDto;
import com.menorise.secondhand.user.model.User;
import com.menorise.secondhand.user.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest userRequest){
		return ResponseEntity.ok(userService.createUser(userRequest));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id,@RequestBody UpdateUserRequest updateUserRequest) {
		return ResponseEntity.ok(userService.updateUser(id, updateUserRequest));
	}
	
	/*@PatchMapping("/{id}")
	public ResponseEntity<Void> deactiveUser(@PathVariable("id") Long id) {
		userService.deactiveUser(id);
		return ResponseEntity.ok().build();
	}
 	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok().build();
	}*/
	

}
