package com.example.fluentandroidexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import br.org.cesar.gporpino.fluentandroid.database.CursorLine;
import br.org.cesar.gporpino.fluentandroid.database.FluentCursor;
import br.org.cesar.gporpino.fluentandroid.direct.Insert;
import br.org.cesar.gporpino.fluentandroid.direct.Select;

import com.example.fluentandroidexample.FeedReaderContract.FeedEntry;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		int count = new Select("COUNT(*)").from(FeedEntry.TABLE_NAME).execute().getCursor().getInt(0);
		
		new Insert().into(FeedEntry.TABLE_NAME)
			.value(FeedEntry.COLUMN_NAME_ENTRY_ID, count)
			.value(FeedEntry.COLUMN_NAME_TITLE, "Teste Porpino "+ (count + 1)).execute();
		
		
		
		FluentCursor cursor = new Select(FeedEntry.COLUMN_NAME_TITLE, FeedEntry.COLUMN_NAME_SUBTITLE).from(FeedEntry.TABLE_NAME)
				.execute();
		
		
		if (cursor != null){
			StringBuilder sb = new StringBuilder();
			for (CursorLine line : cursor) {
				sb.append(line.getString(FeedEntry.COLUMN_NAME_TITLE));
			}
			TextView text = (TextView)findViewById(R.id.text);
			
			text.setText(sb.toString());
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
