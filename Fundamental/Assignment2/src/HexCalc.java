import java.lang.*;
import java.util.*;
/**
 * The interface Arithematic is used to support any base
 * This interface contains abstract methods add,subtract,multiply,divide 
 * which can be overwritten in class which implements it 
 * @author Akanksha
 *
 */
interface Arithemetic
{
	public String add(String s1,String s2);
	public String subtract(String s1,String s2);
	public String multiply(String s1,String s2);
	public String divide(String s1,String s2);
}

/**
 * The class HexCalc is used to perform operations on hexadecimal values
 * It implements Aithematic interface thereby inheriting the abstract methods of interface
 * @author Akanksha
 *
 */
public class HexCalc implements Arithemetic{
	
	/*
	 * This method is used to perform addition on hexadecimal values
	 * @param hexadecimal values in string format'
	 * @return sum of hexadecimal values in string format 
	 */
	public String add(String s1,String s2)  throws ArithmeticException 
	{
		int n1=Integer.parseInt(s1, 16);
		int n2=Integer.parseInt(s2, 16);
		int add_res=n1+n2;
		String result=Integer.toHexString(add_res);
		return result;
	}

	
	/*
	 * This method is used to perform subtraction on hexadecimal values
	 * @param hexadecimal values in string format'
	 * @return difference of hexadecimal values in string format 
	 */
	public String subtract(String s1,String s2) throws ArithmeticException
	{
		int n1=Integer.parseInt(s1, 16);
		int n2=Integer.parseInt(s2, 16);
		int sub_res;
		String result;
		if(n1>=n2){
			 sub_res=n1-n2;
			 result=Integer.toHexString(sub_res);
		}
		else{
			sub_res=n2-n1;
			result="-"+Integer.toHexString(sub_res);
		}
		
		return result;
	}
	
	
	/*
	 * This method is used to perform multiplication on hexadecimal values
	 * @param hexadecimal values in string format'
	 * @return multiplication result of hexadecimal values in string format 
	 */
	public String multiply(String s1,String s2) throws ArithmeticException
	{
		int n1=Integer.parseInt(s1, 16);
		int n2=Integer.parseInt(s2, 16);
		int mul_res=n1*n2;
		String result=Integer.toHexString(mul_res);
		return result;
	}
	
	
	/*
	 * This method is used to perform division on hexadecimal values
	 * @param hexadecimal values in string format'
	 * @return division result of hexadecimal values in string format 
	 */
	public String divide(String s1,String s2) throws ArithmeticException
	{
		int n1=Integer.parseInt(s1, 16);
		int n2=Integer.parseInt(s2, 16);
		int div_res=n1/n2;
		String result=Integer.toHexString(div_res);
		return result;
	}
	
	
	/*
	 * This method is used to check if hexadecimal strings are equal or not
	 * @param hexadecimal values in string format
	 * @return Boolean value i.e. true or false
	 */
	public Boolean checkEqualTo(String hex1,String hex2)
	{
		if(hex1.compareTo(hex2)==0)
			return true;
		else
			return false;
	}
	
	/*
	 * This method is used to check if first hexadecimal string is  greater than second hexadecimal string 
	 * @param hexadecimal values in string format
	 * @return Boolean value i.e. true or false
	 */
	public Boolean checkGreaterThan(String hex1,String hex2)
	{
		if(hex1.compareTo(hex2)>0)
			return true;
		else
			return false;
	}
	
	/*
	 * This method is used to check if first hexadecimal string is less than second hexadecimal string
	 * @param hexadecimal values in string format
	 * @return Boolean value i.e. true or false
	 */
	public Boolean checkLessThan(String hex1,String hex2)
	{
		if(hex1.compareTo(hex2)<0)
			return true;
		else
			return false;
	}
	
	/*
	 * This method is used to change hexadecimal value to decimal value
	 * @param hexadecimal value in string format
	 * @return converted decimal value
	 */
	public int hexadecimalToDecimal(String hexValue) throws Exception
	{
		int len=hexValue.length();
		int BASE=16;
		int ZERO_ASCII=48;
		int CHAR_ASCII_CAPITAL=55;
		int CHAR_ASCII_SMALL=87;
		int decimal_value=0;
		int power=0;
		
		for(int i=len-1;i>=0;i--)
		{
			if(hexValue.charAt(i)>='0' && hexValue.charAt(i)<='9')
			{
				decimal_value+=(hexValue.charAt(i)-ZERO_ASCII)*Math.pow(BASE, power);
				power++;
			}
			else if(hexValue.charAt(i)>='A' && hexValue.charAt(i)<='F')
			{
				decimal_value+=(hexValue.charAt(i)-CHAR_ASCII_CAPITAL)*Math.pow(BASE, power);
				power++;
			}
			else if(hexValue.charAt(i)>='a' && hexValue.charAt(i)<='f')
			{
				decimal_value+=(hexValue.charAt(i)-CHAR_ASCII_SMALL)*Math.pow(BASE, power);
				power++;
			}
			else
			{
				System.out.println("Invalid value!!");
				System.exit(0);
			}
		}
		return decimal_value;
	}
	
	/*
	 * This function is used to convert decimal value into hexadecimal value
	 * @param decimal value
	 * @return hexadecimal value in string format
	 */
	public StringBuilder decimalToHexadecimal(int decimalNumber) throws Exception
	{
		StringBuilder hexValue=new StringBuilder();
		int remainder;
		int BASE=16;
		int ZERO_ASCII=48;
		int CHAR_ASCII=55;
	    while(decimalNumber!=0)
	    {
	    	remainder=decimalNumber%BASE;
	    	decimalNumber=decimalNumber/BASE;
	    	if(remainder>=0 && remainder<=9){
	    		hexValue.append(((char)(remainder+ZERO_ASCII)));
	    	}
	    	else
	    	{
	    		hexValue.append(((char)(remainder+CHAR_ASCII)));
	    	}
	    	   
	    }
	    
	    hexValue.toString();
	    hexValue.reverse();
	    return hexValue;    
	}
	
	//main method
	public static void main(String[] args) {
		HexCalc c=new HexCalc();
		Scanner input=new Scanner(System.in);
		String hex1,hex2;
		hex1=hex2=null;
		Boolean option;
		Boolean answer;
		System.out.println("List of Operations can be performed on the hexadecimal strings");
		try{
		do
		{
			System.out.println("1. Add");
			System.out.println("2. Subtract");
			System.out.println("3. Multiply");
			System.out.println("4. Division");
			System.out.println("5. Check if both values are equal");
			System.out.println("6. Check if first value is greater than first value");
			System.out.println("7. Check if first value is less than second value");
			System.out.println("8. Decimal representation of Hexadecimal number");
			System.out.println("9. Hexadecimal representation of Decimal number");
			System.out.println("10. Exit");
			System.out.println("Enter your choice");
			int choice=input.nextInt();
			
			/*
			 * used condition choice<9 as option 9 does not need any hexadecimal value
			 */
			if(choice<8){
				System.out.println("Enter the hexadecimal strings:");
				hex1=input.next();   
				hex2=input.next();
			}
			
			switch(choice)
			{
			   case 1:
				   String sum=c.add(hex1,hex2);
				   System.out.println(sum);
				   break;
			   case 2:
				   String difference=c.subtract(hex1, hex2);
				   System.out.println(difference);
				   break;
			   case 3:
				   String muliplyResult=c.multiply(hex1, hex2);
				   System.out.println(muliplyResult);  
				   break;
			   case 4:
				   String divisionResult=c.divide(hex1, hex2);
				   System.out.println(divisionResult);   
				   break;
			   
			   case 5:
				   answer=c.checkEqualTo(hex1, hex2);
				   if(answer){
				    	 System.out.println(hex1+" and "+hex2+" are equal!!");
				   }
				   else{
				    	 System.out.println(hex1+" and "+hex2+" are not equal!!");
				   }
				   break;
			         
			   case 6:
				    answer=c.checkGreaterThan(hex1, hex2);
				    if(answer){
				    	  System.out.println(hex1+" is greater than "+hex2);
				    }
				    else{
				    	  System.out.println(hex1+" is not greater than "+hex2);
				    }
				    break;
				    
			   case 7:
				    answer=c.checkLessThan(hex1, hex2);
				    if(answer){
					      System.out.println(hex1+" is less than "+hex2);
				    }
				    else{
					      System.out.println(hex1+"is not greater than "+hex2);
				    }
				    break;
				    
			   case 8:
				    String hexString=input.next();
				    System.out.println(c.hexadecimalToDecimal(hexString));
				    break;
				    
			   case 9:
				    int decNumber=input.nextInt();
				    StringBuilder result=c.decimalToHexadecimal(decNumber);
				    System.out.println(result.toString());
				    break;
				      
			   case 10:
				    System.exit(0);
				    
			   default:
				   System.exit(0);
				      
			}
			
			System.out.println("Do you want to continue?(yes/no)");
			String ans=input.next();
			if(ans.equalsIgnoreCase("yes"))
				option=true;
			else
				option=false;
		}while(option);
	}
		
		catch(ArithmeticException ae)
		{
			System.out.println("Arithmetic Exception occured");
		}
		catch(Exception e)
		{
			System.out.println("Enter valid hexadecimal strings!!");
		}
		input.close();
	}

}
