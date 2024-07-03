package com.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ex5_dataProvider {

	@Test(dataProvider = "loginData")
	public static void main(String name, int pass) {
		System.out.println("name : " + name + " , pass : " + pass);
	}

	@DataProvider(name = "loginData")
	private Object[][] getData() {
		return new Object[][] { { "yogesh", 1234 }, { "manish", 3455 }, { "ajay", 45345 } };
	}

}
