package Ques2;


/**
 * This class sorts the employee by their salary
 * @author Akanksha
 *
 */
public class EmployeeList 
{
	
	Employee head = null;
	Employee sortPointer = null;
	
	/**
	 * This method is used to add new Employee in list
	 * @param name is employee name.
	 * @param salary is employee salary.
	 * @param age is age of employee.
	 */
	void addEmployee(String name, long salary, int age)
	{
		Employee newEmployee = new Employee(name, salary, age);

		if(head == null)
		{
			head = newEmployee;
		}
		else{
			Employee employee = head;
			while(employee.next != null)
			{
				employee = employee.next;
			}
			employee.next = newEmployee;
		}
	}
	
	/**
	 * This method is used to display the linked list
	 * @param head is header of list
	 * @throws AssertionError if list is empty
	 */
	private void display(Employee head) 
	{
		if(head==null){
			throw new AssertionError("List is empty");
		}
		else{
		Employee employee = head;
		while(employee != null)
		{
			System.out.println(employee.toString());
			employee = employee.next;
		}
		}
	}

	/**
	 * This method is used to display unsorted employee list
	 *  
	 */
	public void displayUnSortedList() 
	{
		display(head);
	}

	/**
	 *This method is used to sort the list of Employees
	 */
	public void sort()
	{
		sortPointer = null;
		Employee current = head;
		while(current != null)
		{
			Employee next = current.next;
			addToSortedList(current);
			current = next;
		}
	}
	
	/**
	 * This method is used to compare two employees
	 * @param employee1 is first employee
	 * @param employee2 is the second employee
	 * @return true or false
	 */
	private boolean compare(Employee employee1,Employee employee2)
	{
		if(employee1.salary < employee2.salary || (employee1.salary == employee2.salary && employee1.age > employee2.age))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * This method is used to add Employee to sorted List
	 * @param employee
	 */
	private void addToSortedList(Employee employee)
	{
		if(sortPointer == null || compare(sortPointer, employee))
		{
			employee.next = sortPointer;
			sortPointer = employee;
		}
		else
		{
			Employee current = sortPointer;
			while(current.next != null && compare(employee,current.next))
			{
				current = current.next;
			}

			employee.next = current.next;
			current.next = employee;
		}
	}

	/**
	 * This method is used to display sorted employee list 
	 */
	public void displaySortedList() 
	{
		if(this==null){
			throw new AssertionError("Empty list");
		}
		else{
		sort();
		display(sortPointer);
		}
	}

}
