package leetcode;

public class MaxProductOfWords {
	public static void main(String[] args) {
		System.out.println(maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
	}
	public static int maxProduct(String[] words) {
		int len = words.length;
		int[] mask = new int[len];
		for(int i = 0 ; i < len ; i++)
		{
			int num = 0;
			for(char c : words[i].toCharArray())
			{
				//System.out.print(c-'a');
				num |= 1 << (c-'a');
				//System.out.println(" , num is  : "+num + " , in binary rep : " + Integer.toBinaryString(num));
			}
			mask[i]=num;
			System.out.println(words[i]);
			System.out.println(Integer.toBinaryString(mask[i]));
		}
		int maxProduct=0;
		for(int i = 0; i < len; i++)
		{
			for(int j = i+1 ; j < len ; j++)
			{
				if((mask[i] & mask[j]) == 0 && words[i].length()*words[j].length() > maxProduct)
				{
					maxProduct = words[i].length()*words[j].length();
				}
			}
		}
		return maxProduct;
	}

}
