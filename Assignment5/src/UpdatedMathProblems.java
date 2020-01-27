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

	
	
	
	/**
	 * lcm function is used to find lcm of two numbers
	 * @param number1 in integer format.Assume number1 > 0
	 * @param number2 in integer format.Assume number2 > 0
	 * @return LCM of number1 and number2
	 */
	int lcm(int number1,int number2)
	{		
		if(number1>number2){
			return lcmHelper(number1, number2, number1);
		}
		else{
			return lcmHelper(number1, number2, number2);
		}
	}
	
	
	/**
	 * lcmhelper is the private helper method used in lcm method
	 * @param number1 in integer format.Assume number1 > 0
	 * @param number2 in integer format.Assume number1 > 0
	 * @param tempNumber in integer format is temporary number used to do calculate lcm
	 * @param tempNumber in integer format.Assume number1 > 0
	 * @return lcm of number1 and number2 using tempNumber
	 */
	private int lcmHelper(int number1,int number2,int tempNumber)
	{
		if(number2>number1){
			if(tempNumber%number1==0)
				return tempNumber;
			else{
				return lcmHelper(number1, number2, tempNumber+number2);
			}
		}
		else{
			if(tempNumber%number2==0){
				return tempNumber;
			}
			else{
				return lcmHelper(number1, number2, tempNumber+number1);
			}
		}
	}

}
