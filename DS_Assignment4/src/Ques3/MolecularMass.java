package Ques3;

import java.util.HashMap;

/**
 * This class is used to calculate molecular mass of a compound
 * containing C,H and O
 * @author Akanksha
 *
 */
public class MolecularMass {

	private final static int CARBON_MASS=12;
	private final static int HYDROGEN_MASS=1;
	private final static int OXYGEN_MASS=16;
	
	HashMap <Character,Integer> elements=new HashMap<>();
	
	//Constructor
	public MolecularMass() {
		elements.put('C', 0);
		elements.put('H', 0);
		elements.put('O', 0);
	}
	
	/**
	 * This method is used to break compound and calculate number of
	 * C,H and O
	 * @param compound is input compound in string format
	 * @param value 
	 */
	public void calculateNumberOfElements(String compound,int value){
		int newValue=0;
		for(int i=0;i<compound.length();i++){
			char ch=compound.charAt(i);
	
			if(ch=='('){
				String subString="";
				while(compound.charAt(++i)!=')'){
					subString+=compound.charAt(i);
				}
				subString+=" ";
				if(Character.isDigit(compound.charAt(++i))){
					int value1=Character.getNumericValue(compound.charAt(i));
					calculateNumberOfElements(subString,value1);
				}
				else{
					calculateNumberOfElements(subString, value);
				}
			}
			
			else if(ch=='C'){
				newValue=elements.get('C');
				if(Character.isDigit(compound.charAt(i+1))){
					newValue+=Character.getNumericValue(compound.charAt(i+1))*value;
				}
				else{
					newValue+=1*value;
				}
				elements.replace('C', newValue);
			}
			
			else if(ch=='H'){
				newValue=elements.get('H');
				if(Character.isDigit(compound.charAt(i+1))){
					newValue+=Character.getNumericValue(compound.charAt(i+1))*value;
				}
				else{
					newValue+=1*value;
				}
				elements.replace('H', newValue);
			}
			
			else if(ch=='O'){
				newValue=elements.get('O');
				if(Character.isDigit(compound.charAt(i+1))){
					newValue+=Character.getNumericValue(compound.charAt(i+1))*value;
				}
				else{
					newValue+=1*value;
				}
				elements.replace('O', newValue);
			}
			
			
		}
	}
	
	/**
	 * This method is used to find molecular mass
	 * @param compound 
	 * @return calculated molecular mass
	 */
	public int findMolecularMass(String compound){
		calculateNumberOfElements(compound+" ", 1);
		int totalMassofC=elements.get('C')*CARBON_MASS;
		int totalMassofH=elements.get('H')*HYDROGEN_MASS;
		int totalMassofO=elements.get('O')*OXYGEN_MASS;
		
		int totalMass=totalMassofC+totalMassofH+totalMassofO;
		return (totalMass);
	}

}
