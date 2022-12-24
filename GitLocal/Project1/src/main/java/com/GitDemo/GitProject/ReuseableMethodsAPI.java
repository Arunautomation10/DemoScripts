package com.GitDemo.GitProject;

import io.restassured.path.json.JsonPath;

public class ReuseableMethodsAPI {
	
	public static JsonPath rawJson(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}

	public static JsonPath addressOld(String Address)
	{
		JsonPath js1 = new JsonPath(Address);
		return js1;
	}
	
	public static JsonPath updatedAddress(String Address)
	{
		JsonPath js2 =  new JsonPath(Address);
		return js2;
	}

}
