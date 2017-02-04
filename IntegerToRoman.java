package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
	public static void main(String[] args) {
		System.out.println(intToRoman(1));
	}
	    public static String intToRoman(int num) {
	        Map<Integer,Character> romanChar = new HashMap<Integer,Character>();
	        romanChar.put(1,'I');
	        romanChar.put(5,'V');
	        romanChar.put(10,'X');
	        romanChar.put(50,'L');
	        romanChar.put(100,'C');
	        romanChar.put(500,'D');
	        romanChar.put(1000,'M');
	        int place = 1;
	        String str = "";
	        while(num>0)
	        {
	            int n = num%10;
	            if(n == 4) 
	            {
	                str=String.valueOf(romanChar.get(1*place))+String.valueOf(romanChar.get(5*place))+str;
	            }
	            else if(n == 9)
	            {
	                str=String.valueOf(romanChar.get(1*place))+String.valueOf(romanChar.get(10*place))+str;
	            }else
	            {
	                //n=n*place;
	                while(n>0)
	                {
	                    if(n==5)
	                    {
	                        str=String.valueOf(romanChar.get(5*place))+str;
	                        break;
	                    }else
	                    {
	                    	
	                    	//System.out.println(String.valueOf(romanChar.get(place)));
	                        str=String.valueOf(romanChar.get(place))+str;
	                        n--;
	                    }
	                }
	            }
	            num/=10;
	            place*=10;
	        }
	        return str;
	    }
}
