package azsecuer.andriody.com.azsecuer.util;

import android.util.Log;

/**
 * Created by Administrator on 8/10 0010.
 */
public class Logutil {
    // 测试的开关
    private static boolean isDebug = true;
    // 错误信息的开关
    private static boolean isErro = true;
    public static void p(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }
    public static void p(String tag, String msg,Throwable tr) {
        if (isErro) {
            Log.i(tag, msg,tr);
        }
    }


}
