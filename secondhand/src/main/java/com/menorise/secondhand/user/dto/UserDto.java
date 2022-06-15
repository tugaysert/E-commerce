package com.menorise.secondhand.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
	private String mail;
	private String firstName;
	private String lastName;
	private String middleName;
}
