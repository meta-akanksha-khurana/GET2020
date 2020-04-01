package Ques3;

/**
 * This is the POJO class of Program where program name and capacity is stored
 * @author Akanksha
 * 
 */
public class Program 
{
	private String programName;
	private int programCapacity;
	
	/**
	 * Constructor to initialize Program
	 * @param name is program name
	 * @param capacity is capacity of program
	 */
	Program(String name, int capacity)
	{
		programName = name;
		programCapacity = capacity;
	}

	public String getProgramName() {
		return programName;
	}

	public int getProgramCapacity() {
		return programCapacity;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public void setProgramCapacity(int programCapacity) {
		this.programCapacity = programCapacity;
	}

}
