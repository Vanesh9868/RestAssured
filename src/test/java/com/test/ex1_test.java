package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utility.Payload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ex1_test {

	@Test
	public static void masdsh() {
		RestAssured.baseURI = "http://localhost:8080";
		Response res = RestAssured.given().when().get("/getName").then().extract().response();
		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.asString(), "velocity training center");
	}

	@Test
	public void test2() {
		RestAssured.baseURI = "http://localhost:8080";
		Response res = RestAssured.given().header("Content-Type", "application/json").body(Payload.department).when()
				.post("/getObject").then().extract().response();

		Assert.assertEquals(res.statusCode(), 200);
		JsonPath js = new JsonPath(res.asString());

		Assert.assertEquals(js.getInt("id"), 2);
		Assert.assertEquals(js.getString("name"), "ajay");
		Assert.assertEquals(js.getString("city"), "noida");

	}

}
