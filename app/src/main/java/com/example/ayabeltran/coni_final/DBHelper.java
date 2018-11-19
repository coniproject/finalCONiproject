package com.example.ayabeltran.coni_final;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dbconi.db";
    public static final String TABLE_NAME = "tblguardian";
    public static final String col1 = "userID";
    public static final String col2 = "lname";
    public static final String col3= "fname";
    public static final String col4 = "mi";
    public static final String col5 = "birthday";
    public static final String col6 = "age";
    public static final String col7 = "gender";
    public static final String col8 = "email";
    public static final String col9 = "cnumber";
    public static final String TABLE_NAME2 = "tblfamily";
    public static final String tcol1 = "famid";
    public static final String tcol2 = "lname";
    public static final String tcol3= "fname";
    public static final String tcol4 = "mi";
    public static final String tcol5 = "birthday";
    public static final String tcol6 = "age";
    public static final String tcol7 = "gender";
    public static final String TABLE_NAME3 = "tbluser";
    public static final String t3col1 = "username";
    public static final String t3col2 = "password";

//    private SQLiteDatabase mWriteableDb;

    public DBHelper(Context context) {
        //creates the database//
        super(context, DATABASE_NAME, null, 4);
//        mWriteableDb = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (userID INTEGER PRIMARY KEY AUTOINCREMENT Unique," +
                "lname varchar not null," +
                "fname varchar not null," +
                "mi varchar not null," +
                "birthday date not null," +
                "age integer not null, " +
                "gender varchar not null, " +
                "email varchar not null," +
                "cnumber integer not null)");
//        db.execSQL("create table " +TABLE_NAME+ " ( " +
//                ""+col1+" INTEGER primary key autoincrement unique, "
//                +col2+" VARCHAR not null, "
//                +col3+" VARCHAR not null, "
//                +col4+" VARCHAR not null, "
//                +col5+" DATE not null, "
//                +col6+" INTEGER not null, "
//                +col7+" VARCHAR not null, "
//                +col8+" VARCHAR not null, "
//                +col9+" INTEGER not null)");

        db.execSQL("create table " +TABLE_NAME2+ " ( " +
                ""+tcol1+" integer primary key autoincrement unique, "
                +tcol2+" varchar not null, "
                +tcol3+" varchar not null, "
                +tcol4+" varchar not null, "
                +tcol5+" DATE not null, "
                +tcol6+" integer not null, "
                +tcol7+" varchar not null)");

        db.execSQL("create table "+ TABLE_NAME3 +" ( " +
                ""+t3col1+" varchar not null, "
                +t3col2+" varchar not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists "+TABLE_NAME);
        db.execSQL("drop table if exists " + TABLE_NAME2);
        db.execSQL("drop table if exists " + TABLE_NAME3);
        onCreate(db);
    }

    //code that insert
    public boolean addguardian(String lname, String fname, String mi, String birthday, String age , String gender, String email, String cnumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, lname);
        contentValues.put(col3, fname);
        contentValues.put(col4, mi);
        contentValues.put(col5, birthday);
        contentValues.put(col6, age);
        contentValues.put(col7, gender);
        contentValues.put(col8, email);
        contentValues.put(col9, cnumber);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public boolean addfamily(String lname, String fname, String mi, String birthday, String age, String gender) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(tcol2, lname);
        contentValues.put(tcol3, fname);
        contentValues.put(tcol4, mi);
        contentValues.put(tcol5, birthday);
        contentValues.put(tcol6, age);
        contentValues.put(tcol7, gender);
        long result = db.insert(TABLE_NAME2, null, contentValues);
        return result != -1;
    }

    public boolean adduser(String password, String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(t3col1, username);
        contentValues.put(t3col2, password);
        long result = db.insert(TABLE_NAME3, null, contentValues);
        return result != -1;
    }

    public boolean addguardian(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, person.getLname());
        contentValues.put(col3, person.getFname());
        contentValues.put(col4, person.getMi());
        contentValues.put(col5, person.getBirthday());
        contentValues.put(col6, person.getAge());
        contentValues.put(col7, person.getGender());
        contentValues.put(col8, person.getEmail());
        contentValues.put(col9, person.getCnumber());
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public boolean addfamily(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(tcol2, person.getLname());
        contentValues.put(tcol3, person.getFname());
        contentValues.put(tcol4, person.getMi());
        contentValues.put(tcol5, person.getBirthday());
        contentValues.put(tcol6, person.getAge());
        contentValues.put(tcol7, person.getGender());
        long result = db.insert(TABLE_NAME2, null, contentValues);
        return result != -1;
    }

    public boolean adduser(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(t3col1, person.getUsername());
        contentValues.put(t3col2, person.getPassword());
        long result = db.insert(TABLE_NAME3, null, contentValues);
        return result != -1;
    }
    //search for match uname and pass
    public Cursor userlogin(String user, String pword, SQLiteDatabase db){
        String query = "select * from login where username = '"+user+"' and password = '"+pword+"'";
        Log.d("query", query);
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

}
