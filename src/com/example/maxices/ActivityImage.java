package com.example.maxices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

public class ActivityImage extends Activity {

	private static final int REQUEST_LOAD = 1;

	private ImageViewer imageViewer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		imageViewer = new ImageViewer(this);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		startActivityForResult(new Intent(getBaseContext(), FileDialog.class),
				REQUEST_LOAD);
	}

	@Override
	public synchronized void onActivityResult(final int requestCode,
			int resultCode, final Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			if (requestCode == REQUEST_LOAD) {
				String filePath = data.getStringExtra(FileDialog.RESULT_PATH);

				try {
					imageViewer.loadImage(filePath);
				} catch (Exception e) {
					Toast.makeText(
							getApplicationContext(),
							String.format(
									"Failed to load image. Exception: %1$s",
									e.getMessage()), Toast.LENGTH_SHORT).show();
					startActivityForResult(new Intent(getBaseContext(),
							FileDialog.class), REQUEST_LOAD);
					return;
				} catch (OutOfMemoryError e2) {
					Toast.makeText(getApplicationContext(),
							"Failed to load image. Error: not enough memory",
							Toast.LENGTH_SHORT).show();
					startActivityForResult(new Intent(getBaseContext(),
							FileDialog.class), REQUEST_LOAD);
					return;
				}

				setContentView(imageViewer);
			}
		} else if (resultCode == Activity.RESULT_CANCELED) {
			finish();
		}
	}
}
