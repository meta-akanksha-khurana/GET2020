package com.metacube.studentmgmtsystem.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 * This is the pojo class containg the attributes of student and its getter & setter methods
 * @author Akanksha
 *
 */
public class Student {
	private int id;
	
	@NotBlank(message="{emptyField}")
	@Pattern(regexp = "^[a-zA-Z]{2,}$", message = "Please enter valid First Name")
	private String first_name;
	
	@NotBlank(message="{emptyField}")
	@Pattern(regexp = "^[a-zA-Z]{2,}$", message = "Please enter valid Last Name")
	private String last_name;
	
	@NotBlank(message="{emptyField}")
	@Pattern(regexp = "^[a-zA-Z]{2,}$", message = "Please enter valid Name")
	private String father_name;
	
	@NotBlank(message="{emptyField}")
	@Email(message="{badEmail}")
	private String email;
	
	
	@PositiveOrZero(message="Class cannot be negative")
	private int std;
	
	
	@PositiveOrZero(message="Age cannot be negative")
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
