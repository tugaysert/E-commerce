package com.menorise.secondhand.user.dto;

import org.springframework.stereotype.Component;

import com.menorise.secondhand.user.model.User;

@Component
public class UserDtoConverter {
	
	public UserDto convert(User from) {
		return new UserDto(from.getMail(), from.getFirstName(), from.getLastName(), from.getMiddleName());
	}

}
