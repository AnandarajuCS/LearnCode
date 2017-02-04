package leetcode;

public class InterleavingString {
public static void main(String[] args) {
	//System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));

}
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
        {
            return false;
        }
        while(s3.length() > 0)
        {
            int is1=s1.indexOf(s3.charAt(0));
            int is2=s2.indexOf(s3.charAt(0));
            
            
            //System.out.println("first  character of s3 " + s3.charAt(0));
            if(is1==0 )
            {
            	System.out.println(is1);
            	//System.out.print("s1 found " + s1);
                s1=s1.replaceFirst(String.valueOf(s3.charAt(0)),"");
                //System.out.println("  --> s1 became : " + s1);
                
            }else if(is2==0)
            {
            	System.out.println(is2);
            	//System.out.print("s2 found " + s2);
                s2=s2.replaceFirst(String.valueOf(s3.charAt(0)),"");
                //System.out.println("  --> s2 became : " + s2);
            }
            s3=s3.replaceFirst(String.valueOf(s3.charAt(0)),"");
           // System.out.println(s3.length() + " " + s3);
        }
       // System.out.println(s1.length() + "  " + s2.length());
        if(s1.length() > 0  || s2.length() > 0)
        {
            return false;
        }
        return true;
        
    }

}
