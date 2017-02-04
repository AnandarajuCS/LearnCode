package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
	public static void main(String[] args) {
		System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
	}
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> outputList = new ArrayList<Integer>();
		for(int i = 1; i <= nums.length ; i++)
		{
			outputList.add(i);
		}
		for(int j = 0; j < nums.length ; j++)
		{	
			outputList.remove((Object)nums[j]);
		}
		return outputList;
	}
}
