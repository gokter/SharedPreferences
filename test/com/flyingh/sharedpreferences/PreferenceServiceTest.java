package com.flyingh.sharedpreferences;

import com.flyingh.sharedpreferences.service.impl.PreferenceServiceImpl;

import android.test.AndroidTestCase;

public class PreferenceServiceTest extends AndroidTestCase {
	public void testSave() throws Exception {
		new PreferenceServiceImpl(getContext()).save("abc", 123);
	}
}
