package com.utility;

import java.util.HashMap;
import java.util.Map;

public class Header {

	public static Map<String, String> getHeader(String authorization) {
		Map<String, String> map = new HashMap<>();
		map.put("X-Atlassian-Token", "no-check");
		map.put("Authorization", authorization);
		map.put("Cache-Control", "no-cache");
		map.put("Postman-Token", "<calculated when request is sent>");
		map.put("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>");
		map.put("Content-Length", "<calculated when request is sent>");
		map.put("Host", "<calculated when request is sent>");
		map.put("User-Agent", "PostmanRuntime/7.39.0");
		map.put("Accept", "*/*");
		map.put("Accept-Encoding", "gzip, deflate, br");
		map.put("Connection", "keep-alive");
		return map;
	}

}
