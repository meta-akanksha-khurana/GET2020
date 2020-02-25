package com.metacube.studentmgmtsystem.service;

import java.util.List;

import com.metacube.studentmgmtsystem.model.Student;

/**
 * This is the interface containing methods to implement dao layer methods
 * @author Akanksha
 *
 */
public interface StudentService {
	
	boolean addStudent(Student newStudent);
	List<Student> getAllStudents();
}
