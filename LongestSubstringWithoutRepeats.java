package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeats {
	public int lengthOfLongestSubstring(String s)
	{
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int start = 0;
		int max=0;
		for(int i = 0; i<s.length(); i++)
		{
			char c = s.charAt(i);
			if(map.containsKey(c))
			{
				if(map.get(c) >= start)
				{
					start = map.get(c)+1;
				}
			}
			max = Math.max(max,i-start+1);

			// update or add freshly the character
			map.put(c,i);
			//max++;
		}
		return max;
	}
}
