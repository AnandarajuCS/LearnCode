package leetcode;

public class UniquePathRobot {
	public static void main(String args[])
	{
		System.out.println(uniquePaths(3, 7));
	}	
	public static int uniquePaths(int m, int n)
	{
		int[][] paths = new int[m][n];
		for(int i = 0; i <m ; i++)
		{
			for(int j =0 ; j < n ; j++)
			{
				if(i ==0 || j ==0)
				{
					paths[i][j]=1;
				}else
				{
					paths[i][j] = paths[i-1][j]+paths[i][j-1];
				}		
			}
		}
		return paths[m-1][n-1];
	}
	public int uniquePaths2(int m , int n)
	{
		int[] paths2 = new int[n];
		for(int p = 0; p< m; p++)
		{
			for(int q =0 ; q < n; q++)
			{
				if(p == 0 || q == 0)
				{
					paths2[q]=1;
				}else
				{
					paths2[q]=paths2[q]+paths2[q-1];    
				}
			}
		}
		return paths2[n-1];
	}

}
