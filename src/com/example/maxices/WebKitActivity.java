package com.example.maxices;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebKitActivity extends Activity {

	private WebView myBrowser;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web);

		myBrowser = (WebView) findViewById(R.id.browser);

		myBrowser.getSettings().setJavaScriptEnabled(true);

		String url = ("http://pogoda.tut.by");
		myBrowser.loadUrl(url);

		new ReloadWebView(this, 60, myBrowser);
	}

}