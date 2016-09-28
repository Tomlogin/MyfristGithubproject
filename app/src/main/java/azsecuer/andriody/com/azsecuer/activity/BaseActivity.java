package azsecuer.andriody.com.azsecuer.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 8/4 0004.
 */
public abstract class BaseActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public abstract void initView();
    public abstract void setListener();
    protected void startActivityNow(Class target){
        Intent intent = new Intent(this,target);
        startActivity(intent);
    }
    protected void startActivityNow(Class target,Bundle bundle){
        Intent intent = new Intent(this,target);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}


