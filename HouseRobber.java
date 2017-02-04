package leetcode;

public class HouseRobber {
	public static void main(String[] args) {
		System.out.println(rob(new int[]{1,2,3,4,5,6,7,8,9,10}));
		System.out.println(rob(new int[]{2,1,111,2,100,101}));
	}


	public static int rob1(int[] nums) {
		int e = 0;
		int o = 0;
		for(int i = 0;i<nums.length;i++)
		{
			if(i%2==0)
			{
				e+=nums[i];
			}else
			{
				o+=nums[i];
			}
		}
		if(e<o)
		{ 
			System.out.println("odd");
			return o;
		}
		System.out.println("even");
		return e;
	}
	public static int rob(int[] nums) {
		int len = nums.length;
		if(len<1)
		{
			return 0;
		}
		int[] inc = new int[len];
		int[] notInc = new int[len];
		inc[0] = nums[0];
		notInc[0]=0;
		for(int i = 1; i<len;i++)
		{
			inc[i]=notInc[i-1] + nums[i];
			notInc[i] = inc[i-1]>notInc[i-1]?inc[i-1]:notInc[i-1];
		}        
		if(notInc[len-1] > inc[len-1])
		{
			return notInc[len-1];
		}
		return inc[len-1];
	}

}
