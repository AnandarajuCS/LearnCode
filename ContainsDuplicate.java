package leetcode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ContainsDuplicate {
	public static void main(String[] args) {
		int[] nums = new int[30000];
		for(int i =0;i<30000;i++)
		{
			nums[i]=i;
		}
		nums[29999]=3;
		System.out.println(containsDuplicate5(nums));
	}
	public static boolean containsDuplicate5(int[] nums) {
        Hashtable<Integer,Integer> numsTable = new Hashtable<Integer,Integer>();
        for(int i = 0; i< nums.length; i++)
        {
            if(numsTable.containsKey(nums[i]))
            {
                return true;
            }else
            {
                numsTable.put(nums[i],1);
            }
        }
        return false;
    }
	public static boolean containsDuplicate2(int[] nums)
	{
		List<Integer> numsList = new ArrayList<Integer>();
		System.out.println(nums.length);
		for(int i=0,j=nums.length-1;i<nums.length/2;i++,j--)
		{
			if(nums[i] == nums[j])
			{
				return true;
			}
			if(numsList.contains(nums[i]))
			{
				return true;
			}
			else
			{
				numsList.add(nums[i]);
			}
			if(numsList.contains(nums[j]))
			{
				return true;
			}
			else
			{
				numsList.add(nums[j]);
			}
		}
		return false;
	}

	public static boolean containsDuplicate(int[] nums)
	{
		List<Integer> numsList = new ArrayList<Integer>();
		System.out.println(nums.length);
		for(int i=0;i<nums.length;i++)
		{
			if(numsList.contains(nums[i]))
			{
				return true;
			}
			else
			{
				numsList.add(nums[i]);
			}
		}
		return false;
	}

	public static boolean containsDuplicateWithOutNeg(int[] nums) {
		boolean[] boolNums = new boolean[10];
		for(int i=0;i<nums.length;i++)
		{
			if(boolNums[nums[i]] == true)
			{
				return true;
			}
			else
			{
				boolNums[nums[i]]=true;
			}
		}
		return false;
	}
}
