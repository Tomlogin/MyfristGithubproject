package azsecuer.andriody.com.azsecuer.mar;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.Splite.Clear_item;
import azsecuer.andriody.com.azsecuer.util.FileUtils;
import azsecuer.andriody.com.azsecuer.util.Logutil;
import azsecuer.andriody.com.azsecuer.util.PublicUtils;

/**
 * Created by Administrator on 8/17 0017.
 */
public class ClearDBManger {
    public static File file;
    //初始化数据
    public static  void initdata(Context context)throws IOException {
        File file=new File("data/data/"+context.getPackageName()+"/db");
        boolean ok1  = file.mkdirs();
        Logutil.p("Test","-- createDirs"+ok1);
       ClearDBManger.file = new File(file,"clearpath1.db");

    }
    //获取数据
    public static List<Clear_item> readapkname(Context context){
        List<Clear_item> list=new ArrayList<Clear_item>() ;
        SQLiteDatabase sqLiteDatabase=SQLiteDatabase.openOrCreateDatabase(file,null);
        Cursor cursor = sqLiteDatabase.rawQuery("select * from softdetail",null);//执行查询
        Log.i("------","cursor"+cursor.getCount());
        if(cursor.moveToFirst()) do {
            String softChineseName = cursor.getString(cursor.getColumnIndex("softChinesename"));
            String softEnglishName = cursor.getString(cursor.getColumnIndex("softEnglishname"));
            String filepath = cursor.getString(cursor.getColumnIndex("filepath"));
            String softapkname = cursor.getString(cursor.getColumnIndex("apkname"));
            //拼接完整路劲并生成新的文件路劲cachfile
            File cachFile = new File(Environment.getExternalStorageDirectory() + filepath);

            Drawable drawable = null;
            try {
                drawable = context.getPackageManager().getApplicationIcon(softapkname);
            } catch (PackageManager.NameNotFoundException e) {
                drawable=context.getResources().getDrawable(R.drawable.ic_launcher);
                e.printStackTrace();
            }

            if(cachFile.exists()){
                long size = FileUtils.getFileLength(cachFile);
                //将size改成有单位的长度
                String filesize= PublicUtils.formatSize(size);
                Clear_item item = new Clear_item(softChineseName,softEnglishName, filepath,softapkname,false, drawable,filesize);
            list.add(item);}
        } while (cursor.moveToNext());
        else{
            Log.i("ClearDB---softdetail","没有数据");
        }

        return  list;
    }


}
