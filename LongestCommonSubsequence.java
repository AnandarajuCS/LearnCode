import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * This class has an implementation of Longest Common Subsequence of two given strings,
 * using Dynamic programming. This uses a 2D integer array to store the optimal value
 * of Longest Common Subsequence length.
 * Input - input.txt file containing the two input strings ;
 * Output - output.txt file containing the LCS length and the LCS output string.
 * @author Anandaraju CS
 */
public class LongestCommonSubsequence {
	public static String string1 = "";
	public static String string2 = "";
	public static String inputFile = "input.txt";
	public static String outputFile = "output.txt";
	public static void main(String args[])
	{
		try {
			readInputFromFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		determineLCS(string1,string2);
	}

	public static void readInputFromFile() throws FileNotFoundException
	{
		Scanner scanner = new Scanner(new File(inputFile));
		if(scanner.hasNext())
		{
			string1 = scanner.nextLine();
		}
		if(scanner.hasNext())
		{
			string2 = scanner.nextLine();
		}
		scanner.close();
	}
	public static void determineLCS(String string1, String string2)
	{
		// stores the final LCS output length
		int lcsLength = 0;
		// stores the final LCS output
		String lcsOutput = "";

		int len1 = string1.length();
		int len2 = string2.length();
		int[][] optVal = new int[len1+1][len2+1];
		for(int i = 0; i <= len1 ; i++)
		{
			for(int j = 0 ; j <= len2 ; j++)
			{
				if(i == 0 || j == 0)
				{
					//initializing the first row and first column of the optVal array to zero.
					optVal[i][j] = 0;
				}else
				{
					if(string1.charAt(i-1) == (string2.charAt(j-1)))
					{
						optVal[i][j] = optVal[i-1][j-1] + 1;
					}else
					{
						if(optVal[i-1][j] < optVal[i][j-1])
						{
							optVal[i][j] = optVal[i][j-1];
						}else
						{
							optVal[i][j] = optVal[i-1][j];
						}
					}
				}
			}
		}

		// the length of the longest common subsequence is the last element (bottom right) in the 2D array 
		lcsLength = optVal[len1][len2];


		//Back tracking the constructed optVal 2D array to get the actual elements in the LCS
		int p = len1;
		int q = len2;
		while(p > 0 && q > 0)
		{
			char c1 = string1.charAt(p-1);
			char c2 = string2.charAt(q-1);
			if(c1 == c2)
			{
				lcsOutput = c1 + lcsOutput;
				p--;
				q--;
			}else
			{
				if(optVal[p][q-1] > optVal[p-1][q])
				{
					q--;
				}else
				{
					p--;
				}
			}
		}


		// Writing the lcs length and the actual length into the output.txt file
		BufferedWriter bufferedWriter;
		File file = new File(outputFile);
		try 
		{
			if(!file.exists())
			{
				file.createNewFile();
			}
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),Charset.forName("UTF-8")));
			bufferedWriter.write(String.valueOf(lcsLength));
			bufferedWriter.newLine();
			bufferedWriter.write(lcsOutput);
			bufferedWriter.flush();
			bufferedWriter.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
