package azsecuer.andriody.com.azsecuer.util;

import android.os.Environment;
import android.os.StatFs;
import android.widget.ProgressBar;

import java.io.File;

/**
 * Created by Administrator on 8/19 0019.
 */
public class GetMemory {
    public static long a,c,max,min,progress;
    private ProgressBar progressBar;
    //获取所有内存
    public static String getmemoryall(){
        File path = Environment.getDataDirectory();

        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        a=totalBlocks * blockSize;
        long b=1024*1024;
        max=a/b;
        String memoryall=  PublicUtils.formatSize(a);
        return memoryall;

    }
    //获取剩余内存
    public static String getMemoryCanUse(){
//        ActivityManager activityManager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
//        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
//        activityManager.getMemoryInfo(info);
//        return (info.availMem)/1024/1024+"M";
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        c=availableBlocks*blockSize;
        long d=1024*1024;
        min=c/d;
        progress=max-min;
        String memorycanuse=  PublicUtils.formatSize(c);
        return memorycanuse;
    }


}
