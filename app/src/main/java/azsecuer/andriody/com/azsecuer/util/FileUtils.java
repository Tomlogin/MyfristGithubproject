package azsecuer.andriody.com.azsecuer.util;

import android.util.Log;

import java.io.File;
import java.util.List;

import azsecuer.andriody.com.azsecuer.Splite.Clear_item;

/**
 * Created by Administrator on 8/18 0018.
 */
public class FileUtils {
public static void deletefile(File file){
    if(file!=null&&file.exists()){
        if(file.isFile()){
            file.delete();
        }else if(file.isDirectory()){
            File []files=file.listFiles();
            if(files!=null){
                for (File temp:files) {
                 deletefile(temp);
                }
            }
        }
    }
}
//public static  long getFileSize(File file){
//    long size=0;
//    if(file.exists()){//如果文件不为空
//        if(file.isDirectory()){//如果是个文件夹
//            File []files=file.listFiles();//返回一个文件夹数组
//            for(File temp:files){//遍历还是一个文件夹
//                if(temp.isDirectory()){
//                    return size+=getFileSize(temp);//返回自己
//                }else{
//                    return size+=file.length();
//                }
//            }
//        }else{
//            return size+=file.length();
//        }
//    }
//    return  size;
//}
public static int getFileLength(File file){
    int size = 0;
    if(file.exists()){
        if(file.isFile()){
            size += file.length() ;
        }else{
            File []listFile = file.listFiles();
            for (File temp:listFile) {
                if(temp.isFile()){
                    size += temp.length();
                }else{
                    size += getFileLength(temp);
                }
            }
        }
    }
    return size;
}

}
