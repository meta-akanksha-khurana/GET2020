package com.metacube.metaparkingsystemv2.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * This is the DTO class used for login
 * @author Akanksha
 *
 */
public class EmployeeDto {

	@NotBlank(message = "Please enter email id")
	@Email(message = "Please enter valid email")
	private String emailId;

	@Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*_-]{8,}$", message = "Please enter valid password")
	private String password;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
