package leetcode;

import java.util.Iterator;
import java.util.List;

public class TriangleMinPath 
{
	public static void main(String args[])
	{

	}
	public int minimumTotal1(List<List<Integer>> triangle)
	{
		int path = 0;
		int min = Integer.MAX_VALUE;
		Iterator<List<Integer>> rowIterator = triangle.listIterator();
		while(rowIterator.hasNext())
		{
			List<Integer> row = rowIterator.next();
			Iterator<Integer> elementIt = row.listIterator();
			while( elementIt.hasNext())
			{
				int element = elementIt.next();
				if(element < min)
				{
					min = element;
				}
			} 
			path+=min;
			min =  Integer.MAX_VALUE;
		}
		return path;
	}
	public int minimumTotal(List<List<Integer>> triangle)
	{
		int rows = triangle.size();
		//System.out.println("No of rows is : "+rows);
		int[] path = new int[rows+1];
		for(int i = rows-1;i>=0;i--)
		{
			for(int j = 0; j <= i ; j++)
			{
				int n = triangle.get(i).get(j);

				if(n+path[j] > n+path[j+1] ) 
				{
					path[j]=n+path[j+1];
				}else
				{
					path[j]=n+path[j];
				}
				//System.out.println(path[j]);
			}
			//System.out.println("end of a row");
		}
		return path[0];
	}

}	


