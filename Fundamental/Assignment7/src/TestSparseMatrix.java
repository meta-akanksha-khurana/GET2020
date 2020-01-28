import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class is used to test the Sparsematrix class
 * @author Akanksha
 *
 */
public class TestSparseMatrix {

	/**
	 * This method is used to check the transpose method of SparseMatrix class
	 */
	@Test(expected=AssertionError.class)
	public void testTranspose() {
		int matrix1[][]=new int[][]{{0,5,0,6},
				{2,0,4,0},
				{0,0,7,0},
				{0,0,0,0}};
		SparseMatrix sparse_matrix1=new SparseMatrix(matrix1);
		int resultTranspose[][]=sparse_matrix1.transpose();
		int expectedTranspose[][]=new int[][]{{0,1,2},{1,0,5},{2,1,4},{2,2,7},{3,0,6}};
		assertArrayEquals(expectedTranspose, resultTranspose);
		
		/* Negative test case: matrix is empty */
		int matrix2[][]=new int[][]{};
		SparseMatrix sparse_matrix2=new SparseMatrix(matrix2);
	}
	
	
	/**
	 * This method is used to check the add method of SparseMatrix class
	 */
	@Test(expected=AssertionError.class)
	public void testAdd(){
		int matrix1[][]=new int[][]{{0,5,0,6},
				{2,0,4,0},
				{0,0,7,0},
				{0,0,0,0}};
		int matrix2[][]=new int[][]{{0,0,7,6},
				{2,0,4,0},
				{0,1,7,0},
				{1,0,0,0}};
		SparseMatrix sparse_matrix1=new SparseMatrix(matrix1);
		SparseMatrix sparse_matrix2=new SparseMatrix(matrix2);
		
		int addResult[][]=sparse_matrix1.add(sparse_matrix2);
		int expectedResult[][]=new int[][]{{0,1,5},{0,2,7},{0,3,12},{1,0,4},{1,2,8},{2,1,1},{2,2,14}};
		assertArrayEquals(expectedResult, addResult);
		
		
		/* Negative test case:Number of rows are not equal */
		int matrix3[][]=new int[][]{{1,0,0},{0,2,7},{8,0,0}};
		SparseMatrix sparse_matrix3=new SparseMatrix(matrix3);
		addResult=sparse_matrix1.add(sparse_matrix3);
		
		/* Negative test case:Number of columns are not equal */
		int matrix4[][]=new int[][]{{1,0},{0,2},{8,0},{0,0}};
		SparseMatrix sparse_matrix4=new SparseMatrix(matrix4);
		addResult=sparse_matrix1.add(sparse_matrix4);	
	}
	
	
	/**
	 * This method is used to check the multiply method of SparseMatrix class
	 */
	@Test(expected=AssertionError.class)
	public void testMultiply(){
		int matrix1[][]=new int[][]{{0,5,0,6},
				{2,0,4,0},
				{0,0,7,0},
				{0,0,0,0}};
		int matrix2[][]=new int[][]{{0,0,7,6},
				{2,0,4,0},
				{0,1,7,0},
				{1,0,0,0}};
		SparseMatrix sparse_matrix1=new SparseMatrix(matrix1);
		SparseMatrix sparse_matrix2=new SparseMatrix(matrix2);
		
		int multiplyResult[][]=sparse_matrix1.multiply(sparse_matrix2);
		
		int expecetdResult[][]=new int[][]{{16,0,20,0},{0,4,42,12},{0,7,49,0},{0,0,0,0}};
		assertArrayEquals(expecetdResult, multiplyResult);
		
		/* Negative test case:number of columns in matrix3 not equal to number of rows in matrix4  */
		int matrix3[][]=new int[][]{{0,5,0,6},
				{2,0,4,0},
				{0,0,7,0},
				{0,0,0,0}};
		int matrix4[][]=new int[][]{{0,0,7,6},
				{2,0,4,0},
				{0,1,7,0}};
		SparseMatrix sparse_matrix3=new SparseMatrix(matrix3);
		SparseMatrix sparse_matrix4=new SparseMatrix(matrix4);
		
		multiplyResult=sparse_matrix2.multiply(sparse_matrix4);
		
	}
	
	/**
	 * This method is used to check the checkSymmetric method of SparseMatrix class
	 */
	@Test(expected=AssertionError.class)
	public void testSymmetric(){
		int matrix1[][]=new int[][]{{5,2,0,0},{2,0,0,0},{0,0,2,0},{0,0,0,0}};
		SparseMatrix sparse_matrix1=new SparseMatrix(matrix1);
		boolean result=sparse_matrix1.checkSymmetric();
		assertEquals(true, result);
		
		
		int matrix2[][]=new int[][]{{1,2,0},{0,7,0},{4,0,0}};
		SparseMatrix sparse_matrix2=new SparseMatrix(matrix2);
		result=sparse_matrix2.checkSymmetric();
		assertEquals(false, result);
		
		/* Negative test case: not a square matrix  */
		int matrix3[][]=new int[][]{{5,2,0,0},{2,0,0,0},{0,0,2,0}};
		SparseMatrix sparse_matrix3=new SparseMatrix(matrix3);
		result=sparse_matrix3.checkSymmetric();
	}

}
