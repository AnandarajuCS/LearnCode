package leetcode;

public class MissingNumbere {
	public static void main(String[] args) {
		System.out.println(missingNumber(new int[]{0,1,3}));
	}
	public static int missingNumber(int[] nums) {

		for(int i = 0; i < nums.length; i++)
		{
			int ind = nums[i];
			if(ind<0)
			{
				ind*=-1;
			}
			if(ind == nums.length) 
			{
				nums[i] = nums.length;
			}else if(nums[ind] > 0)
			{
				//if(ind == 0) nums[i]=-1;
				nums[ind]*=-1;
			}
		}
		for(int j = 0 ; j < nums.length ; j++)
		{
			if(nums[j] > 0) return j;
		}
		return nums.length;
	}
}
