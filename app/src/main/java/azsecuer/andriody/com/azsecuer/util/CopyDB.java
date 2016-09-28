package azsecuer.andriody.com.azsecuer.util;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 8/11 0011.
 */
public class CopyDB {
    public static void copy(Context context,String comdb,File tofile)throws IOException{
        //获取输入流
        InputStream inputStream=context.getResources().getAssets().open(comdb);
        byte[] data=new byte[1024];//创建缓冲区
        int len=0;
        //加缓冲流
        BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
        //创建文件输出流到文件tofile
        FileOutputStream fileOutputStream=new FileOutputStream(tofile);
        //增加缓冲输出了流
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
        //读取数据
        while((len=bufferedInputStream.read(data))!=-1){
            bufferedOutputStream.write(data,0,len);
        }
        //刷新，保证读取完
        bufferedOutputStream.flush();
        bufferedInputStream.close();
        bufferedOutputStream.close();
        inputStream.close();
        fileOutputStream.close();



    }
}
