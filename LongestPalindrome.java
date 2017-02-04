package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("abcffCccfdd"));
	}

	public static int longestPalindrome(String s)
	{
		Map<Character,Integer> charMap = new HashMap<Character,Integer>();
		int length=0;
		char[] charArray = s.toCharArray();
		for(int i =0; i<charArray.length;i++)
		{
			if(charMap.get(charArray[i]) != null)
			{
				charMap.remove(charArray[i]);
				length+=2;
			}else
			{
				charMap.put(charArray[i], 1);
			}
		}
		if(length<s.length())
		{
			length+=1;
		}
		return length;
	}
}
