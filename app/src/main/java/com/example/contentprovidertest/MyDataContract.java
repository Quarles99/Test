package com.example.contentprovidertest;

import android.provider.BaseColumns;

public class MyDataContract {
    public static final class MyDataEntry implements BaseColumns {
        public static final String TABLE_NAME = "FunkoPop";
        public static final String POP_NAME = "pop_name";
        public static final String POP_NUMBER = "pop_number";
        public static final String POP_TYPE = "pop_type";
        public static final String FANDOM = "fandom";
        public static final String ON = "on";
        public static final String ULTIMATE = "ultimate";
        public static final String PRICE = "price";
    }
}
