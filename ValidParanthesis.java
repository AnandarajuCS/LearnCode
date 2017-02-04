package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParanthesis {
	public static void main(String args[])
	{
		System.out.println(method("(()[]{}"));
		System.out.println(method("()[]{}"));
		System.out.println(method("(({)[]{}"));
		System.out.println(method("(("));
		System.out.println(method("}"));
		System.out.println(method("((()()()((((())))))){{[]}{}}"));
		System.out.println(method("(])"));
		
	}
	
	public static boolean method(String input)
	{
		//String input = "(()[]{}";
		List<Character> openList=new ArrayList<Character>();
		openList.add('(');
		openList.add('{');
		openList.add('[');
		List<Character> closeList=new ArrayList<Character>();
		closeList.add(')');
		closeList.add('}');
		closeList.add(']');
		
		Stack<Character> refStack= new Stack<Character>();
		
		char[] inputArray=input.toCharArray();
		
		for(int i = 0;i<inputArray.length;i++)
		{			
			if(openList.contains(inputArray[i]))
			{
				refStack.push(closeList.get(openList.indexOf(inputArray[i])));
			}
			else if((!refStack.isEmpty()))
			{
				if (refStack.peek() == inputArray[i])
				{
					refStack.pop();
				}else
				{
					return false;
				}
			}
			else if(refStack.isEmpty() )
			{
				return false;
			}
		}
		return refStack.isEmpty();
//		if(refStack.isEmpty())
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
		
//		String current="";
//		for(int i=0; i< input.length();i+=2)
//		{
//			current = input.substring(i, i+2);
//			if(current.equals(paran) || current.equals(flower) || current.equals(square)) 
//			{
//				continue;
//			}else
//			{
//				System.out.println("not valid");
//				break;
//			}
//		}
//		return true;
	}

}
