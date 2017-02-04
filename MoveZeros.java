package leetcode;

public class MoveZeros {
	public static void print()
	{
		for(int k =0 ; k <nums.length;k++)
		{
			System.out.print(nums[k] + " ");
		}
	}
	static int[] nums={89,0, 1, 0, 0, 3, 12,0};
	public static void main(String[] args) {

		int len=nums.length;
		int i =0;
		while(i<len)
		{
			if(nums[i]==0)
			{
				for(int j = i;j<len-1;j++)
				{
					int temp = nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;	
					print();
					System.out.println("++++++++++++++++++");
				}
				len--;
			}
			else{
				i++;
				print();
				System.out.println("------------------");
			}
		}

	}
}
