import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TestNQueenProblem is the test class to test the NQueenProblem main class
 * @author Akanksha
 *
 */
public class TestNQueenProblem {

	@Test
	public void test() {
		NQueenProblem nqueen=new NQueenProblem();
		Boolean result=nqueen.nQueen(new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},0,4);
		assertEquals(true,result);
		nqueen.print(4);
	}

}
