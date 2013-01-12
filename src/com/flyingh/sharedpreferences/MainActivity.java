package com.flyingh.sharedpreferences;

import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.flyingh.sharedpreferences.service.PreferenceService;
import com.flyingh.sharedpreferences.service.impl.PreferenceServiceImpl;

public class MainActivity extends Activity {
	private static final String TAG = "com.flyingh.sharedpreferences.MainActivity";
	private EditText nameText;
	private EditText ageText;
	private PreferenceService preferenceService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		nameText = (EditText) findViewById(R.id.name);
		ageText = (EditText) findViewById(R.id.age);
		preferenceService = new PreferenceServiceImpl(getApplicationContext());
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> map = (Map<String, Object>) preferenceService.read();
			if (map != null && map.size() > 0) {
				nameText.setText(String.valueOf(map.get("name")));
				ageText.setText(String.valueOf(map.get("age")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save(View view) {
		try {
			preferenceService.save(nameText.getText().toString(),
					Integer.valueOf(ageText.getText().toString()));
			Toast.makeText(getApplicationContext(), R.string.save_success,
					Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), R.string.save_failure,
					Toast.LENGTH_LONG).show();
			Log.e(TAG, e.getMessage());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
