package com.GitDemo.GitProject;

public class DemoGit {

	public static void main(String[] args) {
		
		String name = "Shravani";
		
		StringBuffer sb = new StringBuffer(name);
		String rev = sb.reverse().toString();
		System.out.println(rev);
		
		String sb1 = new StringBuffer("Shravani").reverse().toString();
		System.out.println(sb1);
		
		for(int i=name.length()-1; i>=0; i--)
		{
			System.out.print(name.charAt(i));
		}

	}

}
