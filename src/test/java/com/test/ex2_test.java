package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utility.BaseTest;
import com.utility.Payload;
import com.utility.QuieryParams;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ex2_test extends BaseTest {

	public ex2_test() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	}

	String placeId;

	@Test
	public void add() {
		Response res = RestAssured.given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.place).when().post("/maps/api/place/add/json").then().extract().response();

		Assert.assertEquals(res.statusCode(), 200);
		JsonPath js = new JsonPath(res.asString());
		Assert.assertEquals(js.getString("status"), "OK");
		Assert.assertEquals(js.getString("scope"), "APP");

		placeId = js.getString("place_id");
		System.out.println(placeId);
	}

	@Test(dependsOnMethods = "add")
	public void get() {
		Response res = RestAssured.given().queryParams(QuieryParams.getQueryParamsTest1(placeId))
				.header("Content-Type", "application/json").when().get("/maps/api/place/get/json").then().log().all()
				.extract().response();

		Assert.assertEquals(res.statusCode(), 200);
		JsonPath js = new JsonPath(res.asString());
		System.out.println(js.getString("name"));
	}

	@Test(dependsOnMethods = "get")
	public void update() {
		Response response = RestAssured.given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(Payload.update(placeId)).when()
				.put("/maps/api/place/update/json").then().log().all().statusCode(200).extract().response();

		JsonPath js = new JsonPath(response.asString());

		Assert.assertEquals(js.getString("msg"), "Address successfully updated");
	}

	@Test(dependsOnMethods = "update")
	public void get2() {
		Response res = RestAssured.given().queryParams(QuieryParams.getQueryParamsTest1(placeId))
				.header("Content-Type", "application/json").when().get("/maps/api/place/get/json").then().log().all()
				.extract().response();

		Assert.assertEquals(res.statusCode(), 200);
		JsonPath js = new JsonPath(res.asString());
		System.out.println(js.getString("address"));
		Assert.assertEquals(js.getString("address"), "Pune");

	}
}
