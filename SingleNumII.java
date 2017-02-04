package leetcode;

import java.lang.reflect.Array;

public class SingleNumII {
public static void main(String[] args) {
	//System.out.println(singleNumber(new int[]{5,1,2,3,3,4,3,1,2,2,5,5}));
	int n = -8;
//	while(n > 0)
//	{
//		System.out.println(n%2);
//		n/=2;
//	}
	Integer ii = new Integer(n);
	
	System.out.println(Integer.toBinaryString(n));
	System.out.println(Integer.bitCount(n));
//    System.out.println(n>>>1);
}
public static int singleNumber(int[] A) {
    int ones = 0, twos = 0;
    for(int i = 0; i < A.length; i++){
        ones = (ones ^ A[i]) & ~twos;
        twos = (twos ^ A[i]) & ~ones;
    }
    return ones;
    
}
}
