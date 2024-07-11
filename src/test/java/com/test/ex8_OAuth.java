package com.test;

import org.testng.annotations.Test;

import com.utility.Payload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ex8_OAuth {

	static String accessToken;

	@Test
	public static void generateToken() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = RestAssured.given().formParams(Payload.getFormData()).when()
				.post("/oauthapi/oauth2/resourceOwner/token").then().extract().asString();
		JsonPath js = new JsonPath(response);
		accessToken = js.getString("access_token");

		System.out.println("accessToken : " + accessToken);
	}

	@Test(dependsOnMethods = "generateToken")
	public static void getCourseDetails() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = RestAssured.given().queryParams("accessToken", accessToken).when()
				.get("/oauthapi/getCourseDetails?access_token=aDoZFBoDgOJlSv8uF02rMw==").then().extract().asString();
		JsonPath js = new JsonPath(response);

		String inst = js.getString("instructor");

		System.out.println("instructor : " + inst);

	}

}
