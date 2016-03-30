package com.thereversenotation.splashscreen;

/**
 * Created by bryan on 14/11/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "userDB.db";
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASS = "pass";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null , " +
            "username text not null, pass text not null);";


    public MyDBHandler(Context context)  {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void addUser(Storage u) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, u.getID());
        values.put(COLUMN_USERNAME, u.getUserName());
        values.put(COLUMN_PASS, u.getPass());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_USERS, null, values);
        db.close();



       /* db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from storage";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_USERNAME, u.getUserName());
        values.put(COLUMN_PASS, u.getPass());

        db.insert(TABLE_USERS, null, values);
        db.close(); */
    }

    public String searchPass(String username) {
        db = this.getReadableDatabase();
        String query = "Select username, pass from " + TABLE_USERS;
        Cursor cursor = db.rawQuery(query, null);
         String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);

                if (a.equals(username)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
            }
            return b;
        }

   /*         cursor.moveToFirst();
            user.setID(Integer.parseInt(cursor.getString(0)));
            user.setUserName(cursor.getString(1));
            user.setPass(cursor.getString(2));
            cursor.close();
        } else {
            user = null;
        }
        db.close();
        return user;
    } */



   /* public boolean deleteUser(String username) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " =  \"" + username + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Storage user = new Storage();

        if (cursor.moveToFirst()) {
            user.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_USERS, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(user.getID()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    } */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        this.onCreate(db);
    }
}