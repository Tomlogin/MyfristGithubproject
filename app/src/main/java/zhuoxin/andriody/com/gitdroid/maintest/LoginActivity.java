package zhuoxin.andriody.com.gitdroid.maintest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zhuoxin.andriody.com.gitdroid.R;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.login_img)
    ImageView loginImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.phoneimg);
        loginImg.startAnimation(animation);
    }

    @OnClick(R.id.login_img)
    public void onClick() {
    }
}
