package com.utility;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;

public class BaseTest {

	@BeforeMethod
	public void beforeTest(Method method) {
		System.out.println("******************** " + method.getName() + " ******************** ");
	}

}
