package azsecuer.andriody.com.azsecuer.activity;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.Splite.MyOpenHelper;

public class Phonecheck extends AppCompatActivity {
    private ListView listView;
  private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonecheck);
        myOpenHelper=new MyOpenHelper(this,"user.db",1);//创建一个数据库（上下文对象，文件名，版本号）
        sqLiteDatabase=myOpenHelper.getWritableDatabase();//获取数据的database
        //写入一行数据
        String insertsql="insert info user(name pwd) values('tym','123')";
        sqLiteDatabase.execSQL(insertsql);
        String insertsql1="insert info user(name pwd) values('bbb','147')";
        sqLiteDatabase.execSQL(insertsql);
        //更新（修改）一条数据
        String updataspl="updata user set name=aaa,pwd=321 where id=2";
        sqLiteDatabase.execSQL(updataspl);
        //删除一条数据
        String deletesql="delete form user where id=2";
        sqLiteDatabase.execSQL(deletesql);
        //查询
        String selectSQL="select * form user where name=?";
        Cursor cursor=sqLiteDatabase.rawQuery(selectSQL,new String[]{"1"});
        if(cursor.moveToNext()){
            cursor.moveToFirst();
            int columnindex = cursor.getColumnIndex("tym");//获取tym的下标
            String username = cursor.getString(columnindex);//通过此方法将下标对应的消息转成String类

            Log.i("---->",username);//打印
        }else{
            Log.i("---->","没有");
        }
        sqLiteDatabase.close();//关闭

    }
}
