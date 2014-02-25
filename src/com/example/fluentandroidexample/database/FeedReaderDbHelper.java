package com.example.fluentandroidexample.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import br.org.cesar.gporpino.fluentandroid.database.Table;
import br.org.cesar.gporpino.fluentandroid.database.Type;

import com.example.fluentandroidexample.FeedReaderContract.FeedEntry;

public class FeedReaderDbHelper extends SQLiteOpenHelper {

	private static final Table SQL_CREATE_ENTRIES_FLUENT = new Table(FeedEntry.TABLE_NAME)
			.addPrimaryKey(FeedEntry._ID, Type.INTEGER)
			.addColumn(FeedEntry.COLUMN_NAME_ENTRY_ID, Type.TEXT)
			.addColumn(FeedEntry.COLUMN_NAME_TITLE, Type.TEXT);


	
	// If you change the database schema, you must increment the database
	// version.
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "FeedReader.db";

	public FeedReaderDbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_ENTRIES_FLUENT.creationScript());
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL(SQL_CREATE_ENTRIES_FLUENT.deletionScript());
		onCreate(db);
	}

	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onUpgrade(db, oldVersion, newVersion);
	}
}