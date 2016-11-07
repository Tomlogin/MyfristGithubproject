package zhuoxin.andriody.com.gitdroid.okhttpgetandpost;

import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import zhuoxin.andriody.com.gitdroid.okhttppost.User;

/**
 * Created by Administrator on 9/27 0027.
 */
public class mOkHttp extends OkHttpClient implements Oncall{
    private  static mOkHttp mokHttp;
    private mOkHttp(){
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //添加拦截器
                .addInterceptor(interceptor)
                .build();
    }
    public static mOkHttp getMyOkhttp(){
      if(mokHttp==null){
          mokHttp=new mOkHttp();
      }
        return mokHttp;
    }

    @Override
    public Call postmeth(User user) {
        Gson gson = new Gson();
        String content=gson.toJson(user);
        //创建一个请求体（post请求比get请求多一步，需要添加一个请求体）
        RequestBody requestBody = RequestBody.create(null, content);
        //创建一个请求
        Request request = new Request.Builder()
                .post(requestBody)
                .url("http://op.juhe.cn/onebox/weather/query?key=9120b125a61bcb084092888566528ea2")
                .build();

        return getMyOkhttp().newCall(request);
    }

    @Override
    public Call getmeth() {
        Request request = new Request.Builder()
                .get()
                .url("http://op.juhe.cn/onebox/weather/query?key=9120b125a61bcb084092888566528ea2")
                .build();
        return getMyOkhttp().newCall(request);
    }
}
