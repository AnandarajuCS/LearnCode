package leetcode;

import java.math.BigInteger;

public class HammingWeight {
	public static void main(String args[])
	{
//		System.out.println(hammingWeight(2147483648 ));
		// the above test case has value greater than the Interger.MAX_VALUE so we need to convert the 32 bit signed integer to
		// 32 bit unsigned integer, basically converting in to long value by bitwise AND with the 0xffffffffL long value.
		System.out.println(Integer.MAX_VALUE);
	}
	public static int hammingWeight(int n)
	{
		long num = n & 0xffffffffL;
		int count = 0;
		while(num > 0)
		{
			if(num % 2 == 1)
			{
				count++;
			}
			num/=2;
		}
		return count;
	}

}
