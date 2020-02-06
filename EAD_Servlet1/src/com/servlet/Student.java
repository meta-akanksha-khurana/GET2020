package com.servlet;

/**
 * Student is the POJO class containing attributes of student and getter and setter methods 
 * @author Akanksha
 *
 */
public class Student {

	private String firstName;
	private String lastName;
	private String fatherName;
	private String email;
	private int classOfStudent;
	private int age;
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getClassOfStudent() {
		return classOfStudent;
	}
	public void setClassOfStudent(int classOfStudent) {
		this.classOfStudent = classOfStudent;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
