package com.example.systemgms.db;

//package com.learnandroid.loginsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.systemgms.model.Bookings;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";
    public static final String bookings_COLUMN_NAME = "bookings";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT,usertype TEXT)");

        MyDB.execSQL("create Table events(eventID INTEGER primary key AUTOINCREMENT, name TEXT,  time TEXT)");

        MyDB.execSQL("create Table bookings(bookingsID INTEGER primary key AUTOINCREMENT, username TEXT, event TEXT ,status TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String usertype, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("usertype", usertype);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean insertevent(String eventID, String name, String time) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put("eventID", eventID);
        contentValues.put("name", name);
        contentValues.put("time", time);
        long result = MyDB.insert("events", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean insertBooking(String bookingsID, String username, String event) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put("bookingsID", bookingsID);
        contentValues.put("username", username);
        contentValues.put("event", event);
        contentValues.put("status", "1");
        long result = MyDB.insert("bookings", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }
    public boolean updateBookings ( String status,String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", status);

        db.update("bookings", contentValues, "bookingsID = ? ", new String[] {ID} );
        return true;
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("contacts",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    //returns an array of Type Bookings
    public ArrayList<Bookings> getAllBookings() {
        ArrayList<Bookings> array_list = new ArrayList<Bookings>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from bookings where status = ?", new String[]{"1"});
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(new Bookings(res.getString(res.getColumnIndex("event")),
                    res.getInt(res.getColumnIndex("bookingsID")),
                    res.getString(res.getColumnIndex("username"))));
            res.moveToNext();
        }
        return array_list;
    }
    //returns an array of Type Bookings
    public ArrayList<Bookings> getBookingByUser(String username) {
        ArrayList<Bookings> array_list = new ArrayList<Bookings>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        //Cursor res = db.rawQuery("select * from bookings", null);
       // Cursor res = db.rawQuery("select * from bookings where username=" + username + "", null);
        Cursor res = db.rawQuery("Select * from bookings where username = ? and status = ?", new String[]{username,"1"});

        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(new Bookings(res.getString(res.getColumnIndex("event")),
                    res.getInt(res.getColumnIndex("bookingsID")),
                    res.getString(res.getColumnIndex("username"))));
            res.moveToNext();
        }
        return array_list;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from bookings where id=" + id + "", null);
        return res;
    }


    public Boolean checkusernamepassword(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[]{username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;


    }

    public ArrayList<String> checkuserDetails(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor res = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[]{username, password});
        ArrayList array_list = new ArrayList<String>();
        if (res.getCount() > 0) {

            res.moveToFirst();

            while (res.isAfterLast() == false) {
                if (array_list.size() < 2) {
                    array_list.add(res.getString(res.getColumnIndex("username")));
                    array_list.add(res.getString(res.getColumnIndex("usertype")));
                }
                res.moveToNext();
            }
        }
        return array_list;
    }
}
