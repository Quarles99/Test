package com.example.contentprovidertest;

import android.net.Uri;

public class MyContentProviderContract {
    public static final String AUTHORITY = "com.example.myapp.provider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static final String PATH_MY_DATA = "my-data";

    public static final Uri CONTENT_URI_MY_DATA = BASE_CONTENT_URI.buildUpon()
            .appendPath(PATH_MY_DATA)
            .build();
}
