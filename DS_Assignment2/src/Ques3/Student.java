package Ques3;

/**
 * This is the POJO class of Student which is used for student name and list of programs preferred
 * @author Akanksha
 */
public class Student
{
	
	private String studentName;
	private String[] programPreferred;
	
	/**
	 * Constructor to initialize student
	 * @param name is name of student
	 * @param program is list of preferred programs
	 * @throws AssertionError if number of programs exceeds 5
	 */
	Student(String name, String[] program)
	{
		studentName = name;
		if(program.length>5)
		{
			throw new AssertionError("List of program should be 5");
		}
		else
		{
			programPreferred = program;
		}
	}

	public String getStudentName() {
		return studentName;
	}

	public String[] getProgramPreferred() {
		return programPreferred;
	}
	
}