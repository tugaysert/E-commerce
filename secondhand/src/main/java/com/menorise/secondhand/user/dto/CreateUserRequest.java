package com.menorise.secondhand.user.dto;

import lombok.Data;

@Data
public class CreateUserRequest {

	private String mail;
	private String firstName;
	private String lastName;
	private String middleName;
}
