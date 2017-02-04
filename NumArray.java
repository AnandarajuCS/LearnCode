package leetcode;

//303. Range Sum Query - Immutable
//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
public class NumArray {
	int[]  nums;
	int[] sumArray;
	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
		System.out.println(numArray.sumRange(0, 1));
		System.out.println(numArray.sumRange(1, 2));
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2, 5));
		System.out.println(numArray.sumRange(0, 5));
		
	}
	public NumArray(int[] nums) {
		this.nums = nums;
		this.sumArray =  new int[nums.length];
		int s = 0;
		for(int i =0;i < nums.length;i++)
		{
			s+=nums[i];
			sumArray[i]=s;
		}
		for(int j = 0; j<sumArray.length;j++)
		{
			System.out.print(sumArray[j] + " ");
		}
		System.out.println();
	}
	public int sumRange(int i, int j) {
		if(i>0)
		{
			return sumArray[j]-sumArray[i-1];
		}else
		{
			return sumArray[j];
		}
	}


	// public int sumRange(int i, int j) {
	//     int sum = 0;
	//     for(int k = i ; k <= j ; k++)
	//     {
	//         sum+=nums[k];
	//     }
	//     return sum;
	// }


}
