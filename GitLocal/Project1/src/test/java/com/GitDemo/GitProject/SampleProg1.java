package com.GitDemo.GitProject;

import org.testng.annotations.Test;

public class SampleProg1 {
	
	@Test
	public static void demo1()
	{
		//Print pyramid code
		int a = 5;
		for(int i=1;i<=a;i++)
		{
			for(int j=0;j<i;j++)
			{
			System.out.print(i);
			}
			System.out.println(" ");
		}
	}
	
	@Test
	public static void demo2()
	{
		int a=0;
		for(int i=5;i>a;i--)
		{
			for (int j=0;j<i;j++)
			{
			System.out.print(i);
			}
			System.out.println(" ");
		}
		
	}
}
