package comsci.kamonlphop.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by USER on 19/9/2560.
 */

public class LessonTABLE {
    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase , readSqLiteDatabase;

    public static final String TABLE_D = "Lessonbook";
    public static final String ID_Lesson = "id_lesson";
    public static final String NAME_Lesson= "name_lesson";
    public static final String ID_EBOOK = "id_ebook";
    public static final String FileBook = "filebook";

    public LessonTABLE(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addlessonnewmember (String strIDlesson , String strnamelesson,String strIDEbook , String strfilelessbook){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(objMySQLiteOpenHelper.ID_Lesson,strIDlesson);
        objContentValues.put(objMySQLiteOpenHelper.NAME_Lesson,strnamelesson);
        objContentValues.put(objMySQLiteOpenHelper.ID_EBOOK,strIDEbook);
        objContentValues.put(objMySQLiteOpenHelper.FileBook,strfilelessbook);
        return readSqLiteDatabase.insert(objMySQLiteOpenHelper.TABLE_D,null,objContentValues);

    }
    public String[] searchteacherpassword(String usernameString){
        try{
            String[] strResult = null;
            Cursor objCursor = readSqLiteDatabase.query(TABLE_D ,
                    new String[]{ID_Lesson,NAME_Lesson,ID_EBOOK,FileBook},
                    NAME_Lesson +"=?",new String[]{String.valueOf(usernameString)},
                    null,null,null,null);
            if (objCursor !=null){
                if (objCursor.moveToFirst()){
                    strResult = new String[4];
                    for(int i = 0;i<4;i++ ){
                        strResult[i] = objCursor.getString(i);
                    }
                }
            }
            objCursor.close();
            return strResult;
        }catch (Exception e){
            return null;

        }
        // return new String[0];

    }//end searchUserpassword
}
