package leetcode;

public class CountAndSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}
	public static String countAndSay(int n)
	{
		String numStr = "1";
		if(n == 0) return "";
		for(int i = 1; i < n ; i++)
		{
			char num = numStr.charAt(0);
			String newStr = "";
			int count = 0;
			for(int j = 0; j < numStr.length() ; j++)
			{
				if(num == numStr.charAt(j))
				{
					count++;
				}else
				{
					newStr += String.valueOf(count)+String.valueOf(num);
					count=1;
					num=numStr.charAt(j);
				}
			}
			newStr+=String.valueOf(count)+String.valueOf(num);
			numStr = newStr;
		}
		return numStr;

	}
}
