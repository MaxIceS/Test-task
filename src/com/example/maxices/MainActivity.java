package com.example.maxices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button btnScreen1, btnScreen2, btnScreen3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btnScreen1 = (Button) findViewById(R.id.btnScreen1);
		btnScreen2 = (Button) findViewById(R.id.btnScreen2);
		btnScreen3 = (Button) findViewById(R.id.btnScreen3);

		btnScreen1.setOnClickListener(this);
		btnScreen2.setOnClickListener(this);
		btnScreen3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;

		switch (v.getId()) {
		case R.id.btnScreen1:
			intent = new Intent(this, Login_pass.class);
			startActivity(intent);
			break;
		case R.id.btnScreen2:
			intent = new Intent(this, WebKitActivity.class);
			startActivity(intent);
			break;
		case R.id.btnScreen3:
			intent = new Intent(this, ActivityImage.class);
			startActivity(intent);
			break;

		}

	}

}
