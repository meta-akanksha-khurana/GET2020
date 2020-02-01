
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to test the Zoo class
 * @author Akanksha
 *
 */
public class TestZoo 
{
    /**
     * This test method is used to test the addAnimal method of Zoo class
     */
    @Test (expected = AssertionError.class)
    public void testAddAnimal() 
    {
    	Zoo zoo=new Zoo();
        Animal animalInstance1 = new Lion("Lion1", 22, 1000);
        Animal animalInstance2 = new Lion("Lion1", 22, 1000);
        Animal animalInstance3 = new Peacock("Peacock1", 22, 1000);
        assertEquals(true, zoo.addAnimal(animalInstance1));
        assertEquals(false, zoo.addAnimal(animalInstance2));
        assertEquals(false, zoo.addAnimal(animalInstance3)); 
        fail("Same name animal already present in zoo!!!");
        fail("Supported zone not found for given animal!!!");
    }
    
    
    /**
     * This test method is used to test the positive case of removeAnimal method of Zoo class
     */
    @Test 
    public void testRemoveAnimal()
    {
    	Zoo zoo=new Zoo();
    	Zone addNewZoneInstance = new Zone(15, "Mammal", true, true);
    	zoo.addZone(addNewZoneInstance);
    	Cage addnewCageInstance = new Cage(4, "Lion");
    	assertEquals(true, zoo.addCage(addNewZoneInstance, addnewCageInstance));
    	Animal animalInstance1 = new Lion("Lion1", 22, 1000);
    	assertEquals(true, zoo.addAnimal(animalInstance1));
    	assertEquals(true, zoo.removeAnimal(animalInstance1));
    	
    }
    
    
    /**
     * This test method is used to test the negative case of addAnimal method of Zoo class
     */
    @Test(expected=AssertionError.class)
    public void testRemovalAnimal1()
    {
    	Zoo zoo=new Zoo();
    	Animal animalInstance = new Peacock("Peacock1", 22, 1000);
    	assertEquals(false, zoo.addAnimal(animalInstance));
    	assertEquals(false, zoo.removeAnimal(animalInstance));
    	fail("Supported zone not found for given animal!!!");
    	
    }
    
   
    /**
	 * This function is used to test the addZone method of Zoo class
	 */
    @Test
    public void testAddZone()
    {
    	Zoo zoo=new Zoo();
        Zone addNewZoneInstance1 = new Zone(10, "Reptile", true, true); 
        Zone addNewZoneInstance2 = new Zone(15, "Mammal", true, true); 
        Zone addNewZoneInstance3 = new Zone(1, "Reptile", true, true); 
        
        assertEquals(true,zoo.addZone(addNewZoneInstance1));
        assertEquals(true,zoo.addZone(addNewZoneInstance2));
        assertEquals(true, zoo.addZone(addNewZoneInstance3));
    	
    }
    
    /**
	 * This function is used to test the addCage method of Zoo class
	 */
    @Test
    public void testAddCage()
    {
    	Zoo zoo=new Zoo();
        Zone addNewZoneInstance1 = new Zone(2, "Reptile", true, true); 
        Zone addNewZoneInstance2 = new Zone(1, "Mammal", true, true);
        Cage addnewCageInstance1 = new Cage(4, "Lion");
        Cage addnewCageInstance2 = new Cage(2, "Snake");
        boolean result=zoo.addZone(addNewZoneInstance2);
        assertEquals(true, zoo.addCage(addNewZoneInstance2, addnewCageInstance1));
        assertEquals(false, zoo.addCage(addNewZoneInstance1, addnewCageInstance2));    
    }
    
}
