package com.test;

import java.io.File;

import org.testng.annotations.Test;

import com.utility.Payload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ex7_jiraApi {

	static String authorization = "Basic eW9nZXNoc2hpbmRlODgzMEBnbWFpbC5jb206QVRBVFQzeEZmR0YwY3lnRFVTMFY1VTY5X1Z1QkNYQjZmaWhqNEw2MDFKNEstWTdQc0JlZmE0M1h3cjJCRHlPVEFSM3ZmMzRtbVM5NUw3alJ6Q1hzcjlUdWlVVTl5WWVMQmhSOHlhSnlPaVNSQkJpZEFPQVRxQW9YUUgzbndtaXh6R05ULVA2bzB0TVpuU0NmNENPMFN6ZjZORElrVHJDM2p6RFhhS1JsRzcwVlhmMjExNHEwdVFRPTYwMDJFREU4";

	static int id;

	@Test
	public void createBug() {
		RestAssured.baseURI = "https://yogeshshinde8830.atlassian.net";

		String res = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", authorization).body(Payload.getBug()).when().post("/rest/api/3/issue").then()
				.assertThat().statusCode(201).extract().response().asString();

		JsonPath js = new JsonPath(res);

		id = js.getInt("id");

		System.out.println(id);
	}

	@Test(dependsOnMethods = "createBug")
	public void attachBug() {
		RestAssured.baseURI = "https://yogeshshinde8830.atlassian.net";
		String res = RestAssured.given().pathParam("key", id).header("X-Atlassian-Token", "no-check")
				.header("Authorization", authorization)
				.multiPart("file", new File(
						"C://Users//yogesh.shinde//Spring_STS//RestApi_Test//src//test//resources//files//java.pdf"))
				.when().post("/rest/api/3/issue/{key}/attachments").then().log().all().assertThat().statusCode(200)
				.extract().response().asString();

	}

}
