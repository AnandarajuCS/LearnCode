package leetcode;

public class IntegerBreak
{
	public static void main(String args[])
	{
		System.out.println(integerBreak(3));
	}
	public static int integerBreak(int n)
	{
		int maxProduct = 1;
		for(int i = 1; i < n ; i++)
		{
			int product  = 1;
			int quo = n/i;
			int rem = 0;
			if(n%i > 0)
			{
				rem = n - i*quo;
			}
			if(rem == 1 && quo > 1)
			{
				quo--;
				rem+=i;
			}else
			if(rem == 0) 
			{
				rem =1;
			}
			product = (int) (Math.pow(i,quo)*rem);
			System.out.println("i value : "+ i +" - - - rem : " + rem + " - - - product : " + product);
			if(maxProduct < product)
			{
				maxProduct  = product;
			}
		} 
		return maxProduct;
	}
}

