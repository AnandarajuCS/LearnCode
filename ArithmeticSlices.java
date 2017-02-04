package leetcode;

public class ArithmeticSlices {
	public int numberOfArithmeticSlices(int[] A)
	{
		int diffCount = 0;
		int slices=0;
		int diff = 0;
		int prevDiff = 0;
		for(int i = 1; i < A.length ; i++)
		{
			diff = A[i]-A[i-1];
			if(i != 1 || diff == prevDiff)
			{
				diffCount++;
			}else
			{
				// no inc to count
				diffCount=0;
			}
			slices+=diffCount;
			diff = prevDiff;
		}
		return slices;
	}

}
