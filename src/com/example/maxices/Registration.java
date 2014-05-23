package com.example.maxices;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends Activity {

	Button btnOKR;
	private EditText edTextLoginR, edTextPassR;

	final String LOG_TAG = "myLogs";
	private final static String FILENAME = "sample.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);

		btnOKR = (Button) findViewById(R.id.btnOKR);

		edTextLoginR = (EditText) findViewById(R.id.edTextLoginR);
		edTextPassR = (EditText) findViewById(R.id.edTextPassR);

		btnOKR.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent;
				switch (v.getId()) {
				case R.id.btnOKR:
					saveFile();
					intent = new Intent(Registration.this, Login_pass.class);
					startActivity(intent);
					break;
				}
			}
		});

	}

	// Метод для сохранения файла
	private void saveFile() {
		try {
			OutputStream outputstream = openFileOutput(FILENAME, 0);
			OutputStreamWriter osw = new OutputStreamWriter(outputstream);
			osw.write(edTextLoginR.getText().toString() + " "
					+ edTextPassR.getText().toString());
			osw.close();
		} catch (Throwable t) {
			Toast.makeText(getApplicationContext(),
					"Exception: " + t.toString(), Toast.LENGTH_LONG).show();
		}
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();

		edTextLoginR.setText("");
		edTextPassR.setText("");
	}

}
