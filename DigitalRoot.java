package leetcode;

public class DigitalRoot {
	public static void main(String[] args) {
		int n = 987;
		System.out.println(n-9*Math.floorDiv(n-1, 9));
		String s="abcd";
		String t = "abcde";
		for(char c:t.toCharArray())
		{
			int in= s.indexOf(c);
			if(in != -1)
			{
				s=s.replaceFirst(String.valueOf(c), "_");
			}else
			{
				System.out.println(c);
			}
			
		}
		System.out.println();
	}
}
