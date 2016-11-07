package zhuoxin.andriody.com.gitdroid.okhttppost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import zhuoxin.andriody.com.gitdroid.R;
import zhuoxin.andriody.com.gitdroid.okhttpgetandpost.mOkHttp;

/**
 * Created by Administrator on 9/27 0027.
 */
public class OkhttpPostActivity extends AppCompatActivity {
    @Bind(R.id.post_btn)
    Button postBtn;
    @Bind(R.id.post_name)
    EditText postName;
    @Bind(R.id.post_pwd)
    EditText postPwd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttppost);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.post_btn)
    public void onClick() {
       User user = new User(postName.getText().toString(),postPwd.getText().toString());
        mOkHttp.getMyOkhttp().postmeth(user).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("test","失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("test","成功" +response.body().string());
            }
        });
//        //创建拦截器
//        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                //添加拦截器
//                .addInterceptor(interceptor)
//                .build();
//        //创建gson是因为它的toJson能让user变成一个字符串，创建请求体时需要
//        Gson gson = new Gson();
//        User user = new User(postName.getText().toString(),postPwd.getText().toString());
//        String content=gson.toJson(user);
//        //创建一个请求体（post请求比get请求多一步，需要添加一个请求体）
//        RequestBody requestBody = RequestBody.create(null, content);
//        //创建一个请求
//        Request request = new Request.Builder()
//                .post(requestBody)
//                .url("http://blog.csdn.net/kunlong0909/article/details/6765564")
//                .build();
//        //执行请求
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("test","失败" );
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.e("test","成功" );
//            }
//        });
    }
}
