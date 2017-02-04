package leetcode;

import java.util.*;

public class ArrayShifter {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
      reverseArray(a,0,k-1);
      for(int i = 0; i < n; i++)
          System.out.print(a[i] + " ");
      System.out.println("!!!!!!!!!!!!");
      reverseArray(a,k,n-1);
      for(int i = 0; i < n; i++)
          System.out.print(a[i] + " ");
      System.out.println("@@@@@@@@");
      reverseArray(a,0,n-1);
      for(int i = 0; i < n; i++)
          System.out.print(a[i] + " ");
      System.out.println("#######");
      return a;
    }
    
    public static void reverseArray(int[] a, int start , int end)
    {
        int temp;
        while(start<end)
        {
            temp=a[start];
            a[start]= a[end];
            a[end]=temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter size :");
        int n = in.nextInt();
        System.out.println("enter shift :");
        int k = in.nextInt();
        System.out.println("enter array values :");
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.out.println("got values");
      
        for(int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
        in.close();
      
    }
}
