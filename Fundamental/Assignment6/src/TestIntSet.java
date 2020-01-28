import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TestIntSet class is used to test the IntSet class
 * @author Akanksha
 *
 */
public class TestIntSet {

	/**
	 * This method is used to test the isMember method of IntSet class
	 */
	@Test(expected=AssertionError.class)
	public void testisMember() 
	{
		IntSet set1=new IntSet(new int[]{2,6,1,7,9});
		boolean result=set1.isMember(6);
		assertEquals(true,result);
		
		result=set1.isMember(4); 
		assertEquals(false,result);
		
		IntSet set2=new IntSet(new int[]{});
		
		IntSet set3=new IntSet(new int[]{2,5,8,2,9});
	} 

	/**
	 * This method is used to test the size methos of IntSet class
	 */
	@Test(expected=AssertionError.class)
	public void testSize()
	{
		IntSet set1=new IntSet(new int[]{2,5,3,8,9});
		int length=set1.size();
		assertEquals(5, length);
		
        IntSet set2=new IntSet(new int[]{});
		
		IntSet set3=new IntSet(new int[]{2,5,8,2,9});
		
	}
	
	/**
	 * This method is used to test the isSubset method of IntSet class
	 */
	@Test(expected=AssertionError.class)
	public void testIsSubset()
	{
		IntSet set1=new IntSet(new int[]{1,9,2,7,8,4});
		IntSet set2=new IntSet(new int[]{2,3,7});
		IntSet set3=new IntSet(new int[]{2,8,4});
		boolean result=set1.isSubSet(set2);
		assertEquals(false,result);
		
		result=set1.isSubSet(set3);
		assertEquals(true,result);
		
        IntSet set4=new IntSet(new int[]{});
		
		IntSet set5=new IntSet(new int[]{2,5,8,2,9});	
	}
	
	
	/**
	 * This method is used to test the getComplement method of IntSet class
	 */
	@Test(expected=AssertionError.class)
	public void testGetComplement()
	{
		IntSet set1=new IntSet(new int[]{1,2,3,4,5,6,7});
		int result[]=set1.getComplement();
		int expected[]=new int[993];
		int value=8;
		for(int i=0;i<993;i++){
			expected[i]=value+i;
		}
		
		assertArrayEquals(expected, result);
		
        IntSet set2=new IntSet(new int[]{});
		
		IntSet set3=new IntSet(new int[]{2,5,8,2,9});
		
	}
	
	
	/**
	 * This method is used to test union method of IntSet class
	 */
	@Test(expected=AssertionError.class)
	public void testUnion()
	{
	    IntSet set1=new IntSet(new int[]{1,9,2,7,8,4});
	    IntSet set2=new IntSet(new int[]{10,20,30});
	    int result[]=set1.union(set1, set2);
	    assertArrayEquals(new int[]{1,9,2,7,8,4,10,20,30},result);
	    
	    IntSet set3=new IntSet(new int[]{1,9,2,7,8,4});
	    IntSet set4=new IntSet(new int[]{10,2,30});
	    result=set3.union(set3, set4);
	    assertArrayEquals(new int[]{1,9,2,7,8,4,10,30}, result);
	    
        IntSet set5=new IntSet(new int[]{});
		
		IntSet set6=new IntSet(new int[]{2,5,8,2,9});
	}
}
 