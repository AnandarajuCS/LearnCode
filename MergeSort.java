package org.anand;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	//List<Integer> numList = new ArrayList<Integer>();
	int[] numList = new int[50];

	public MergeSort(int size)
	{
		
	}
	public static void main(String args[])
	{
		MergeSort ms = new MergeSort(20);
		ms.createList();
		ms.printArray(ms.numList);
		ms.sort();
		System.out.println();
		ms.printArray(ms.numList);
	}

	public void printArray(int[] arr)
	{
		for(int i=1;i<=20;i++)
		     System.out.print(arr[i]+"    ");
	}
	public void sort()
	{
		mergeSort(1,20);
	}

	public void mergeSort(int low, int high)
	{
		int mid = (low +high)/2;
		if(low<high)
		{
			mergeSort(low,mid);
			mergeSort(mid+1,high);
			merge(low,mid,high);
		}
	}
	
	public void merge(int low, int mid, int high)
	{
		//List<Integer> tempList = new ArrayList<Integer>();
		int[] tempList = new int[50];
		int h = low;
		int i = low;
		int j = mid+1;
		while ( i<=mid && j<= high)
		{
			if(numList[i] <= numList[j])
			{
				tempList[h]=numList[i] ;
				i++;
			}else
			{
				tempList[h]=numList[j];
				j++;
			}
			h++;
		}
		if(i>mid)
		{
			for(int m=j;m<=high;m++)
			{
				tempList[h]= numList[m];
				h++;
			}
		}
		else
		{
			for(int n = i;n<=mid;n++)
			{
				tempList[h]= numList[n];
				h++;
			}
		}
		for(int l = low; l<=high;l++ )
		{
			numList[l]=tempList[l];
		}

	}
	public void createList() 
	{
		for(int i =1;i<=20;i++)
		{
			numList[i]=(int)(Math.random()*20);

		}

	}
}
