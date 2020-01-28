/**
 * MathProblems class is used to implement math problems
 * @author Akanksha
 *
 */
public class MathProblems {
	
	/**
	 * hcf function is used to find hcf of two numbers
	 * @param number1 in integer format.Assume number1 > 0
	 * @param number2 in integer format.Assume number2 > 0
	 * @return HCF of number1 and number2
	 */
	int hcf(int number1,int number2)
	{
		if(number1==0){
			return number2;
		}
		else if(number2==0){
			return number1;
		}
		else{
			if(number1>number2){
				return hcf(number2,number1%number2);
			}
			else{
				return hcf(number1,number2%number1);
			}
		}
	}

	int lcmResult=0;
	
	/**
	 * lcm function is used to find lcm of two numbers
	 * @param number1 in integer format.Assume number1 > 0
	 * @param number2 in integer format.Assume number2 > 0
	 * @return LCM of number1 and number2
	 */
	int lcm(int number1,int number2)
	{
		lcmResult+=number2;
		if(lcmResult%number1==0 && lcmResult%number2==0){
			return lcmResult;
		}
		else{
			return lcm(number1,number2);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathProblems obj=new MathProblems();
		System.out.println(obj.lcm(404,96));

	}

}
