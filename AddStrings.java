package leetcode;

import java.util.ArrayList;
import java.util.List;

//415
public class AddStrings {
	public static int segment = 6;
	public static void main(String[] args) {
		//System.out.println(getList("1234567891213").toString());
//		System.out.println(addStrings("1234567891213", "1234567891213"));
//		System.out.println(addStrings("8432708", "87372547"));
//		System.out.println(addStrings("9333852702227987", "85731737104263"));
		System.out.println(addStrings("881095803", "61"));
	}
	public static String addStrings(String num1, String num2) 
	{
		List<Long> num1List = getList(num1);
		List<Long> num2List = getList(num2);
		List<Long> smallList;
		List<Long> largerList;
		if(num1List.size() < num2List.size())
		{
			smallList=num1List;
			largerList=num2List;
		}else
		{
			smallList=num2List;
			largerList = num1List;
		}

		int co =0;
		String output="";
		while(smallList.size()>0)
		{
			long num=0;
			num+=smallList.remove(0)+largerList.remove(0);
			if(co == 1)
			{
				num+=1;
			}
			String str = String.valueOf(num);
			if(str.length() > segment)
			{
				str=str.substring(1, segment+1);
				co=1;
			}else
			{
				co=0;
			}
			output=str+output;
			//System.out.println(str);
//			if(co == 1)
//			{
//				num+=1;
//			}
//			if((int)(num / Math.pow(10, segment)) > 0)
//			{
//				co=1;
//				num=(long) (num % Math.pow(10, segment));
//			}else
//			{
//				co=0;
//			}
			//if((int)(num/Math.pow(10, segment-1))==0)
//			if(str.charAt(0) == '0')
//			{
//				output=String.valueOf(str)+output;
//			}
//			else
//			{
//				output=String.valueOf(num)+output;
//			}
			
		}
		for(int i =0; i<largerList.size();i++)
		{
			if(co==1)
			{
				output=String.valueOf(largerList.remove(i)+1)+output;
				co=0;
			}
			else
			{
				output=String.valueOf(largerList.remove(i))+output;
			}			
		}
		return output;
	}
	public static List<Long> getList(String number)
	{
		List<Long> numList = new ArrayList<Long>();
		long num=0;
		int numberLen = number.length();
		for(int i=1; i<=number.length();i++)
		{
			int digit =  Character.getNumericValue(number.charAt(numberLen-i));
			num += digit*Math.pow(10, (i-1)%segment);
			if(i%segment == 0 || i == number.length())
			{
				numList.add(num);
				num=0;
			}
		}
		return numList;
	}
}
/*
    public static int segment = 12;
    public static String addStrings(String num1, String num2) 
	{
		List<String> num1List = getList(num1);
		List<String> num2List = getList(num2);
		List<String> smallList;
		List<String> largerList;
		if(num1List.size() < num2List.size())
		{
			smallList=num1List;
			largerList=num2List;
		}else
		{
			smallList=num2List;
			largerList = num1List;
		}
		int co =0;
		String output="";
		while(smallList.size()>0)
		{
			long num=0;
			String smallString = smallList.remove(0);
			String largeString = largerList.remove(0);
			boolean zeroFlag=false;
			if(smallString.length() ==  segment && smallString.charAt(0) == '0')
			{
				zeroFlag=true;
			}
			if(largeString.length() ==  segment && largeString.charAt(0) == '0')
			{
				zeroFlag=true;
			}
			num+=Long.valueOf(smallString)+Long.valueOf(largeString);
			num+=co;
			String str = String.valueOf(num);
			if(str.length() > segment)
			{
				str=str.substring(1, segment+1);
				co=1;
			}else
			{
				if(str.length() < segment && zeroFlag)
				{
					int len = str.length();
					for(int i =0;i<(segment-len);i++)
					{
						str="0"+str;
					}
				}
				co=0;
			}
			output=str+output;
		}
		for(int i =0; i<largerList.size();i++)
		{
			if(co==1)
			{
				String oldString = largerList.remove(i);
				int pLen = oldString.length();
				int newVal = Integer.valueOf(oldString)+1;
				String newString = String.valueOf(newVal); 
				if(newString.length() < pLen)
				{
					newString="0"+newString;
				}
				output=newString+output;
				co=0;
			}
			else
			{
				output=largerList.remove(i)+output;
			}			
		}
		if(co == 1)
		{
			output="1"+output;
		}
		return output;
	}
	
	public static List<String> getList(String number)
	{
		List<String> numList = new ArrayList<String>();
		int len = number.length();
		for(int i=0;i<len;i+=segment)
		{
			int fromIndex = len-i-segment;
			int toIndex=len-i;
			if(fromIndex < 0) fromIndex=0;
			String str = number.substring(fromIndex,toIndex);
			numList.add(str);
		}
		return numList;
	}

 */
