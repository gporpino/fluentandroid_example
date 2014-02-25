package com.example.fluentandroidexample;

import com.example.fluentandroidexample.database.FluentFeedReaderDbHelper;

import android.app.Application;
import br.org.cesar.gporpino.fluentandroid.FluentAndroid;

public class ExampleApplication  extends Application{

	@Override
	public void onCreate() {
		super.onCreate();
		FluentAndroid.getInstance().init(this).configureDatabase(new FluentFeedReaderDbHelper());
	}
}
