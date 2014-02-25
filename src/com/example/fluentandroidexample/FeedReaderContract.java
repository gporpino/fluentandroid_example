package com.example.fluentandroidexample;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
    
    public static abstract class User implements BaseColumns {
        public static final String TABLE_NAME = "user";
        
        public static final String COLUMN_USER_NAME = "username";
        public static final String COLUMN_FULL_NAME = "fullname";
    }
}
