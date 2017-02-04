package leetcode;

public class ContainsDuplicateIII {
	public static void main(String[] args) {
		System.out.println(containsNearbyAlmostDuplicate(new int[]{-1,2147483647},1,2147483647));
		System.out.println( Math.abs(-1-2147483647));
	}
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums.length <= 1) return false;
		for(int i = 0; i < nums.length ; i++)
		{
			for(int j = i+1; j < nums.length ; j++)
			{
				int indexDiff = i-j;
				if(indexDiff < 0) {indexDiff*=-1;}
				long numDiff = nums[i]-nums[j];
				System.out.println(numDiff);
				if(numDiff < 0) { numDiff*=-1;}
				System.out.println(numDiff);
				if( indexDiff <= k && numDiff <= t)
				{
					return true;
				}
			}
		}
		return false;
	}

}
