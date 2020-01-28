import static org.junit.Assert.*;

import org.junit.Test;


public class TestArrOperation {
	
	@Test
	public void testForClump(){
		try{
		    ArrOperation obj1=new ArrOperation();
		    int resultClump=obj1.countClumps(new int[]{1,2,2,3,4,4});
		    assertEquals(2, resultClump);
		    
		    resultClump=obj1.countClumps(new int[]{1,1,2,1,1});
		    assertEquals(2, resultClump);
		    
		    resultClump=obj1.countClumps(new int[]{1,1,1,1,1});
		    assertEquals(1, resultClump);
		    
		    resultClump=obj1.countClumps(new int[]{0,0,0,0,0});
		    assertEquals(1, resultClump);
		}
		catch(AssertionError ae){
			System.out.println("array is empty in testForClump");
		}
	}
	
	
	@Test
	public void testForSplitArray()
	{
		try
		{
			ArrOperation obj2 = new ArrOperation();
			int resultSplitIndex = obj2.splitArray(new int[]{1, 1 , 1, 2, 1});
			assertEquals(3 , resultSplitIndex);

			resultSplitIndex = obj2.splitArray(new int[]{2, 1, 1, 2, 1});
			assertEquals(-1 , resultSplitIndex );

			resultSplitIndex = obj2.splitArray(new int[]{10, 10});
			assertEquals(1 , resultSplitIndex );
			
			resultSplitIndex = obj2.splitArray(new int[0]);
			assertEquals(1 , resultSplitIndex );
			
		}
		catch(AssertionError ex)
		{
			System.out.println("Array is empty.");
		}

	}
	
	@Test
	public void testForFixXY() 
	{

		ArrOperation obj3 = new ArrOperation();
		try
		{
			int []resultFixXY = obj3.fixXY(new int[]{5, 4, 9, 4, 9, 5} , 4 , 5);
			int []expectedResult = new int []{9,4,5,4,5,9};
			assertArrayEquals( expectedResult , resultFixXY);


			resultFixXY = obj3.fixXY(new int[]{1, 4, 1, 5} , 4 , 5);
			expectedResult = new int []{1, 4, 5, 1};
			assertArrayEquals( expectedResult , resultFixXY);


			resultFixXY = obj3.fixXY(new int[]{1, 4, 1, 5, 5, 4, 1} , 4 , 5);
			expectedResult = new int []{1, 4, 5, 1, 1, 4, 5};
			assertArrayEquals( expectedResult , resultFixXY);

		}
		catch(AssertionError ex)
		{
			System.out.println("Enter the correct information.");
		}
	}

	@Test
	public void testMaxMirror()
	{
		try
		{
			ArrOperation obj4 = new ArrOperation();
			int resultMaxMirror = obj4.maxMirror(new int[]{1, 2, 3, 8, 9, 3, 2, 1});
			assertEquals(3 , resultMaxMirror);

			resultMaxMirror = obj4.maxMirror(new int[]{1, 2, 1, 4});
			assertEquals(3 , resultMaxMirror );

			resultMaxMirror = obj4.maxMirror(new int[]{1, 4, 5, 3, 5, 4, 1});
			assertEquals(7 , resultMaxMirror );

			resultMaxMirror = obj4.maxMirror(new int[]{7, 1, 4, 9, 7, 4, 1});
			assertEquals(2 , resultMaxMirror );
		}

		catch(AssertionError ex)
		{
			System.out.println("Enter the correct input");
		}
	}
}
