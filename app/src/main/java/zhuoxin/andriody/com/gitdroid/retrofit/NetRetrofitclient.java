package zhuoxin.andriody.com.gitdroid.retrofit;

import android.widget.Toast;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Query;
import zhuoxin.andriody.com.gitdroid.gitretrofit.Tudou;
import zhuoxin.andriody.com.gitdroid.okhttppost.User;

/**
 * Created by Administrator on 9/28 0028.
 */
public class NetRetrofitclient implements RetrofitCall{
    private static NetRetrofitclient netRetrofitclient;
    private  RetrofitCall userApi;
    private String url="http://apis.juhe.cn";
    private String BASE_URL = "http://admin.syfeicuiedu.com";
    private NetRetrofitclient(){

    }
    public static NetRetrofitclient getNetRetrofitclient(){
        if(netRetrofitclient==null){
            netRetrofitclient=new NetRetrofitclient();
        }
        return netRetrofitclient;
    }
    @Override
    public Call<ResponseBody> getdata() {
        // 完成Retrofit的初始化
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userApi = retrofit.create(RetrofitCall.class);

        return userApi.getdata();
    }

    @Override
    public Call<ResponseBody> userregister(@Query("key")String key, @Query("menu")String menu,
                                               @Query("rn")int rn, @Query("pn")int pn) {
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userApi = retrofit.create(RetrofitCall.class);
        return userApi.userregister(key,menu,rn,pn);
    }
}
