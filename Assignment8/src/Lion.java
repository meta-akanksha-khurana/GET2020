/**
 * This class is used to represent Species "Lion" which extends Mammal
 * @author Akanksha
 *
 */
public class Lion extends Mammal 
{	
	/** 
	 * This is a parameterized constructor which set the instance variable age,weight 
	 * @param uniqueName String represent unique name for Lion that zoo keeper gives 
	 * @param age in double format represents the age of the Lion in years
	 * @param weight in double format represent the weight of the Lion in kg
	 */
	Lion(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Lion";
	}
	
	/**
	 * This method return the String representation of the sound of the Lion
	 */
	public String getSound()
	{
		return "Roars";
	}
}