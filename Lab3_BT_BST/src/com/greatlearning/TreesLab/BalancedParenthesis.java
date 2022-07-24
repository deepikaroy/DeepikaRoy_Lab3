package com.greatlearning.TreesLab;
import java.util.Stack;

public class BalancedParenthesis 
{
	public static void CheckBalancedParenthesis(String input)
	{
		char[] inputArr = input.toCharArray();
		Stack<Character> stk = new Stack<Character>();
		int closeBracketCount=0;
		
		for(int i=0; i< inputArr.length; i++)
		{
			if(inputArr[i] == '(' || inputArr[i]== '[' || inputArr[i]== '{')
			{
				stk.push(inputArr[i]);
			}
			else
			{ 
				closeBracketCount++;
				if(!stk.isEmpty())
				{
					char top = stk.peek();
					if(inputArr[i] == ')' && top == '(')
					{	
						stk.pop(); 
						closeBracketCount--;
					}
					else if(inputArr[i] == '}' && top == '{')
					{
						stk.pop();
						closeBracketCount--;
					}
					else if(inputArr[i] == ']' && top == '[')
					{
						stk.pop();
						closeBracketCount--;
					}
				}
			}				
		}

		if (stk.isEmpty() && closeBracketCount==0)
			System.out.println("Balanced");
		else
			System.out.println("Not Balanced");
	}

	public static void main(String[] args)
	{
		String input = "([[{}]])"; 
		CheckBalancedParenthesis(input);

		input = "([[{}]]))";
		CheckBalancedParenthesis(input);		
	}

}
