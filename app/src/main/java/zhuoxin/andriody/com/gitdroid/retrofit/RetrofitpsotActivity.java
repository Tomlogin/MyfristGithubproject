package zhuoxin.andriody.com.gitdroid.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zhuoxin.andriody.com.gitdroid.R;
import zhuoxin.andriody.com.gitdroid.gitretrofit.Tudou;
import zhuoxin.andriody.com.gitdroid.okhttppost.User;

public class RetrofitpsotActivity extends AppCompatActivity implements GitView{

    @Bind(R.id.post_name)
    EditText postName;
    @Bind(R.id.post_pwd)
    EditText postPwd;
    @Bind(R.id.post_btn)
    Button postBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttppost);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.post_btn)
    public void onClick() {
        User user = new User(postName.getText().toString(),postPwd.getText().toString());
    }


    /////////////////////start/////////////
    @Override
    public void showMessage(String s) {
         Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(List<Tudou.ResultBean.DataBean> data) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showProgress() {

    }
    /////////////////////end/////////////
}