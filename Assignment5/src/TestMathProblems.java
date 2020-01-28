import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TestMathProblems is used to test the MathProblems class
 * @author Akanksha
 *
 */
public class TestMathProblems {

	/**
	 * testHcf function is used to test the hcf function of the MathProblems class
	 */
	@Test
	public void testHcf() {
		MathProblems problem1=new MathProblems();
		int resultHcf=problem1.hcf(20, 15);
		assertEquals(5,resultHcf);
		
		resultHcf=problem1.hcf(0, 3);
		assertEquals(3, resultHcf);
		
		resultHcf=problem1.hcf(8, 0);
		assertEquals(8, resultHcf);
	}
	
	/**
	 * These functions is used to test the lcm function of the MathProblems class
	 */
	@Test
	public void testLcm1() {
		MathProblems problem2=new MathProblems();
		int resultLcm=problem2.lcm(20, 15);
		assertEquals(60,resultLcm);
	}
	
	public void testLcm2(){
		MathProblems problem2=new MathProblems();
		int resultLcm=problem2.lcm(12, 12);
		assertEquals(12, resultLcm);
	}
	
	public void testLcm3(){
		MathProblems problem2=new MathProblems();
		int resultLcm=problem2.lcm(404, 96);
		assertEquals(9696, resultLcm);
	}
	

}
