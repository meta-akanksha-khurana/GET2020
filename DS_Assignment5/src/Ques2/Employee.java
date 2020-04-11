package Ques2;

/**
 * This is the POJO class of Employee
 * @author Akanksha
 *
 */
public class Employee
{
	
	String name;
	long salary;
	int age;
	Employee next;
	
	Employee(String name, long salary, int age)
	{
		this.age = age;
		this.name = name;
		this.salary = salary;
		this.next = null;
	}
	
	public String toString() 
	{
		return "Employee [name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}
	
}
