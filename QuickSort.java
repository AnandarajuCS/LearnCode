package org.anand;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

	public List<Integer> numArray = new ArrayList<Integer>();
	public int arraySize;
	public int count = 0;
	public QuickSort(int size)
	{
		this.arraySize= size;
	}
	public static void main(String args[])
	{
		QuickSort qs = new QuickSort(15);
		qs.createArray();
		System.out.println(qs.numArray.toString());
		qs.quickSort(qs.numArray, 0, qs.numArray.size()-1 );
		System.out.println("The sorted array is " + qs.numArray.toString());
		System.out.println(qs.count);
	}
	public void createArray()
	{
		for(int i =0;i<this.arraySize;i++)
		{
			numArray.add((int)(Math.random()*arraySize));
		}
	}

	public void quickSort(List<Integer> array , int left, int right)
	{
		int pivot = array.get(right);
		//System.out.println("The choosed pivot is : " + pivot);
		count++;
		int i = left;
		int j = right;
		while(i<=j)
		{
			while(array.get(i) < pivot)
			{
				i++;
			}
			// found number left of pivot greater than pivot
			while(array.get(j) > pivot)
			{
				j--;
			}
			// found number right of pivot lesser than pivot
			if(i<=j)
			{
				//swap
				int temp = array.get(i);
				array.set(i, array.get(j));
				array.set(j, temp);
				i++;
				j--;
			}
		}
		if(left<j)
		{
			quickSort(array, left, j);
		}
		if(right >i)
		{
			quickSort(array,i,right);
		}

	}
}
