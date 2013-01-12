package com.flyingh.sharedpreferences.service.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.flyingh.sharedpreferences.service.PreferenceService;

public class PreferenceServiceImpl implements PreferenceService {
	private Context context;

	public PreferenceServiceImpl(Context context) {
		super();
		this.context = context;
	}

	@Override
	public void save(String name, int age) throws Exception {
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				"flyingh", Context.MODE_PRIVATE);
		Editor editor = sharedPreferences.edit();
		editor.putString("name", name);
		editor.putInt("age", age);
		editor.commit();
	}

}
