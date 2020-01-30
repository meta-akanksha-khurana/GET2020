import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class is used to test the Cage class
 * @author Akanksha
 *
 */
public class TestCage {

	/**
	 * This method is used to test the addAnimalInCage method of Cage class
	 */
	@Test
	public void testAddAnimalInCage() 
	{
		Cage cage=new Cage(4,"Lion");
		Animal animal1 = new Lion("Lion1", 22, 1000);
		assertEquals(true,cage.addAnimalInCage(animal1));
		
		Animal animal2 = new Snake("Snake1", 22, 1000);
		assertEquals(false,cage.addAnimalInCage(animal2));
		
	}
	
	
	/**
	 * This method is used to test the removeAnimalFromCage method of Cage class
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testRemoveAnimalFromCage()
	{
		Cage cage=new Cage(4,"Lion");
		Animal animal1 = new Lion("Lion1", 22, 1000);
		Animal animal2 = new Snake("Snake1", 22, 1000);
		cage.addAnimalInCage(animal1);
		cage.removeAnimalFromCage(animal1);
		
		cage.removeAnimalFromCage(animal2);
		fail("Animal is not present in thr cage!!");
		
		
		
	}

}
