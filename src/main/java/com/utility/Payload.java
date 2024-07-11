package com.utility;

import java.util.HashMap;
import java.util.Map;

public class Payload {

	public static String department = "{\r\n" + "    \"id\": 2,\r\n" + "    \"name\": \"ajay\",\r\n"
			+ "    \"city\": \"noida\"\r\n" + "}";

	public static String place = "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n"
			+ "    \"lng\": 33.427362\r\n" + "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \"yogesh\",\r\n"
			+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + "  \"address\": \"USA\",\r\n" + "  \"types\": [\r\n"
			+ "    \"shoe park\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n" + "  \"website\": \"http://google.com\",\r\n"
			+ "  \"language\": \"French-IN\"\r\n" + "}\r\n" + "\r\n" + "";

	public static String update(String placeId) {
		return "{\r\n" + "\"place_id\":\"" + placeId + "\",\r\n" + "\"address\":\"Pune\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "";

	}

	public static String data = "{\r\n" + "\r\n" + "\"dashboard\": {\r\n" + "\r\n" + "\"purchaseAmount\": 910,\r\n"
			+ "\r\n" + "\"website\": \"rahulshettyacademy.com\"\r\n" + "\r\n" + "},\r\n" + "\r\n" + "\"courses\": [\r\n"
			+ "\r\n" + "{\r\n" + "\r\n" + "\"title\": \"Selenium Python\",\r\n" + "\r\n" + "\"price\": 50,\r\n" + "\r\n"
			+ "\"copies\": 6\r\n" + "\r\n" + "},\r\n" + "\r\n" + "{\r\n" + "\r\n" + "\"title\": \"Cypress\",\r\n"
			+ "\r\n" + "\"price\": 40,\r\n" + "\r\n" + "\"copies\": 4\r\n" + "\r\n" + "},\r\n" + "\r\n" + "{\r\n"
			+ "\r\n" + "\"title\": \"RPA\",\r\n" + "\r\n" + "\"price\": 45,\r\n" + "\r\n" + "\"copies\": 10\r\n"
			+ "\r\n" + "}\r\n" + "\r\n" + "]\r\n" + "\r\n" + "}";

	public static String addBook(String isbn) {
		return "{\r\n" + "\r\n" + "\"name\":\"Learn Appium Automation with Java\",\r\n" + "\"isbn\":\"" + isbn
				+ "\",\r\n" + "\"aisle\":\"227\",\r\n" + "\"author\":\"John foe\"\r\n" + "}\r\n" + "";
	}

	public static String getBug() {
		return "{\r\n" + "    \"fields\": {\r\n" + "       \"project\":\r\n" + "       {\r\n"
				+ "          \"key\": \"SCRUM\"\r\n" + "       },\r\n"
				+ "       \"summary\": \" country Dropdown not clickable " + Library.getRandomString(10) + " \",\r\n"
				+ "       \"issuetype\": {\r\n" + "          \"name\": \"Bug\"\r\n" + "       }\r\n" + "   }\r\n"
				+ "}\r\n" + "";
	}

	public static Map<String, String> getFormData() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com");
		map.put("client_secret", "erZOWM9g3UtwNRj340YYaK_W");
		map.put("grant_type", "client_credentials");
		map.put("scope", "trust");
		return map;
	}

}
