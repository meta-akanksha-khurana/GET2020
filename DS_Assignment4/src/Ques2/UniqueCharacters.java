package Ques2;

import java.util.*;

/**
 * This class is used to find unique characters in string
 * @author Akanksha
 *
 */
public class UniqueCharacters {

	/**
	 * cache is the map use to cache the string once operated for reuse
	 */
	private Map<String, Integer> cache = new HashMap<String, Integer>();

	/**
	 * This method is used to count unique characters in string
	 * @param string is input string
	 * @return number of unique characters
	 * @throws NullPointerException if input string is null or empty
	 */
	public int countUniqueCharacters(String string) {

		if(string==null || string.length()==0){
			throw new NullPointerException("string is empty");
		}
		else{
			Map<Character, Integer> countCharacters = new HashMap<Character, Integer>();
			int numOfUniqueCharacters=0;

			if (cache.containsKey(string)) {
				System.out.println("From cache :");
				return cache.get(string);
			}

			for (int i = 0; i < string.length(); i++) {
				if (countCharacters.containsKey(string.charAt(i))) {
					countCharacters.replace(string.charAt(i),
							countCharacters.get(string.charAt(i)) + 1);
				} else {
					countCharacters.put(string.charAt(i), 1);
				}
			}
			if (countCharacters.containsKey(' ')){
				countCharacters.remove(' ');
			}

			for(Character ch:countCharacters.keySet()){
				if(countCharacters.get(ch)==1){
					numOfUniqueCharacters++;
				}
			}

			cache.put(string, numOfUniqueCharacters);
			System.out.println("Counted");
			return numOfUniqueCharacters;
		}
	}
}
