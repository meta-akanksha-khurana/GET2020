import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TestSearch is used to test Search main class
 * @author Akanksha
 *
 */
public class TestSearch {

	/**
	 * This method is used to test the linearSearch method of Search class
	 */
	@Test(expected=AssertionError.class)
	public void testLinearSearch() {
		
			Search linearSearchObject=new Search();
			int resultLinearSearch;
			resultLinearSearch=linearSearchObject.linearSearch(new int[]{2,6,1,7,3},6);
			assertEquals(2, resultLinearSearch);
			
			resultLinearSearch=linearSearchObject.linearSearch(new int[]{3,1,10,5,2},7);
			assertEquals(-1,resultLinearSearch);
			
			resultLinearSearch=linearSearchObject.linearSearch(new int[]{},5);
			
	}
	
	/**
	 * This method is used to test the binarySearch method of Search class
	 */
	@Test(expected=AssertionError.class)
	public void testBinarySearch(){
			Search binarySearchObject=new Search();
			int resultBinarySearch=binarySearchObject.binarySearch(new int[]{2,5,7,9,11},9);
			assertEquals(4, resultBinarySearch);
			
			resultBinarySearch=binarySearchObject.binarySearch(new int[]{3,1,10,5,2},7);
			assertEquals(-1,resultBinarySearch);
			
			resultBinarySearch=binarySearchObject.binarySearch(new int[]{},5);

	}	

}
