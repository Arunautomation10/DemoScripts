package com.GitDemo.GitProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class complexJson {
	
	static JsonPath js = new JsonPath(PayLoadData.coursePrice());
	static int count = js.getInt("courses.size()");
	
	@Test(priority=1)
	//print course size
	public static void courseSize()
	{
		int count = js.getInt("courses.size()");
		System.out.println(count);
	}
	
	@Test(priority=2)
	//print purchase amount
	public static void purchaseAmt()
	{
		int amt = js.getInt("dashboard.purchaseAmount");
		System.out.println(amt);
	}
	
	@Test(priority=3)
	//print first course title
	public static void courseTitle()
	{
		String title = js.getString("courses[0].title");
		System.out.println(title);
	}
	
	@Test(priority=4)
	//print all courses and respective titles
	public static void titles()
	{
		for(int i=0;i<count;i++)
		{
		System.out.println(js.get("courses["+i+"].title"));
		System.out.println(js.get("courses["+i+"].price"));
		}
	}
	
	@Test(priority=5)
	public static void copiesCount()
	{
		//print the no of copies for RPA course
		for(int i=0;i<count;i++)
		{
		String course = js.get("courses["+i+"].title");
		if(course.equalsIgnoreCase("cypress"))
		{
			System.out.println(js.get("courses["+i+"].copies"));
			break;
		}
		}	
	}
	
	@Test(priority=6)
	public static void sumPrice()
	//Verify if sum of all course price matches with purchase amount
	{
		int sum=0;
		for(int i=0; i<count;i++)
		{
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int totalPrice = price * copies;
			sum = sum+totalPrice;
		}
		System.out.println(sum);
		
		int totalPriceDisplayed = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, totalPriceDisplayed);			
	}
}
