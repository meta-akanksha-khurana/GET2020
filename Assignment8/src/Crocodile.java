
/**
 * This class represent the species "Crocodile" which extends Reptile class
 * @author Akanksha
 * 
 */
public class Crocodile extends Reptile
{
	/**
	 * 
	 * This is a parameterized constructor which set the instance variable age,weight 
	 * @param uniqueName String represent unique name for Crocodile that zoo keeper gives 
	 * @param age double type represent the age of the Crocodile in years
	 * @param weight double type represent the weight of the Crocodile in kg
	 */
	public Crocodile(String uniqueName,double age,double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight; 
		this.species = "Crocodile";
	}
	
	/**
	 * This method return the String representation of the sound of the Crocodile
	 */
	public String getSound()
	{
		return "Bellow"; 
	}
}