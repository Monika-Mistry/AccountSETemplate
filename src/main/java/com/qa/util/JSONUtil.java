package com.qa.util;

import com.google.gson.Gson;

public class JSONUtil {

	// @Inject
	private Gson gson;

	public JSONUtil() {
		this.gson = new Gson();
	}

	// public JSONUtil() {
	// super();
	// }

	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) {

		return gson.fromJson(jsonString, clazz);
	}

}