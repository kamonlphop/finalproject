package comsci.kamonlphop.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 4/5/2560.
 */

class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private final String TAG = getClass().getSimpleName();
    private SQLiteDatabase sqLiteDatabase;


    public static final String DataBase_Name = "Ebookcomscitest6.db";
    public static final int DataBase_Version = 1;

    public static final String TABLE = "Student";
    public static final String ID_STUDENT = BaseColumns._ID;
    public static final String NAME_STUDENT = "Name";
    public static final String LASTNAME_STUDENT = "Lastname";
    public static final String PASSWOD_STUDENT ="Password";
    public static final String EMAIL_STUDENT = "Email";
    public String CREATE_STUDENT ="create table "+TABLE+" ("+ID_STUDENT+" integer primary key autoincrement, "+NAME_STUDENT+" text, "+LASTNAME_STUDENT+" text, "+PASSWOD_STUDENT+" text, "+EMAIL_STUDENT+" text);";

    public static final String TABLE_B = "Teacher";
    public static final String ID_TEACHER = BaseColumns._ID;
    public static final String NAME_TEACHER= "Name";
    public static final String LASTNAME_TEACHER = "Lastname";
    public static final String PASSWOD_TEACHER ="Password";
    public static final String EMAIL_TEACHER= "Email";
    public String CREATE_TEACHER ="create table "+TABLE_B+" ("+ID_TEACHER+" integer primary key autoincrement, "+NAME_TEACHER+" text, "+LASTNAME_TEACHER+" text, "+PASSWOD_TEACHER+" text, "+EMAIL_TEACHER+" text);";

    public static final String TABLE_C = "Admin";
    public static final String ID_ADMIN = BaseColumns._ID;
    public static final String NAME_ADMIN= "Name";
    public static final String LASTNAME_ADMIN = "Lastname";
    public static final String PASSWOD_ADMIN="Password";
    public static final String EMAIL_ADMIN= "Email";
    public String CREATE_ADMIN ="create table "+TABLE_C+" ("+ID_ADMIN+" integer primary key autoincrement, "+NAME_ADMIN+" text, "+LASTNAME_ADMIN+" text, "+PASSWOD_ADMIN+" text, "+EMAIL_ADMIN+" text);";

    public static final String TABLE_D = "Ebook";
    public static final String ID_EBOOK = BaseColumns._ID;
    public static final String NAME_EBOOK= "Name";
    public static final String MAJOR_EBOOK = "Majorbook";
    public String CREATE_EBOOK ="create table "+TABLE_D+" ("+ID_EBOOK+" integer primary key autoincrement, "+NAME_EBOOK+" text, "+MAJOR_EBOOK+" text,"+ID_TEACHER+"integer);";
/*
    public static final String TABLE_E = "Statistics";
    public static final String QTV = BaseColumns._ID;
    public static final String DATETIME= "dateandtime";
    public String CREATE_STATISTICS ="create table "+TABLE_E+" ("+QTV+" integer primary key autoincrement, "+ID_EBOOK+" integer, "+ID_STUDENT+" integer,"+DATETIME+"text);";
*/

    public MySQLiteOpenHelper(Context context) {
        super(context, DataBase_Name, null, DataBase_Version);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i(TAG, CREATE_STUDENT);
        Log.i(TAG, CREATE_TEACHER);
        Log.i(TAG, CREATE_ADMIN);
        Log.i(TAG, CREATE_EBOOK);
        //    Log.i(TAG, CREATE_STATISTICS);

        db.execSQL(CREATE_STUDENT);
        db.execSQL(CREATE_TEACHER);
        db.execSQL(CREATE_ADMIN);
        db.execSQL(CREATE_EBOOK);
        //   db.execSQL(CREATE_STATISTICS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // copy เค้ามา อย่าสงสับ
        String DROP_FRIEND_TABLE = "DROP TABLE IF EXISTS " + TABLE;

        db.execSQL(DROP_FRIEND_TABLE);

        Log.i(TAG, "Upgrade Database from " + oldVersion + " to " + newVersion);

        onCreate(db);
    }
    //ยังติดปัญหาเรื่อง method
    public List<String> getFriendList() {
        List<String> ALLUSER = new ArrayList<String>();

        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query
                (TABLE, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        while(!cursor.isAfterLast()) {

            ALLUSER.add(cursor.getLong(0) + " " +
                    cursor.getString(1) + " " +
                    cursor.getString(2));

            cursor.moveToNext();
        }

        sqLiteDatabase.close();

        return ALLUSER;
    }
    //
}

