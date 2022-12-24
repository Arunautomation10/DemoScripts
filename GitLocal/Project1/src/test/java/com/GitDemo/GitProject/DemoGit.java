package com.GitDemo.GitProject;

public class DemoGit {

	public static void main(String[] args) {
		
		String name = "Arun";
		
		StringBuffer sb = new StringBuffer(name);
		String rev = sb.reverse().toString();
		System.out.println(rev);
		
		for(int i=name.length()-1; i>=0; i--)
		{
			System.out.print(name.charAt(i));
		}

	}

}
