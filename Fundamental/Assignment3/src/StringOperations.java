import java.util.*;
/**
 * The class StringOperations consists of methods to perform various operations on string
 * @author Akanksha
 *
 */
public class StringOperations {
	
	/**
	 * compareStrings method is used to compare two strings
	 * @param str1
	 * @param str2
	 * @return 1 if strings are equal else 0
	 */
	public static int compareStrings(String str1,String str2)
	{
		int str1_length=str1.length();
		int str2_length=str2.length();
		
		if(str1_length==str2_length){
			for(int i=0;i<str1_length;i++){
				if(str1.charAt(i)==str2.charAt(i))
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
     * @param str
     * @return characterArray as reverse of string
     */
	public static char[] reverseString(String str)
	{
		int right=str.length()-1;
		int left;
		char characterArray[]=str.toCharArray();
		for(left=0;left<right;left++,right--){
			char temp=characterArray[left];
			characterArray[left]=characterArray[right];
			characterArray[right]=temp;
		}
		
		return characterArray;
	}
	
	/**
	 * changeCase method is used to change the case of letters i.e.
	 * if upper case then to lower case and 
	 * if lower case then to upper case
	 * @param str
	 * @return characterArray as changed string 
	 */
	public static char[] changeCase(String str)
	{
		int CONST=32;
		char characterArray[]=str.toCharArray();
		int length=str.length();
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
	 * @param str
	 * @return largestString as largest word of string
	 */
	public static String largestWord(String str)
	{
		int maxLength=0;
		String largestString="";
		String[] words=str.split(" ");
		for(int i=0;i<words.length;i++){
			if(words[i].length()>maxLength){
				maxLength=words[i].length();
				largestString=words[i];
			}
			else if(words[i].length()==maxLength){
				largestString=words[i];
			}
		}
		return largestString;
	}
	
	
	//main method
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		//String string1,string2;
		Boolean option=true;
		try{
		 while(option)
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
				int answer=StringOperations.compareStrings(string1, string2);
				if(answer==1){
					System.out.println("Both strings are equal!!");
				}
				else{
					System.out.println("String are not equal!!");
				}
				break;
				
			case 2:
				System.out.println("Reverse of string "+string1+" is ");
				System.out.println(StringOperations.reverseString(string1));
				break;
				
			case 3:
				System.out.println(StringOperations.changeCase(string1));
				break;
				
			case 4:
				System.out.println(StringOperations.largestWord(string1));
				break;
				
			case 5:
				System.exit(0);

				
			}
			System.out.println("Do you want to continue?(yes/no)");
			String ans=input.next();
			input.nextLine();
			if(ans.equalsIgnoreCase("yes"))
				option = true;
			else
				option=false;
		}
        input.close();
	 }
	  catch(Exception e)
		{
		  System.out.println("Exception occured!!");
		}
	}

}
