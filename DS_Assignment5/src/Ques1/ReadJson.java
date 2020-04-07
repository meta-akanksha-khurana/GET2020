package Ques1;

import java.io.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class is used to read initial JSON input pairs for dictionary
 * @author Akanksha
 */
public class ReadJson 
{
	
	private static Map<String,String> dictionaryMap = new LinkedHashMap<String, String>();

	public static Map<String, String> getDictionaryMap() 
	{
		return dictionaryMap;
	}
	
	/**
	 * To read JSON pairs from a json file.
	 */
	@SuppressWarnings("unchecked")
	public static void readJSON() 
	{
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("dictionary.json"))
		{
			Object obj = jsonParser.parse(reader);

			JSONArray list = (JSONArray) obj;
			//System.out.println(list);
 
			list.forEach( dict -> parseDictionaryObject( (JSONObject) dict ) );

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * To add each JSON object to HashMap
	 * @param dict
	 */
	private static void parseDictionaryObject(JSONObject dictionary) 
	{
		JSONObject dictionaryObject = (JSONObject) dictionary.get("pair");

		String key = dictionaryObject.get("key").toString();
		String value = dictionaryObject.get("value").toString();
		dictionaryMap.put(key, value);
	}
	
}