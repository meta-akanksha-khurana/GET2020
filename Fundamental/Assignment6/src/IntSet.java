import java.util.*;
/**
 * IntSet is an immutable class used to perform operations on set of integers
 * in range of 1 to 1000
 * @author Akanksha
 *
 */
final public class IntSet {

	final private static int SIZE=1000;
	final static private int universalSet[]=new int [SIZE];
	final private int set[];
	
	static{
		for(int i=0;i<SIZE;i++){
			universalSet[i]=i+1;
		}
	} 
	
	/* Constructor to initialize the set */
	IntSet(int inputArray[])
	{ 
		int common=0;
		if(inputArray.length<=0){
			//System.out.println("Array is empty");
			throw new AssertionError(); 
		}
		for(int i=0;i<inputArray.length-1;i++){
			for(int j=i+1;j<inputArray.length;j++){
				if(inputArray[i]==inputArray[j]){
					throw new AssertionError();
				}
			}
		}
		set=inputArray;
	}
	
	/**
	 * This function checks if the passed value is the member of the set or not
	 * @param value .It is the parameter of integer type which is to be checked
	 * @return true if the passed value is member of the set otherwise false
	 */
	public Boolean isMember(int value)
	{
		for(int i=0;i<set.length;i++){
			if(set[i]==value){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * this function is used to calculate the size of the set
	 * @return the size of the set in integer
	 */
	public int size(){
		return set.length;
	}
	
	/**
	 * This function checks if the set passed as parameter is the subset of the set which called the function
	 * @param inputSet. It is the object of IntSet type which contains set 
	 * @return true if passed set is subset of the ste which called the function otherwise false
	 */
	public boolean isSubSet(IntSet inputSet)
	{
		    Boolean flag=false;
	     	for(int i=0;i<inputSet.size();i++){
	     		if(this.isMember(inputSet.set[i])){
	     			flag=true;
	     		}
	     		else{
	     			flag=false;
	     			break;
	     		}
	     	}
	     	
	     	if(flag){
	     		return true;
	     	}
	     	else{
	     		return false;
	     	}
	}
	
	
	/**
	 * This function is used to find the complement of the set
	 * @return array which represents the complement of the set
	 */
	public int[] getComplement()
	{
		boolean flag;
		int complementSize=universalSet.length-set.length;
		int complement[]=new int[complementSize];
		int index=0;
	    for(int i=0;i<universalSet.length;i++){
	    	flag=false;
	    	for(int j=0;j<set.length;j++){
	    		if(universalSet[i]!=set[j]){
	    			flag=true;
	    		}
	    		else{
	    			flag=false;
	    			break;
	    		}
	    	}
	    	if(flag){
    			complement[index]=universalSet[i];
    			index++;
	    	}
	    }
	    return complement;	     
	}
	
	
	/**
	 * This function does the union of two sets
	 * @param set1 is the object of IntSet class
	 * @param set2 is the object of IntSet class
	 * @return the array which is the union of two sets 
	 */
	public int[] union(IntSet set1,IntSet set2)
	{
		int countCommon=0;
		int index=0;
		for(int i=0;i<set1.set.length;i++){
			for(int j=0;j<set2.set.length;j++){
				if(set1.set[i]==set2.set[j]){
					countCommon++;
				}
			}
		}
		int unionSetLength=set1.size()+set2.size()-countCommon;
		int result[]=new int[unionSetLength];
		for(int i=0;i<set1.set.length;i++){
			result[index]=set1.set[i];
			index++;
		}
		
		for(int i=0;i<set2.set.length;i++){
			if(set1.isMember(set2.set[i]))
				continue;
			else{
				result[index]=set2.set[i];
				index++;
			}
		}
		return result; 
	}
	
	//main
	public static void main(String[] args) {

		IntSet set1=new IntSet(new int[]{1,9,2,7,8,4});
		// System.out.println(set1.isMember(8));
		// System.out.println(set1.size());
		//int complementResult[]=set1.getComplement();
		//for(int i:complementResult){
		// System.out.print(i+" ");
		//}
		IntSet set2=new IntSet(new int[]{2,7});
		/*int unionArray[]=set1.union(set1, set2);
		for(int e:unionArray){
			System.out.print(e+" ");
		}*/
		
		System.out.println(set1.isSubSet(set2));
	}

}
