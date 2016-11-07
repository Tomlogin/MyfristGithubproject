package zhuoxin.andriody.com.gitdroid.maintest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import zhuoxin.andriody.com.gitdroid.R;
import zhuoxin.andriody.com.gitdroid.gitretrofit.GitRetrofitActivity;
import zhuoxin.andriody.com.gitdroid.okhttpget.OkhttpGetActivity;
import zhuoxin.andriody.com.gitdroid.okhttppost.OkhttpPostActivity;
import zhuoxin.andriody.com.gitdroid.retrofit.RetrofitActivity;
import zhuoxin.andriody.com.gitdroid.retrofit.RetrofitpsotActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @Bind(R.id.listview)
    ListView listview;
    private Demo[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setData();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, setData());
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
    }


    public Demo[] setData() {
        data = new Demo[]{
                new Demo("login", new Intent(this, LoginActivity.class)),
                new Demo("OkHttp的GET请求", new Intent(this, OkhttpGetActivity.class)),
                new Demo("OkHttp的POST请求", new Intent(this, OkhttpPostActivity.class)),
                new Demo("Rerofit的GET请求", new Intent(this, RetrofitActivity.class)),
                new Demo("Rerofit的POST请求", new Intent(this, RetrofitpsotActivity.class)),
                new Demo("设置数据", new Intent(this, GitRetrofitActivity.class))
        };
        return data;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(data[position].intent);
    }

    static class Demo {
        String name;
        Intent intent;

        private Demo(String name, Intent intent) {
            this.name = name;
            this.intent = intent;
        }

        public String toString() {
            return name;
        }
    }
}
