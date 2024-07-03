package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utility.BaseTest;
import com.utility.Payload;

import io.restassured.path.json.JsonPath;

public class ex3_test extends BaseTest {

	@Test
	public void get() {
		JsonPath json = new JsonPath(Payload.data);

		String website = json.getString("dashboard.website");
		int purchaseAmount = json.getInt("dashboard.purchaseAmount");
		int noOfCourses = json.getInt("courses.size()");

		System.out.println("website : " + website);
		System.out.println("purchaseAmount : " + purchaseAmount);
		System.out.println("noOfCourses : " + noOfCourses);

		// print tiltle of first course

		String title = json.getString("courses[0].title");
		System.out.println("title : " + title);

		// Print All course titles and their respective Prices

		for (int i = 0; i < noOfCourses; i++) {
			String title1 = json.getString("courses[" + i + "].title");
			String price = json.getString("courses[" + i + "].price");
			System.out.println("title : " + title1 + " price : " + price);

		}

		// Print no of copies sold by RPA Course
		String RpaCopies = null;
		for (int i = 0; i < noOfCourses; i++) {
			if (json.getString("courses[" + i + "].title").equals("RPA")) {
				RpaCopies = json.getString("courses[" + i + "].copies");
			}
		}

		System.out.println("RpaCopies :" + RpaCopies);

		// Verify if Sum of all Course prices matches with Purchase Amount
		int sumAllCourses = 0;
		for (int i = 0; i < noOfCourses; i++) {
			int price = json.getInt("courses[" + i + "].price");
			int copies = json.getInt("courses[" + i + "].copies");

			sumAllCourses = sumAllCourses + (price * copies);
		}
		System.out.println("sumAllCourses : " + sumAllCourses);
		Assert.assertEquals(purchaseAmount, sumAllCourses);

	}

}
