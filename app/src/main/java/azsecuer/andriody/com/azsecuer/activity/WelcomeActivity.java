package azsecuer.andriody.com.azsecuer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.activity.HomeActivity;


public class WelcomeActivity extends Activity implements Animation.AnimationListener{
    private ImageView imgone,imgtwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        findview();
        findAnimation();
    }
    void findview(){
        imgone=(ImageView)this.findViewById(R.id.imgone);
        imgtwo=(ImageView)this.findViewById(R.id.imgtwo);
    }
    void findAnimation(){
        Animation animation1= AnimationUtils.loadAnimation(this,R.anim.imgone);
        Animation animation2= AnimationUtils.loadAnimation(this,R.anim.imgtwo);
        imgone.startAnimation(animation1);
        imgtwo.startAnimation(animation2);
        animation1.setAnimationListener(this);
    }
    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent intent=new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}

