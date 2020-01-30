import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class is used to test the Zone class
 * @author Akanksha
 *
 */
public class TestZone {

	/**
	 * This method is used to test the addCage method of Zone class
	 */
	@Test(expected=AssertionError.class)
	public void testAddCage() 
	{
		Zone zone=new Zone(1,"Mammals",true,true);
		Cage cage1=new Cage(3,"Lion");
		assertEquals(true,zone.addCage(cage1));
		
	    Cage cage2=new Cage(4,"Deer");
	    fail("New cage can't be added");
	}

	
	/**
	 * This method is used to test the addAnimalInZone method of Zone class
	 */
	@Test
	public void testaddAnimalInZone()
	{
		Zone zone=new Zone(1,"Mammals",true,true);
		Cage cage1=new Cage(3,"Lion");
		Animal animal=new Lion("Lion1",15,100);
		zone.addCage(cage1);
		assertEquals(true, zone.addAnimalInZone(animal));
	}
}
