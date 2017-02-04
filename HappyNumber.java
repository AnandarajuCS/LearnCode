package leetcode;

public class HappyNumber {
	public static void main(String[] args) {
		System.out.println(isHappy(2));
	}
	public static boolean isHappy(int n) {
		while(n != 1)
		{
			int sum = 0;
			while(n > 0)
			{
				int i = n %10;
				sum  += i*i;
				n = n /10;
				//if(n == 0) break;
			}
			n = sum;
		}
		return true;
	}
}
