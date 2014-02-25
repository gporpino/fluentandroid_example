package com.example.fluentandroidexample.database;

import java.util.List;

import br.org.cesar.gporpino.fluentandroid.database.FluentSQLiteOpenHelper;
import br.org.cesar.gporpino.fluentandroid.database.Table;
import br.org.cesar.gporpino.fluentandroid.database.Type;

import com.example.fluentandroidexample.FeedReaderContract.FeedEntry;
import com.example.fluentandroidexample.FeedReaderContract.User;

public class FluentFeedReaderDbHelper extends FluentSQLiteOpenHelper {

	
	public FluentFeedReaderDbHelper() {
		super(DATABASE_NAME, DATABASE_VERSION);
	}

	// If you change the database schema, you must increment the database
	// version.
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "FeedReader.db";

	

	@Override
	protected void configureTables(List<Table> tables) {
		tables.add(
				new Table(FeedEntry.TABLE_NAME)
			.addPrimaryKey(FeedEntry._ID, Type.INTEGER)
			.addColumn(FeedEntry.COLUMN_NAME_ENTRY_ID, Type.TEXT)
			.addColumn(FeedEntry.COLUMN_NAME_TITLE, Type.TEXT)
			.addColumn(FeedEntry.COLUMN_NAME_SUBTITLE, Type.TEXT)
		);
		
		tables.add(
				new Table(User.TABLE_NAME)
			.addPrimaryKey(User._ID, Type.INTEGER)
			.addColumn(User.COLUMN_USER_NAME, Type.TEXT)
			.addColumn(User.COLUMN_FULL_NAME, Type.TEXT)
		);
		
	}

	
}