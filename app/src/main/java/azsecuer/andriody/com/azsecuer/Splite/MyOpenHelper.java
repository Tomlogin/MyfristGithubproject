package azsecuer.andriody.com.azsecuer.Splite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 8/10 0010.
 */
public class MyOpenHelper extends SQLiteOpenHelper {

    public MyOpenHelper(Context context, String name,int version) {
        super(context, name, null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("create table user(id integer primary key autoincrement," +
              "name varchar(200)," +
              "pass varchar(200))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
