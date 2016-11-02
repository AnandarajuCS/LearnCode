package org.anand;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

	static List<Integer> arrayOfNums = new ArrayList<Integer>();
	public int count = 0;
	public static final int size = 200;
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		bs.createArray(size);
		bs.sort(arrayOfNums);
	}
	public List<Integer> createArray(int n)
	{
		for(int i=0; i<n;i++)
		{
			arrayOfNums.add((int)(Math.random()*size));
		}
		System.out.println("The generated array is : " + arrayOfNums.toString());
		return arrayOfNums;
	}

	public void sort(List<Integer> numList )
	{
		int length = numList.size();
		System.out.println("length of the array : " + length);
		for( int i=length-1;i>=0;i--)
		{ 
			for(int j = 0; j<i;j++)
			{
				if(numList.get(j)>numList.get(j+1))
				{
					count++;
					int temp = numList.get(j);
					numList.set(j, numList.get(j+1));
					numList.set(j+1, temp);
				}
			}
			//System.out.println("Step: " + i + " : Intermediate sorted array : " + numList.toString());
		}
		System.out.println("The sorted Array is : " + numList.toString());
		System.out.println(count);
	}

}
