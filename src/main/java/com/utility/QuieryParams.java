package com.utility;

import java.util.HashMap;
import java.util.Map;

public class QuieryParams {

	public static Map<String, String> getQueryParamsTest1(String placeId) {
		Map<String, String> my_map = new HashMap<String, String>();

		my_map.put("key", "qaclick123");
		my_map.put("place_id", placeId);

		return my_map;
	}

}
