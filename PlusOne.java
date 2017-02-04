package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0]=2;
		arr[4]=9;
//		arr = Arrays.copyOf(arr, arr.length+1);
		int[] arr1 = new int[6];
		arr1[0]=1;
		System.arraycopy(arr, 0, arr1, 1, arr.length);
		for(int i =0; i < arr1.length; i++)
		{
			System.out.println(arr1[i]);
		}
		
	}
	public int[] plusOne(int[] digits) {
        List<Integer> num = new ArrayList<Integer>();
        int len = digits.length;
        int carry = 1;
        for(int i = len-1; i >=0 ; i--)
        {
            int val = carry+digits[i];
            if(val > 9)
            {
                carry=1;
                val%=10;
            }else
            {
                carry=0;
            }
            num.add(0,val);
        }
        if(carry == 1) num.add(0,1);
        int[] array = num.stream().mapToInt(k->k).toArray();
        return array;
    }
}
