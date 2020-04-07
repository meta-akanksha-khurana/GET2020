package Ques2;


/**
 * This class sorts the employee by their salary
 * @author Akanksha
 *
 */
public class EmployeeList 
{
	
	Employee head = null;
	Employee sort = null;
	
	/**
	 * This method is used to add new Employee in list
	 * @param name is employee name.
	 * @param salary is employee salary.
	 * @param age is age of employee.
	 */
	void addEmployee(String name, long salary, int age)
	{
		Employee newEmp = new Employee(name, salary, age);

		if(head == null)
		{
			head = newEmp;
		}
		else{
			Employee employee = head;
			while(employee.next != null)
			{
				employee = employee.next;
			}
			employee.next = newEmp;
		}
	}
	
	/**
	 * This method is used to display the linked list
	 * @param head
	 */
	private void display(Employee head) 
	{
		Employee emp = head;
		while(emp != null)
		{
			System.out.println(emp.toString());
			emp = emp.next;
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
		sort = null;
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
		if(sort == null || compare(sort, employee))
		{
			employee.next = sort;
			sort = employee;
		}
		else
		{
			Employee current = sort;
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
		sort();
		display(sort);
	}
	
	//main method
	public static void main(String args[]) 
	{
		EmployeeList list = new EmployeeList();
		list.addEmployee("A", 200, 23);
		list.addEmployee("B", 475, 52);
		list.addEmployee("C", 350, 41);
		list.addEmployee("D", 200, 27);
		list.addEmployee("E", 600, 31);
		list.displayUnSortedList();
		System.out.println("Sorted List: ");
		list.displaySortedList();
	}

}
