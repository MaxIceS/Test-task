package com.example.maxices;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_pass extends Activity implements OnClickListener {

	final String LOG_TAG = "myLogs";
	private EditText etTextPass, etTextlogin;
	private Button btnOk, btnReg;
	private final static String FILENAME = "sample.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.pass);

		btnOk = (Button) findViewById(R.id.btnOk);
		btnReg = (Button) findViewById(R.id.btnReg);

		etTextPass = (EditText) findViewById(R.id.etTextPass);
		etTextlogin = (EditText) findViewById(R.id.etTextlogin);

		btnOk.setOnClickListener(this);
		btnReg.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.btnOk:
			openFile();
			break;
		case R.id.btnReg:
			intent = new Intent(this, Registration.class);
			startActivity(intent);
			break;
		}
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();

		etTextPass.setText("");
		etTextlogin.setText("");
	}

	// Метод для открытия файла
	private void openFile() {
		try {
			InputStream inputstream = openFileInput(FILENAME);

			if (inputstream != null) {
				InputStreamReader isr = new InputStreamReader(inputstream);
				BufferedReader reader = new BufferedReader(isr);
				String str;
				String expectedLoginAndPass = etTextlogin.getText().toString()
						+ " " + etTextPass.getText().toString();

				while ((str = reader.readLine()) != null) {
					if (str.equals(expectedLoginAndPass)) {
						Intent intent;
						intent = new Intent(this, WebKitActivity.class);
						startActivity(intent);
					} else {
						Toast.makeText(Login_pass.this,
								"Неправильный логин или пароль \n или Вы не зарегистрированны", Toast.LENGTH_SHORT)
								.show();
					}
				}

				inputstream.close();
			}
		} catch (Throwable t) {
			Toast.makeText(getApplicationContext(),
					"Exception: " + t.toString(), Toast.LENGTH_LONG).show();
		}
	}

}
