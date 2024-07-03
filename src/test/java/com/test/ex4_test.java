package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utility.BaseTest;
import com.utility.Library;
import com.utility.Payload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ex4_test extends BaseTest {

	public ex4_test() {
		RestAssured.baseURI = "http://216.10.245.166";
	}

	@Test
	public void add() {
		String response = RestAssured.given().header("Content-Type", "application/json")
				.body(Payload.addBook(Library.getRandomString(5))).when().post("/Library/Addbook.php").then()
				.statusCode(200).extract().response().asString();

		JsonPath js = new JsonPath(response);
		String msg = js.getString("Msg");
		Assert.assertEquals(msg, "successfully added");

	}

}
