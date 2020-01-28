import java.util.*;
/**
 * The class StringOperations consists of methods to perform various operations on string
 * @author Akanksha
 *
 */
public class StringOperations {
	
	static final int CONST=32;
	
	
	/**
	 * compareStrings method is used to compare two strings
	 * @param inputString1 is the first string entered by the user which is passed as parameter
	 * @param inputString2 is the second string entered by the user which is passsed as parameter
	 * @return 1 if strings are equal else 0
	 */
    int compareStrings(String inputString1,String inputString2)
	{
		int inputString1_length=inputString1.length();
		int inputString2_length=inputString2.length();
		
		if(inputString1_length==inputString2_length){
			for(int i=0;i<inputString1_length;i++){
				if(inputString1.charAt(i)==inputString2.charAt(i))
					continue;
				else
					return 0;
			}
			return 1;
		}
		else
			return 0;	
	}
	
    /**
     * reverseString method is used to reverse the string
     * @param inputString as input to reverse
     * @return reverse of the string
     */
	String reverseString(String inputString)
	{
		int length=inputString.length();
		String reverseOfString="";
		for(int i=length-1;i>=0;i--){
			reverseOfString+=inputString.charAt(i);
		}
		
		return reverseOfString;
	}
	
	/**
	 * changeCase method is used to change the case of letters i.e.
	 * if upper case then to lower case and 
	 * if lower case then to upper case
	 * @param inputString is the string entered by the user passed as parameter
	 * @return string having changed cases
	 */
	char[] changeCase(String inputString)
	{
		char characterArray[]=inputString.toCharArray();
		int length=inputString.length();
		for(int i=0;i<length;i++){
			if(characterArray[i]>='a' && characterArray[i]<='z')
				characterArray[i]=(char)(characterArray[i]-CONST);
			else if(characterArray[i]>='A' && characterArray[i]<='Z')
				characterArray[i]=(char)(characterArray[i]+CONST);
		}

		return characterArray;
	}
	
	/**
	 * largestWord is used to find the largest word of the string
	 * @param inputString is the string entered by the user passed as parameter
	 * @return largest word of string
	 */
	String largestWord(String inputString)
	{
		String maxWord = "";
		String word = "";
		for(int i=0 ; i<inputString.length() ; i++)
		{
			if(inputString.charAt(i)==' ' || i==inputString.length()-1)
			{
				if(i==inputString.length()-1)
					word += inputString.charAt(i);
				if(word.length()>=maxWord.length())
					maxWord = word;
				word = "";
			}
			else
				word += inputString.charAt(i);
		}
		return maxWord;
	}

	//main method
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String option="";
		StringOperations operations=new StringOperations();
		
		try{
		 do
		 {
			System.out.print("Enter first string:");
			String string1=input.nextLine();
			
			System.out.println("Select the operation to be performed on a string");
			System.out.println("1.Compare the string");
			System.out.println("2. Reverse the string");
			System.out.println("3. Change case of characters in the string");
			System.out.println("4. Largest word of the string");
			System.out.println("5. Exit");
			
			int choice=input.nextInt();
			
			switch(choice){
			case 1:
				System.out.println("Enter second string");
				String string2=input.next();
				int answer=operations.compareStrings(string1, string2);
				if(answer==1){
					System.out.println("Both strings are equal!!");
				}
				else{
					System.out.println("String are not equal!!");
				}
				break;
				
			case 2:
				System.out.println("Reverse of string "+string1+" is ");
				System.out.println(operations.reverseString(string1));
				break;
				
			case 3:
				System.out.println(operations.changeCase(string1));
				break;
				
			case 4:
				System.out.println(operations.largestWord(string1));
				break;
				
			case 5:
				System.exit(0);
				
			default:
				System.exit(0);
	
			}
			System.out.println("Do you want to continue?(yes/no)");
			option=input.next();
			input.nextLine();
			
		}while(option.equalsIgnoreCase("yes"));
        input.close();
	 }
	  catch(Exception e)
		{
		  System.out.println("Exception occured!!");
		}
	}

}
