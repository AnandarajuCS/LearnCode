package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public static int majorityElement(int[] nums) {
		Map<Integer,Integer> count = new HashMap<Integer,Integer>();
		int majority = 0;
		int majCount = 0;
		for(int i = 0; i < nums.length ; i++)
		{
			if (count.get(nums[i])!= null)
			{
				count.put(nums[i], count.get(nums[i])+1);
			}else
			{
				count.put(nums[i],1);
			}
			if(majCount < count.get(nums[i]))
			{
				majCount++;
				majority=nums[i];
			}
		}
		return majority;
	}
	
	public static void main(String args[])
	{
		int[] nums = {5,2,3,2,2,5,5,2,5,2,2,2};
		System.out.println(majorityElement(nums));
	}
}
