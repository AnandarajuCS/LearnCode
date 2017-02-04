package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FormWord
{
	public static void main(String args[])
	{
		String input = "fhellowne";
		List<String> dic = new ArrayList<String>();
		dic.add("fellow");
		dic.add("hello");
		dic.add("one");
		dic.add("hell");
		dic.add("fhel");
		System.out.println(formWord(input,dic));
	}
	public static String formWord(String s, List<String> dic)
	{
		int minCount = Integer.MAX_VALUE;
		int minIndex= -1;
		for(int i = 0; i < dic.size() ; i++)
		{
			String dicWord = dic.get(i);
			if(dicWord.length() > s.length())
			{
				continue;
			}else
			{
				int j = 0, k=0,count=0;
				while( k < s.length())	
				{
					if(j < dicWord.length() && dicWord.charAt(j) == s.charAt(k))
					{
						j++;
					}else
					{
						count++;
					}
					k++;
				}
				if(count < minCount)
				{
					minCount = count;
					minIndex = i;
				}
			}
		}
		if(minIndex != -1) return dic.get(minIndex);
		return null;
	}
}

