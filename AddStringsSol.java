package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddStringsSol {
	public static int segment = 16;
	public static void main(String[] args) {

//		String str="12345678912";
//		System.out.println(str.substring(0, str.length()));
//		System.out.println(getList("01234560789121307855476546576").toString());
//		System.out.println(getList("881095803").toString());
//		System.out.println(getList("61").toString());
//		System.out.println(addStrings("0", "0"));
//		System.out.println(addStrings("1234567891213", "1234567891213"));
//		System.out.println(addStrings("8432708", "87372547"));
//		System.out.println(addStrings("9333852702227987", "85731737104263"));
//		System.out.println(addStrings("881095803", "61"));
//		System.out.println(addStrings("498828660196", "840477629533"));
//		System.out.println(addStrings("2498002655", "5186493004848"));
//		System.out.println(addStrings("1498415388859450824", "834720595388"));
		System.out.println(addStrings("824770467603", "2133700961694949067317233830088501871060249833762515230535"));
	}
	
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
		System.out.println(numList.toString());
		return numList;
	}
}
