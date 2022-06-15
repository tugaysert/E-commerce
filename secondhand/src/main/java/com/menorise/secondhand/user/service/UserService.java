package com.menorise.secondhand.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.menorise.secondhand.user.dto.CreateUserRequest;
import com.menorise.secondhand.user.dto.UpdateUserRequest;
import com.menorise.secondhand.user.dto.UserDto;
import com.menorise.secondhand.user.dto.UserDtoConverter;
import com.menorise.secondhand.user.exception.UserNotFoundException;
import com.menorise.secondhand.user.model.User;
import com.menorise.secondhand.user.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final UserDtoConverter userDtoConverter;

	
	
	public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
		this.userRepository = userRepository;
		this.userDtoConverter = userDtoConverter;
	}



	public List<UserDto> getAllUsers(){
		return userRepository.findAll().stream()
				.map(x->userDtoConverter.convert(x)).collect(Collectors.toList());
		//.map(userDtoConverter::convert).collect(Collectors.toList());
	}
	
	public UserDto getUserById(Long id) {
		User user = findUserById(id);
		return userDtoConverter.convert(user);
	}



	public UserDto createUser(CreateUserRequest userRequest) {
		
		User user = new User();
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setMail(userRequest.getMail());
		user.setMiddleName(userRequest.getMiddleName());
		
		return userDtoConverter.convert(userRepository.save(user));
	}



	public UserDto updateUser(Long id, UpdateUserRequest updateUserRequest) {
		
		User user = findUserById(id);
		User updatedUser = new User(user.getId(),
									updateUserRequest.getMail(),
									updateUserRequest.getFirstName(),
									updateUserRequest.getLastName(),
									updateUserRequest.getMiddleName()							
				);
		
		return userDtoConverter.convert(userRepository.save(updatedUser));
	}
	
	private User findUserById(Long id) {
		
		return userRepository.findById(id).orElseThrow(() ->
		new UserNotFoundException("User couldn't be found by id: " +id));
	}

}
