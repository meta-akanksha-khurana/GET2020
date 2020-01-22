import java.util.*;
/**
 * Search class is used to implement methods to search an element in an array 
 * @author Akanksha
 *
 */
public class Search {

	private int index=0;
	private int lowIndex,highIndex,midIndex;
	private Boolean flag=true;
	
	/**
	 * linearSearch is used to search the element in an array using linear search
	 * Linear search is a method for finding a target value within an array.
	 * It sequentially checks each element of the array for the target value until a match is found or
	 * until all the elements have been searched.
	 * @param inputArray is the array in which element is to found
	 * @param element ,it is the value to be searched
	 * @return index at which element is found or return -1 if not found
	 */
	int linearSearch(int inputArray[],int element){
		int length=inputArray.length;
		if(length==0){
			throw new AssertionError();
		}
		else if(inputArray[index]==element){
			return ++index;
		}
		else if(index==(length-1)){
			return -1;
		}
		else{
			index++;
			
		}
		return linearSearch(inputArray, element);
	}
	
	/**
	 * binarySearch is used to search the element in an array using binary search
	 * Binary search is a method for finding a target value within an array.
	 * Binary search is a search algorithm that finds the position of a target value within a sorted array.
	 * Binary search compares the target value to the middle element of the array.
	 * If they are not equal, the half in which the target cannot lie is eliminated and the search continues on the remaining half,
	 * again taking the middle element to compare to the target value, and repeating this until the target value is found.
	 * @param inputArray is the array in which element is to found
	 * @param element ,it is the value to be searched
	 * @return index at which element is found or -1 if not found
	 */
	int binarySearch(int inputArray[],int element)
	{
		int length=inputArray.length;
		if(length==0){
			throw new AssertionError();
		}
		if(flag){
			lowIndex=0;
			highIndex=length-1;
		}
		flag=false;
		if(lowIndex <= highIndex){
			midIndex=(lowIndex+highIndex)/2;
			if(inputArray[midIndex]==element){
				return (midIndex+1);
			}
			else if(element<inputArray[midIndex]){
				highIndex=midIndex-1;
			}
			else if(element>inputArray[midIndex]){
				lowIndex=midIndex+1;
			}
		}
		else{
			return -1;
		}
		return binarySearch(inputArray, element);
	}
	
}
