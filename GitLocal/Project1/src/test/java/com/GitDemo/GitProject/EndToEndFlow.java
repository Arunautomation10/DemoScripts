package com.GitDemo.GitProject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class EndToEndFlow {
		//given - all input details
		//when - submit the api - Resource and HTTP method
		//then - validate the response
		
		public static void main (String[] args)
		{
			//Add Place API Testing
			RestAssured.baseURI="https://rahulshettyacademy.com/";
			String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
			.body(PayLoadData.AddPlace()).when().post("/maps/api/place/add/json")
			.then().statusCode(200).body("scope", equalTo("APP"))
			.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
			
			System.out.println(response);
			
			JsonPath js = ReuseableMethodsAPI.rawJson(response);
			String PlaceID = js.getString("place_id");
			
			//JsonPath js1 = new JsonPath(PayLoad.AddPlace());
			JsonPath js1 = ReuseableMethodsAPI.addressOld(PayLoadData.AddPlace());
			String Address = js1.getString("address");
			
			System.out.println(PlaceID);
			System.out.println(Address);
			
			//Update place
			String addressNew = "The Nelson Inn - Gloucester, UK";
			given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
			.body("{\r\n"
					+ "\"place_id\":\""+PlaceID+"\",\r\n"
					+ "\"address\":\""+addressNew+"\",\r\n"
					+ "\"key\":\"qaclick123\"\r\n"
					+ "}")
			.when().put("maps/api/place/update/json")
			.then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
			
			//Get place
			
			String getResponse = given().queryParam("key", "qaclick123").queryParam("place_id", PlaceID)
			.when().get("/maps/api/place/get/json")
			.then().statusCode(200).extract().response().asString();
			
			//verify the address updated
			
			JsonPath js2 = ReuseableMethodsAPI.updatedAddress(getResponse);
			String newAddress = js2.getString("address");
			
			Assert.assertNotEquals(Address, newAddress);	
		}
}
