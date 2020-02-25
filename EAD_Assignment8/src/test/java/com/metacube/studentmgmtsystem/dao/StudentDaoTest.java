package com.metacube.studentmgmtsystem.dao;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.metacube.studentmgmtsystem.model.Student;

/**
 * This is the test class used to test StudentDao class
 * @author Akanksha
 *
 */
class StudentDaoTest {

	private StudentDao studentDao=new StudentDao();
	Student student=new Student();
	@BeforeEach
	void setUp() throws Exception {
		student.setFirst_name("Riya");
		student.setLast_name("Gupta");
		student.setFather_name("Ramesh Gupta");
		student.setEmail("riya@gmail.com");
		student.setAge(13);
		student.setStd(10);
	}

	/**
	 * This method test the positive test case of addStudent method of StudentDao class
	 */
	@Test
	void testAddStudent() {
		boolean result=studentDao.addStudent(student);
		assertEquals(true, result);
	}
	
	
	/**
	 * This method test the negative test case of addStudent method of StudentDao class
	 */
	@Test
	void testAddStudent1() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Student student1=null; 
			boolean result=studentDao.addStudent(student1);
		  });
		
	}

	
	/**
	 * This method test the getAllStudents method of StudentDao class
	 */
	@Test
	void testGetAllStudents() {
		List<Student> resultList=studentDao.getAllStudents();
		assertEquals(true, (!resultList.isEmpty()));
		assertEquals(false, resultList.isEmpty());
		
	}

}
