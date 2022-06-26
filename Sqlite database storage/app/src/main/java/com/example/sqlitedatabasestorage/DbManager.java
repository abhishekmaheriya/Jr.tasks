package com.example.sqlitedatabasestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbManager extends SQLiteOpenHelper {
    public static final String dbname = "StudentDesc.db";
    public static final String tablename = "tbl_student";
    public DbManager(@Nullable Context context) {
        super(context, dbname, null, 1);
    }
    Context context;

    @Override
    public void onCreate(SQLiteDatabase db) {
    String qry = "create table "
        +tablename+" (id integer primary key autoincrement, name text, email text, mobile text)";
    db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+tablename);
        onCreate(db);
    }

    // for insert the data
    public String addRecord(String name, String email, String mobile){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("email", email);
        cv.put("mobile", mobile);

        long res = db.insert(tablename,null,cv);  // it returns the value if our data is inserted or not
        if (res == -1)
        {
            return "Failed";
        }else
        {
            return "Successfully inserted";
        }
    }

    public Cursor getdata(String mobile){
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select * from "+tablename+" where mobile="+mobile;
        Cursor crs = db.rawQuery(qry,null);

        return crs;

    }
}
