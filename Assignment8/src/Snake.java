/**
 * This class represents Snake species of Reptile and extends Reptile class
 * @author Akanksha
 *
 */
public class Snake extends Reptile 
{	
	/**
	 * This is a parameterized constructor which set the instance variable age,weightof Animal class 
	 * @param uniqueName String represent unique name for Snake that zoo keeper gives 
	 * @param age in double format represent the age of the Snake in years
	 * @param weight in double format represent the weight of the Snake in kg
	 */
	Snake(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight; 
		this.species = "Snake";
	}
	
	/**
	 * This method return the String representation of the sound of the Snake
	 */
	public String getSound()
	{
		return "Hiss";
	}
}