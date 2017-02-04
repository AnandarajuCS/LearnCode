package leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FirstUniqCharacter {
public static void main(String[] args) {
	System.out.println(firstUniqChar("loveleetcode"));
}
public static int firstUniqChar(String s) {
    Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
    List<Character> removed = new ArrayList<Character>();
    for(int i = 0; i<s.length();i++)
    {
        char c = s.charAt(i);
        if(removed.contains(c))
        {
            continue;
        }
        if(map.get(c) != null)
        {
            map.remove(c);
            removed.add(c);
        }else
        {
            map.put(c,i);
        }
    }
    if(map.size() > 0)
    {
        return map.get(map.keySet().iterator().next());
    }
    return -1;
}
}
