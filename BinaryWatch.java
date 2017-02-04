package leetcode;

import java.util.ArrayList;
import java.util.List;

/*401 - Binary watch - A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
Each LED represents a zero or one, with the least significant bit on the right.
Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

// the solution that I have mentioned here is from the solution and not from own.
 * 
 */

public class BinaryWatch
{
	public static void main(String args[])
	{
		System.out.println(readBinaryWatch(7));
		//System.out.println(countOnes(4));
	}
	public static List<String> readBinaryWatch(int num)
	{
		List<String> times = new ArrayList<String>();
		for(int i = 0; i<12;i++)
		{
			for(int j = 0; j < 60;j++)
			{
				String time = "";
				if(countOnes(i) + countOnes(j) == num)
				{
					time+=String.valueOf(i)+":";
					if(j<10)
					{
						time+="0"+String.valueOf(j);
					}else
					{
						time+=String.valueOf(j);
					}
					times.add(time);
				}
			}
		}
		return times;
	}
	public static int countOnes(int num)
	{
		int count = 0;
		while(num > 0)
		{
			// we need to put the bit operations in parenthesis
			if((num & 1) == 1) 
				// binary AND with one to check if the last bit(LSB) is 1
			{
				count++;
			}
			num >>=1;
		}
		return count;
	}
}
