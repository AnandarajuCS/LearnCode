package leetcode;

public class ExcelSheetColumnNumber {
	public static void main(String args[])
	{
		System.out.println(titleToNumber("AAA"));
	}
	public static int titleToNumber(String s) {
		int len = s.length();
		String alphabets ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int number = 0;
		for(int i = 0; i< len ; i++)
		{
			char c = s.charAt(len-i-1);
			number += (alphabets.indexOf(c)+1) * Math.pow(26,i);
		}
		return number;
	}
}
