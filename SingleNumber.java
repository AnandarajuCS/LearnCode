package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {
	
	public static void main(String args[])
	{
		int[] nums = {1,2,2,1,4,3,5,3,5};
		System.out.println(singleNumber(nums));
	}
	
	    public static int singleNumber(int[] nums) {
	        List<Integer> sol = new ArrayList<Integer>();
	        for (int i =0; i < nums.length; i++)
	        {
	        	System.out.println(sol.toString());
	            if(sol.contains(nums[i]))
	            {
	                sol.remove(sol.indexOf(nums[i]));
	            }else
	            {
	                sol.add(nums[i]);
	            }
	        
	        }
	        //if(solution)
	        return sol.get(0);
	    }

}
