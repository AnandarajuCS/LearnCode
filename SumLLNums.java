package leetcode;


public class SumLLNums {

	public static void main(String args[])
	{
		ListNode l1 = new ListNode(2);
		ListNode l2 = l1.next=new ListNode(4);
		ListNode l3 = l2.next=new ListNode(3);
		ListNode ll1 = new ListNode(5);
		ListNode ll2 = ll1.next=new ListNode(6);
		ListNode ll3 = ll2.next=new ListNode(4);
		int ln1=convertLLToInt(l1);
		System.out.println(ln1);
		int ln2=convertLLToInt(ll1);
		System.out.println(ln2);
		int sum = ln1+ln2;
		System.out.println(convertIntToLL(sum));
		convertIntToLL(sum).print();
		
		
	}
	
	public static ListNode convertIntToLL(int sum)
	{
		int len = (int)(Math.log10(sum)+1);
		ListNode[] lnArray = new ListNode[len];
		int i = 0;
		lnArray[0]=new ListNode(0);
		while(sum != 0)
		{
			if(i<len-1)
			{
				lnArray[i+1]=lnArray[i].next = new ListNode(sum%10);
			}
			else
			{
				lnArray[i].next = new ListNode(sum%10);	
			}
			sum/=10;
			i++;
		}
		return lnArray[1];
	}
	
	public static int convertLLToInt(ListNode l)
	{
		int num=0;
		for(int i = 1; l!=null;i*=10)
		{
			num+=l.value*i;
			l=l.next;
		}
		return num;
	}
	
}

class ListNode
{
	int value;
	ListNode next;
	
	ListNode(int x)
	{
		value=x;
	}
	
	ListNode()
	{
		
	}
	
	public void print()
	{
		ListNode n=this;
		while(n != null)
		{
			System.out.print(n.value+" ");
			n=n.next;
		}
	}
}
