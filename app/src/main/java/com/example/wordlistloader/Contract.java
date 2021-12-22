package com.example.wordlistloader;

import android.net.Uri;
import android.provider.BaseColumns;

public final class Contract {

    private static final String TAG = Contract.class.getSimpleName();

    // Prevent class from being instantiated.
    private Contract() {}

    public static final int ALL_ITEMS = -2;
    public static final String COUNT = "count";

    public static final String AUTHORITY =
            "com.android.example.wordlistsqlwithcontentprovider.provider";

    // Only one public table.
    public static final String CONTENT_PATH = "words";

    // Content URI for this table. Returns all items.
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH);

    // URI to get the number of entries.
    public static final Uri ROW_COUNT_URI =
            Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH + "/" + COUNT);

    static final String SINGLE_RECORD_MIME_TYPE =
            "vnd.android.cursor.item/vnd.com.example.provider.words";
    static final String MULTIPLE_RECORDS_MIME_TYPE =
            "vnd.android.cursor.item/vnd.com.example.provider.words";

    /*
     * Constants for the database are moved out of WordListOpenHelper into the contract.
     * A common way to organize a contract class is to put definitions that are global to your
     * database in the root level of the class. Then create an inner class for each table
     * that enumerates its columns.
     */

    public static final String DATABASE_NAME = "wordlist";

    /**
     * Inner class that defines the table contents
     *
     * By implementing the BaseColumns interface, your inner class can inherit a primary
     * key field called _ID that some Android classes such as cursor adaptors will expect it to
     * have. It's not required, but this can help your database work harmoniously with the
     * Android framework.
     */
    public static abstract class WordList implements BaseColumns {

        // Table
        public static final String WORD_LIST_TABLE = "word_entries";

        // Column names
        public static final String KEY_ID = "_id";
        public static final String KEY_WORD = "word";
    }

}
