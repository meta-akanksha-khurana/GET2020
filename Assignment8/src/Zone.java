

import java.util.*;
/**
 * This class zone represents Zones in Zoo
 * @author Akanksha
 *
 */
public class Zone 
{	
    
    public int zoneId;
    public int totalCagesCapacity;
    public int numberOfCagesPresent;
    public String categoryOfAnimalSupported;
    
    /**
     * HashMap contains all the cages that added to zone
     * here key the integer numberOfCagesPresent that at start is 0 and increases after each cage placed
     * value is the object of Cage Class containing all details of the cage
     */
    public Map<Integer,Cage> cageList = new HashMap<Integer,Cage>();
    public boolean hasCanteen;
    public boolean hasPark;
    
    /**
     * 
     * parameterized constructor creating object of the Zone with given parameters
     * @param totalCagesCapacity integer value total number of cages zone can have
     * @param categoryOfAnimalSupported String value category of animal supported by zone
     * @param hasCanteen boolean value true if zone has a canteen
     * @param hasPark boolean value true if zone has a park
     */
    Zone(int totalCagesCapacity, String categoryOfAnimalSupported, boolean hasCanteen,boolean hasPark)
    {
        this.totalCagesCapacity = totalCagesCapacity;
        this.categoryOfAnimalSupported = categoryOfAnimalSupported;
        this.hasCanteen = hasCanteen;
        this.hasPark = hasPark;
        this.numberOfCagesPresent=0;
    }
     
    /** 
     * This method add new cage to the zone
     * @param cage object of the Cage Class contain details about the cage
     * @return true if cage is added successfully else false
     */
    public boolean addCage(Cage cage)
    {
        if(this.totalCagesCapacity == this.numberOfCagesPresent)
        {
        	throw new AssertionError("New cage can't be added");
        }
        cage.cageId = ++this.numberOfCagesPresent;
        this.cageList.put(cage.cageId, cage);
        return true;
    }
    
    /**
     * 
     * This is the method add animal to zone
     * @param animal object of the Animal Class contain details about the animal 
     * @return true if the animal added successfully else false
     */
    public boolean addAnimalInZone(Animal animal)
    {
        for(Cage cage :this.cageList.values())
        {	
            if(cage.addAnimalInCage(animal))
            {
                return true;
            }		
        }
        return false;
    }
}