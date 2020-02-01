
/**
 * This class is used to represent Species "Duck" which extends Bird
 * @author Akanksha
 *
 */
public class Duck extends Bird 
{	
	/**
	 * This is a parameterized constructor which set the instance variable age,weight of Animal Class
	 * @param uniqueName String represent unique name for Duck that zoo keeper gives 
	 * @param age double type represent the age of the Duck in years
	 * @param weight double type represent the weight of the Duck in kg
	 */
	Duck(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName; 
		this.weight = weight;
		this.species = "Duck";
	}
	
	/**
	 * 
	 * This method return the String representation of the sound of the Duck
	 */
	public String getSound()
	{
		return "Quack";
	}
}