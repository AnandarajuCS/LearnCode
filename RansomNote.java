package leetcode;

public class RansomNote {
	public static boolean canConstruct(String ransomNote, String magazine) {
        char[] rn = ransomNote.toCharArray();
        for(int i = 0 ; i < rn.length ; i++)
        {
            if(!magazine.contains(String.valueOf(rn[i])))
            {
            	return false;
            }else{
            	magazine=magazine.replaceFirst(String.valueOf(rn[i]), "");
            }
        }
        return true;
    }
	public static void main(String args[])
	{
		System.out.println(canConstruct("aa", "ab"));
	}
}
