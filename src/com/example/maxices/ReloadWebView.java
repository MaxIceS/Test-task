package com.example.maxices;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.webkit.WebView;

public class ReloadWebView extends TimerTask {
	Activity context;
	Timer timer;
	WebView myBrowser;

	public ReloadWebView(Activity context, int seconds, WebView myBrowser) {
		this.context = context;
		this.myBrowser = myBrowser;

		timer = new Timer();
		timer.schedule(this, seconds * 1000, seconds * 1000);
	}

	@Override
	public void run() {
		if (context == null || context.isFinishing()) {
			this.cancel();
			return;
		}

		context.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				myBrowser.reload();
			}
		});
	}

}
