package com.example.fluentandroidexample.database;

import java.util.List;

import br.org.cesar.gporpino.fluentandroid.database.FluentSQLiteOpenHelper;
import br.org.cesar.gporpino.fluentandroid.database.config.Constraint;
import br.org.cesar.gporpino.fluentandroid.database.config.Table;
import br.org.cesar.gporpino.fluentandroid.database.config.Type;

import com.example.fluentandroidexample.FeedReaderContract.FeedEntry;
import com.example.fluentandroidexample.FeedReaderContract.User;

public class FluentFeedReaderDbHelper extends FluentSQLiteOpenHelper {

	public static final int DATABASE_VERSION = 2;
	public static final String DATABASE_NAME = "FeedReader.db";

	public FluentFeedReaderDbHelper() {
		super(DATABASE_NAME, DATABASE_VERSION);
	}

	@Override
	protected void setupTables(List<Table> tables) {
		tables.add(new Table(FeedEntry.TABLE_NAME)
				.addColumn(FeedEntry._ID, Type.INTEGER, 
						Constraint.NOT_NULL, Constraint.AUTO_INCREMENT, Constraint.PRIMARY_KEY)
				.addColumn(FeedEntry.COLUMN_NAME_ENTRY_ID, Type.TEXT)
				.addColumn(FeedEntry.COLUMN_NAME_TITLE, Type.TEXT)
				.addColumn(FeedEntry.COLUMN_NAME_SUBTITLE, Type.TEXT));

		tables.add(new Table(User.TABLE_NAME)
				.addColumn(User._ID, Type.INTEGER, Constraint.PRIMARY_KEY,
						Constraint.NOT_NULL)
				.addColumn(User.COLUMN_USER_NAME, Type.TEXT)
				.addColumn(User.COLUMN_FULL_NAME, Type.TEXT));
	}
}