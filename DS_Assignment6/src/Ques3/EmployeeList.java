package Ques3;



/**
 * This class sorts the employee by their salary
 * @author Akanksha
 *
 */
public class EmployeeList
{

	Employee head = null;
	//Employee sortedList = null;

	/**
	 * To add new Employee in list
	 * @param name 
	 * @param salary 
	 * @param age 
	 */
	public void addEmployee(String name, long salary, int age)
	{
		Employee newEmployee = new Employee(name, salary, age);

		if(head == null)
		{
			head = newEmployee;
		}
		else
		{
			Employee employee = head;
			while(employee.getNext() != null)
			{
				employee = employee.getNext();
			}
			employee.setNext(newEmployee);
		}
	}


	/**
	 * This method is used to display the linked list
	 * @param head is header of list
	 * @throws AssertionError if list is empty
	 */
	private void displayList() 
	{
		if(head==null){
			throw new AssertionError("List is empty");
		}
		else{
			Employee employee = head;
			while(employee != null)
			{
				System.out.println(employee.toString());
				employee = employee.getNext();
			}
		}
	}

	/**
	 * This method is used to partition list on basis of pivot point
	 * @param start is header of list
	 * @param end is last node of list
	 * @return pivot
	 */
	private Employee partitionLast(Employee start, Employee end) 
	{ 
		if(start == end || start == null || end == null){ 
			return start; 
		}

		Employee pivot_prev = start; 
		Employee current = start;  
		Employee pivot = end;  

		while(start != end ) 
		{ 
			if(start.getSalary() > pivot.getSalary()) 
			{  
				pivot_prev = current;  
				long tempSal = current.getSalary();  
				current.setSalary(start.getSalary());  
				start.setSalary(tempSal);

				String tempName = current.getName();
				current.setName(start.getName());
				start.setName(tempName);

				int tempAge = current.getAge();
				current.setAge(start.getAge());
				start.setAge(tempAge);
				current = current.getNext();  
			}
			else if(start.getSalary() == pivot.getSalary() && start.getAge() < pivot.getAge()) 
			{    
				long tempSal = pivot.getSalary();  
				pivot.setSalary(start.getSalary());  
				start.setSalary(tempSal);

				String tempName = pivot.getName();
				pivot.setName(start.getName());
				start.setName(tempName);

				int tempAge = pivot.getAge();
				pivot.setAge(start.getAge());
				start.setAge(tempAge);  
			}

			start = start.getNext();  
		} 
		long tempSal = current.getSalary();  
		current.setSalary(pivot.getSalary());  
		end.setSalary(tempSal); 

		String tempName = current.getName();
		current.setName(end.getName());
		end.setName(tempName);

		int tempAge = current.getAge();
		current.setAge(end.getAge());
		end.setAge(tempAge);

		current = current.getNext();
		return pivot_prev; 
	} 

	/**
	 * This method is used to sort the employee list in descending order.
	 * @param start is header of list
	 * @param end is last index of list
	 */
	void quickSort(Employee start, Employee end) 
	{ 
		if(start == end ) 
			return; 

		Employee pivot_prev = partitionLast(start, end); 
		quickSort(start, pivot_prev); 

		if( pivot_prev != null && pivot_prev == start ) 
			quickSort(pivot_prev.getNext(), end); 
		else if(pivot_prev != null && pivot_prev.getNext() != null) 
			quickSort(pivot_prev.getNext().getNext(), end); 
	}

	/**
	 * This method is used to get the last node in employee list
	 * @return last node of employee list.
	 */
	private  Employee getLastElement()
	{
		Employee employee = head;
		while(employee.getNext()!=null)
		{
			employee = employee.getNext();
		}
		return employee;
	}

	/**
	 * This method is used to sort employee list in descending order of their salary
	 * if two employees have same salary then smaller age employee comes first
	 */
	public void sortList()
	{
		if(this==null){
			throw new NullPointerException("List is empty");
		}
		else{
			quickSort(head, getLastElement());
		}
	}

	public static void main(String[] args)
	{
		EmployeeList list = new EmployeeList();
		list.addEmployee("A", 200, 23);
		list.addEmployee("B", 475, 52);
		list.addEmployee("C", 350, 41);
		list.addEmployee("D", 200, 27);
		list.addEmployee("E", 600, 31);
		list.displayList();
		list.sortList();
		System.out.println("Sorted List: ");
		list.displayList();
	}

}
