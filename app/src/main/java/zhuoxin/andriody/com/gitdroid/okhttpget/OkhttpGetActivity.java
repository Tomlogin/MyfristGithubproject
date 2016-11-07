package zhuoxin.andriody.com.gitdroid.okhttpget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import zhuoxin.andriody.com.gitdroid.R;
import zhuoxin.andriody.com.gitdroid.okhttpgetandpost.mOkHttp;

public class OkhttpGetActivity extends AppCompatActivity {
    @Bind(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttpget);
        ButterKnife.bind(this);
//        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                OkHttpClient okHttpClient = new OkHttpClient();
//                Request request = new Request.Builder()
//                        .get()
//                        .url("https://api.github.com/users/gqq")
//                        .build();
//                Call call = okHttpClient.newCall(request);
//                call.enqueue(new Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        Log.e("test", "失败了");
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//
//                        Log.e("test", "成功了" + response.body().toString());
//                    }
//                });
//
//            }
//        });

    }

    @OnClick(R.id.tv)
    public void onClick() {
        mOkHttp.getMyOkhttp().getmeth().enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("test", "成功了" + response.body().string());
            }
        });
//        //创建拦截器
//        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                //添加拦截器
//                .addInterceptor(interceptor)
//                .build();
//                Request request = new Request.Builder()
//                        .get()
//                        .url("https://api.github.com/users/gqq")
//                        .build();
//                Call call = okHttpClient.newCall(request);
//                call.enqueue(new Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        Log.e("test", "失败了");
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//
//                        Log.e("test", "成功了" + response.body().toString());
//                    }
//                });

    }
}
