
import java.util.HashMap;
import java.util.Map;

/**
 * This class represent Zoo and methods related to zoo management system
 * @author Akanksha
 *
 */
public class Zoo  
{
    
    HashMap<String, Animal> animalsInZoo = new HashMap<>();
    public int numberOfZones = 0;
    
    /**
     * This HashMap contain details about all zones that added to the zoo
     * here key is the integer key numberOfZones which start with 0 and increases as more zones are added
     * and value is the zone object
     * zone can't be removed once created
     */
    public  Map<Integer,Zone> zonesInZoo = new HashMap<Integer,Zone>();	
    
    /**
     * 
     * This static addZone method add new zone in the zoo
     * @param zone object of the Zone Class containing details about the zone that will be created
     * @return true if zone created successfully else return false
     */
    public boolean addZone(Zone zone)
    {
        zone.zoneId=++(this.numberOfZones);
        this.zonesInZoo.put(zone.zoneId, zone);
        return true;
    }
    
    /**
     * 
     * This method find suitable zone for the animal according to animal category and sub category
     * @param animal object of animal containing details about animal
     * @return object of Zone Class containing suitable zone for the given animal 
     * @throws AssertionError if no suitable zone found for the type of the animal
     */
    private  Zone findSupportedZoneForAnimal(Animal animal)
    {
        /**
         * checking every zone that is available in the zoo 
         */
        for(Zone zone : this.zonesInZoo.values()){
            if(zone.categoryOfAnimalSupported.equalsIgnoreCase(animal.category)){
                return zone;
            }
        }
        /**
         * if no suitable zone found
         */
        throw new AssertionError("Supported zone not found for given animal!!!");
    }
    
    /**
     * 
     * This method is adding new animal to the zoo
     * @param animal object of animal representing any animal and contain its details
     * @return true if the animal added successfully else false
     * @throws AssertionError if Same name animal already present in zoo
     */
    public boolean addAnimal(Animal animal)
    {	
        /**
         * checking if same name animal already present in zoo
         */
        if(this.animalsInZoo.containsKey(animal.uniqueName))
        {
            throw new AssertionError("Same name animal already present in zoo!!!");
        }
        
        /**
         * searching for the suitable zone for the given animal
         */
        Zone supportedZone =this.findSupportedZoneForAnimal(animal);
        boolean animalPlaced = supportedZone.addAnimalInZone(animal);
        if(animalPlaced)
        {
            animalsInZoo.put(animal.uniqueName, animal);
            return true; 
        }
        return false;
    }
    
    /**
     * This method is used to add new cage in the zoo
     * @param cage object of the Cage Class containing details about the cage that need to be added
     * @return true if cage added successfully else false
     */
    public boolean addCage(Zone zone, Cage cage)
    {	
        if(this.zonesInZoo.containsKey(zone.zoneId))
        {
            boolean cagePlaced = zone.addCage(cage);
            if(cagePlaced)
            { 
                return true; 
            }
        }	
        return false;
    }
    
    /**
     * 
     * This method is used to remove any animal from the zoo
     * @param animal object of the animal class containing details about the animal that needed to be removed
     * @return true if the animal removed successfully else false
     */
    public boolean removeAnimal(Animal animal)
    {
        /**
         * checking if animal present in the zoo
         */
        if(this.animalsInZoo.containsKey(animal.uniqueName))
        {
            /** 
             * finding zone of the animal
             */
            Zone zoneOfAnimal = this.findSupportedZoneForAnimal(animal);
            for(Cage cage : zoneOfAnimal.cageList.values())
            {
                if(cage.cageSpecies == animal.species)
                {
                    cage.removeAnimalFromCage(animal);
                }
            }
            this.animalsInZoo.remove(animal.uniqueName);	
            return true;
        }
        return false;
    }
}
