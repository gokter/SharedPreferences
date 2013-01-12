package com.flyingh.sharedpreferences.service;

import java.util.Map;

public interface PreferenceService {
	void save(String name, int age) throws Exception;

	Map<String, ?> read() throws Exception;
}
