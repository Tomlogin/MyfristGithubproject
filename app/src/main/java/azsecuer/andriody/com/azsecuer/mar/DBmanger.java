package azsecuer.andriody.com.azsecuer.mar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import azsecuer.andriody.com.azsecuer.Splite.phonenumber;
import azsecuer.andriody.com.azsecuer.Splite.phonetypedemo;
import azsecuer.andriody.com.azsecuer.util.Logutil;

/**
 * Created by Administrator on 8/11 0011.
 */
public class DBmanger {
    public static File file;
//获取电话类型数据
    public static List<phonetypedemo> readclasslist(){
        List<phonetypedemo> list=new ArrayList<phonetypedemo>() ;
        SQLiteDatabase sqLiteDatabase=SQLiteDatabase.openOrCreateDatabase(file,null);
        Cursor cursor = sqLiteDatabase.rawQuery("select * from classlist",null);//执行查询
        if(cursor.moveToFirst()){
            do{
                String n=cursor.getString(cursor.getColumnIndex("name"));
                int idx=cursor.getInt(cursor.getColumnIndex("idx"));
                phonetypedemo phonetypedemo=new phonetypedemo(n,idx);
                list.add(phonetypedemo);
            }while(cursor.moveToNext());

        }else{
            Log.i("DBManager--TableClass","没有数据");
        }

        return  list;
    }

    // 获取电话分类下的电话信息
    public static List<phonenumber> readTabelNumber(Integer idx) {
        List<phonenumber> list=new ArrayList<>() ;
        SQLiteDatabase sqLiteDatabase=SQLiteDatabase.openOrCreateDatabase(file,null);
        Log.i("------>",file.getPath()+":"+file.length());
        Cursor cursor=sqLiteDatabase.rawQuery("select * from table"+idx,null);
        if(cursor.moveToFirst()){
            do{
                String n=cursor.getString(cursor.getColumnIndex("name"));
                String number=cursor.getString(cursor.getColumnIndex("number"));
                phonenumber phonenumber=new phonenumber(n,number);
                list.add(phonenumber);
            }while(cursor.moveToNext());
        }else{
            Log.i("DBManager--TableClass","没有数据");
        }

        return  list ;
    }
//
    //初始化数据
    public static  void initdatabase(Context context)throws IOException {
        File file=new File("data/data/"+context.getPackageName()+"/db");
        boolean ok1  = file.mkdirs();
        Logutil.p("Test","-- createDirs"+ok1);
        DBmanger.file = new File(file,"commonnum.db");
        //boolean ok = file.createNewFile();
       // Logutil.p("Test","-- create"+ok);
    }
}
