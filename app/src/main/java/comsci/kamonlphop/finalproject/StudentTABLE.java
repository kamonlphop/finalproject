package comsci.kamonlphop.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by USER on 4/5/2560.
 */

public class StudentTABLE {

    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String TABLE= "Student";
    public static final String ID_STUDENT = "_ID";
    public static final String NAME_STUDENT= "Name";
    public static final String LASTNAME_STUDENT = "Lastname";
    public static final String PASSWOD_STUDENT="Password";
    public static final String EMAIL_STUDENT= "Email";


    public StudentTABLE(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }//constructor

    public String[] searchUserpassword(String usernameString){
        try{
            String[] strResult = null;
            Cursor objCursor = readSqLiteDatabase.query(TABLE ,
                    new String[]{ID_STUDENT,NAME_STUDENT,LASTNAME_STUDENT,PASSWOD_STUDENT,EMAIL_STUDENT},
                    NAME_STUDENT +"=?"
                    ,new String[]{String.valueOf(usernameString)},
                    null,null,null,null);
            if (objCursor !=null){
                if (objCursor.moveToFirst()){
                    strResult = new String[5];
                    strResult[0] = objCursor.getString(0);
                    strResult[1] = objCursor.getString(1);
                    strResult[2] = objCursor.getString(2);
                    strResult[3] = objCursor.getString(3);
                    strResult[4] = objCursor.getString(4);
                }
            }
            objCursor.close();
            return strResult;
        }catch (Exception e){
            return null;

        }
        // return new String[0];

    }//end searchUserpassword

    public long addNewstudent(String strName, String strLastname, String strPassword, String strEmail){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(NAME_STUDENT,strName);
        objContentValues.put(LASTNAME_STUDENT,strLastname);
        objContentValues.put(PASSWOD_STUDENT,strPassword);
        objContentValues.put(EMAIL_STUDENT,strEmail);
        return readSqLiteDatabase.insert(TABLE,null,objContentValues);

    }//end add student
}//endstudent

