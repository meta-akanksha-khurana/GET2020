import java.util.*;
/**
 * The class ArrOperation is used to perform various operation on array.
 * @author Akanksha
 *
 */
public class ArrOperation {

	/**
	 * The method countClumps is used to count the clumps in an array.
	 * Clump in an array is a series of 2 or more adjacent elements of the same value.
	 * @param array is input array
	 * @return numberOfClumps
	 * @throw AssertionError Exception
	 */
	int countClumps(int array[])
	{
		final int CONST_VALUE=-1;
		int numberOfClumps=0;
		int currentValue=CONST_VALUE;
		int length=array.length;
		if(length==0){
			throw new AssertionError();
		}
		for(int i=0;i<length-1;i++){
			if(array[i]==array[i+1] && currentValue!=array[i]){
				currentValue=array[i];
				numberOfClumps++;
			}
			else{
				if(currentValue!=array[i])
					currentValue=CONST_VALUE;
			}
		}
		return numberOfClumps ;
	}
	
	
	/**
	 * The method maxMirror is used to find the size of largest mirror section in an array.
	 * @param array is input array
	 * @return largest mirror section size i.e. maxSize
	 * @throw AssertionError Exception
	 */
	 int maxMirror(int array[])
	{
		int maxSize=0;
		int length=array.length;
		if(length==0){
			throw new AssertionError();
		}
		
		
		int matrix[][]=new int[length+1][length+1];
		for(int i=0;i<=length;i++){
			for(int j=0;j<=length;j++){
				if(i==0 || j==0){
					matrix[i][j]=0;
				}
				else if(array[i-1]==array[length-j]){
					matrix[i][j]=matrix[i-1][j-1]+1;
				}
				else{
					matrix[i][j]=0;
				}
				
				
				if(matrix[i][j]>maxSize){
					maxSize=matrix[i][j];
				}
			}
		}
		
		return maxSize;
	}
	
	
	/**
	 * The method fixXY is used to solve the FixXY problem.
	 * @param array is input array
	 * @param X
	 * @param Y
	 * @return rearranged array
	 * @throw AssertionError Exception
	 */
    int[] fixXY(int array[],int X,int Y)
	{
		int length=array.length;
		int countX=0;
		int countY=0;
		boolean adjacentFlag=false;
		
		for(int i=0;i<length;i++){
			if(array[i]==X){
				countX++;
			}
			else if(array[i]==Y){
				countY++;
			}
		}
		
	        //loop to check if two adjacent X values are there
		for(int i=0;i<length-1;i++){
			if(array[i]==X && array[i+1]==X){
				adjacentFlag=true;
				break;
			}
		}
		
		/* throw AssertionError if 
		 * Array is empty,there are unequal number of X and Y,two adjacent X values are there,X occurs at last index of array
		 */
		if((length==0) || (countX!=countY) || adjacentFlag==true || array[length-1]==X ){
			throw new AssertionError();
		}
		
		
		
		for(int i=0;i<length;i++){
			if(array[i]==X && array[i+1]==Y){
				continue;
			}
			else if(array[i]==X && array[i+1]!=Y){
				for(int j=0;j<length;j++){
					if(array[j]==Y){
						if(j>0 && array[j-1]==X){
						    continue;
					    }
					    else{
						    int temp=array[j];
						    array[j]=array[i+1];
						    array[i+1]=temp;
						    break;
					    }
				    }
				}
			}
			else{
				continue;
			}
		}
		
		return array;
	}
	
	/**
	 * The method spliArray is used to give the index where array can be split where left array and 
	 * right array's elements sum is equal.
	 * @param array is input array
	 * @return index at which array can be split
	 * @throw AssertionError Exception
	 */
	 int splitArray(int arr[])                               
	{
		int sumLeft,sumRight;
		int length=arr.length;
		int leftIndex=0;
		int rightIndex=length-1;
		sumLeft=sumRight=0;
		if(length==0){
			throw new AssertionError();
		}
		
		while(leftIndex<=rightIndex){
			if(leftIndex==rightIndex){
				sumLeft+=arr[leftIndex];
				break;
			}
			
			if((leftIndex==rightIndex-1) && (sumLeft==sumRight)){
				break;
			}
			
			sumLeft+=arr[leftIndex];
			sumRight+=arr[rightIndex];
			leftIndex++;
			rightIndex--;
		}
		
		if(sumLeft==sumRight){
			return leftIndex++;
		}
		else{
			return -1;
		}
	}
		 
}
