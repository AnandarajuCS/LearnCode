package leetcode;

public class ReverseString {
	public static void main(String[] args) {
		String s = "asdf";
		char c = s.charAt(0);

		System.out.println();
	}
	public String reverseString(String s) {
		char[] charArray = s.toCharArray();
		for(int i = 0 ; i < s.length()/2 ; i++)
		{
			char c = charArray[i];
			charArray[i]=charArray[s.length()-i-1];
			charArray[s.length()-i-1] = c;
		}	
		return new String(charArray);
	}
}
