package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FrequencyChar {
	public String frequencySort(String s) {
		Map<Character,Integer> charCount = new HashMap<Character,Integer>();
		Map<Character,String> charMap = new HashMap<Character,String>();
		int len = s.length();
		for(int i = 0; i < len ; i++)
		{
			char cur = s.charAt(i);
			if(charCount.containsKey(cur))
			{
				charCount.put(cur,charCount.get(cur)+1);
				charMap.put(cur,charMap.get(cur)+String.valueOf(cur));
			}else
			{
				charCount.put(cur,1);
				charMap.put(cur,String.valueOf(cur));
			}
		}
		//List<String> final = new ArrayList<String>();
		TreeMap<Integer,String> finalMap = new TreeMap<Integer,String>();
		for(char e : charCount.keySet())
		{
			if(finalMap.containsKey(charCount.get(e)))
			{
				finalMap.put(charCount.get(e),finalMap.get(charCount.get(e))+charMap.get(e));
			}
			else
			{
				finalMap.put(charCount.get(e),charMap.get(e));
			}
		}
		String str="";
		for(int i : finalMap.keySet())
		{
			str+=finalMap.get(i);
		}
		return str;
	}
}
