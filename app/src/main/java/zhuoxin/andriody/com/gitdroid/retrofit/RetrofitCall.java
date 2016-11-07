package zhuoxin.andriody.com.gitdroid.retrofit;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import zhuoxin.andriody.com.gitdroid.gitretrofit.Tudou;
import zhuoxin.andriody.com.gitdroid.okhttppost.User;

/**
 * Created by Administrator on 9/28 0028.
 */
public interface RetrofitCall {
    @GET("/cook/query?key=08b127d3d67bc05a617fe7aebf1d9670&menu=土豆&rn=10&pn=3")
    Call<ResponseBody> getdata();
    //可替换
   // Call<ResponseBody>getdata(@Path("要换的")String a);
   // @POST("/Handler/UserHandler.ashx?action=register")
    @POST("/cook/query.php")
    Call<ResponseBody> userregister(@Query("key")String key, @Query("menu")String menu,
                                        @Query("rn")int rn, @Query("pn")int pn);
    //可拼接 拼接结果:/Handler/UserHandler.ashx?action=register&a=register   如果是第一个=，&就是？
    //Call<ResponseBody> userregister(@Body User user, @Query("a")String register);

}
