package com.metacube.studentmgmtsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.metacube.studentmgmtsystem.model.Student;

/**
 * This is the DAO class used to perform the database operations
 * @author Akanksha
 *
 */
@Repository
public class StudentDao {
	private static List<Student> studentsList = new ArrayList<Student>();
	private static int counter = 1;

	/**
	 * This is the function used to add student in the list
	 * @param newStudent is object of Student type
	 * @return true if student is added to list
	 * @throws if object of Student is not added to the list
	 */
	public boolean addStudent(Student newStudent) {
		if(newStudent!=null) {
			newStudent.setId(counter);
			studentsList.add(newStudent);
			counter++;
			return true;
		}
		else {
			throw new IllegalArgumentException();
		}
	}


	/**
	 * This function is used to get list of all students
	 * @return list of students
	 */
	public List<Student> getAllStudents() {
		return studentsList;
	}


}
