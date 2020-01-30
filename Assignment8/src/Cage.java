
import java.util.HashMap;
/**
 * This class represents cage in the zoo
 * @author Akanksha
 *
 */
public class Cage 
{
    public int cageId;
    public int capacityOfCage;
    public String cageSpecies;
    public int totalAnimalInCage;
    
    /**
     * This HashMap store details about the animals stored in the cage
     * key is the unique name of the animal and value is the animal object
     */
    public HashMap<String,Animal> animalList = new HashMap<String,Animal>();
    
    /** 
     * parameterized constructor used to create object of Cage
     * @param capacityOfCage capacity of the cage to contain animal
     * @param cageSpecies species of animal in cage
     */
    public Cage(int capacityOfCage, String cageSpecies)
    {
        this.capacityOfCage = capacityOfCage;
        this.cageSpecies = cageSpecies;
        this.totalAnimalInCage = 0;
    }
    
    /**
     * This method is use to add animal to the cage
     * @param animal object of the animal class contain details about the animal
     * @return true if the animal is added else false 
     */
    public boolean addAnimalInCage(Animal animal)
    {	
        if(this.cageSpecies != animal.species || this.capacityOfCage == this.totalAnimalInCage){
            return false;
        }		
        this.animalList.put(animal.uniqueName, animal);
        this.totalAnimalInCage++;
        return true;
    }
    
    /**
     * 
     * This method is used to remove given animal from cage
     * @param animal object of animal class contain details of the animal to be removed
     * @return true if animal is removed else false
     */
    public void removeAnimalFromCage(Animal animal)
    {
        if(this.animalList.containsKey(animal.uniqueName)){	
            this.animalList.remove(animal.uniqueName);
            this.totalAnimalInCage--;
        }	
        else{
        	throw new IllegalArgumentException("Animal is not present in thr cage!!");
        }
    }
}
