package Ques3;

/**
 * This is the POJO class of Employee
 * @author Akanksha
 *
 */
public class Employee 
{
	
	private String name;
	private long salary;
	private int age;
	private Employee next;
	
	Employee(String name, long salary, int age)
	{
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.next = null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Employee getNext() {
		return next;
	}

	public void setNext(Employee next) {
		this.next = next;
	}

	public String toString()
	{
		return "Employee [name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}
	
}