package leetcode;
 class ListNode1 {
	 int val;
	     ListNode1 next;
     ListNode1(int x) { val = x; }
	  }
public class Add2Nums {
public static void main(String[] args) {

	int x=5;
	int y=17;
	while(y!=0)
	{
		int sum =x^y; //xor
		y=x&y; //carry
		x=sum;
		y=y<<1;
	}
	System.out.println(x);
}
public ListNode1 addTwoNumbers1(ListNode1 l1, ListNode1 l2) 
{
    int sum = convertLLToInt(l1)+ convertLLToInt(l2);
    System.out.println(convertLLToInt(l1));
    System.out.println(convertLLToInt(l2));
    System.out.println(sum);
    return convertIntToLL(sum);
}
public  ListNode1 convertIntToLL(int num)
{
//		int len = (int)(Math.log10(sum)+1);
//		ListNode[] lnArray = new ListNode[len];
//		int i = 0;
//		lnArray[0]=new ListNode(0);
//		while(sum != 0)
//		{
//			if(i<len-1)
//			{
//				lnArray[i+1]=lnArray[i].next = new ListNode(sum%10);
//			}
//			else
//			{
//				lnArray[i].next = new ListNode(sum%10);	
//			}
//			sum/=10;
//			i++;
//		}
//		return lnArray[1];
	ListNode1 lnHead = new ListNode1(num%10);
	num/=10;
	ListNode1 ln = lnHead;
	while( num > 0)
	{
	    ln.next = new ListNode1(num%10);
	    ln = ln.next;
	    num/=10;
	}
	return lnHead;
}

public  int convertLLToInt(ListNode1 ln)
{
	int num=0;
	for(int i = 1; ln!=null;i*=10)
	{
	    num= num & 0xFFFFFFFF;
		num+=ln.val*i;
		ln=ln.next;
		System.out.println(num);
	}
	return num;
}
}
