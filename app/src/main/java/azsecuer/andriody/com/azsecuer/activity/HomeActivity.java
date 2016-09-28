package azsecuer.andriody.com.azsecuer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.mar.SpeedupManager;
import azsecuer.andriody.com.azsecuer.util.FileSizeUtil;
import azsecuer.andriody.com.azsecuer.util.HomeBall;
import azsecuer.andriody.com.azsecuer.util.Logutil;
import azsecuer.andriody.com.azsecuer.util.SpeedupInfo;


public class HomeActivity extends BaseActionBarActivity {
    HomeBall customProc;
    private int temp =0;
    private long a=0;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            customProc.setProgress(temp);
        }
    };
private TextView tv_pnonebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        setActivityHome();
        setListener();
        long a=FileSizeUtil.getTotalMemorySize(this);
        long b= FileSizeUtil.getAvailableMemory(this);
        long c=a-b;
        double d=(double) c/(double) a;
        customProc.startAnimSetProgress3((int)(d*100));



    }

    @Override
    public void initView() {
        customProc = (HomeBall) findViewById(R.id.home_img);
        tv_pnonebook=(TextView) findViewById(R.id.tv_home_numberservice);
    }

    @Override
    public void setListener() {
        findViewById(R.id.right_icon).setOnClickListener(this);
        tv_pnonebook.setOnClickListener(this);
        findViewById(R.id.tv_home_mobliemgr).setOnClickListener(this);
        findViewById(R.id.tv_home_rubbishclean).setOnClickListener(this);
        findViewById(R.id.tv_home_speadup).setOnClickListener(this);
        findViewById(R.id.tv_home_softmgr).setOnClickListener(this);
        findViewById(R.id.tv_home_filemgr).setOnClickListener(this);
        customProc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //设置界面
            case R.id.right_icon:
              Intent intent=new Intent(this,SettingActivity.class);
                startActivity(intent);
                break;
            //通讯大全
            case R.id.tv_home_numberservice:
                Intent intent1=new Intent(this,Phonebook.class);
                startActivity(intent1);
                break;
            //手机检测
            case R.id.tv_home_mobliemgr:
                Intent intent2=new Intent(this,Home_mobliemgr.class);
                startActivity(intent2);
                break;
            //垃圾清理
            case R.id.tv_home_rubbishclean:
                Intent intent3=new Intent(this,Clear_moblie.class);
                startActivity(intent3);
                break;
            //手机加速
            case R.id.tv_home_speadup:
                Intent intent4=new Intent(this,PhoneSpeadup.class);
                startActivity(intent4);
                break;
            //软件管理
            case R.id.tv_home_softmgr:
                Intent intent5=new Intent(this,SoftwareMangerActivity.class);
                startActivity(intent5);
                break;
            //文件管理
            case R.id.tv_home_filemgr:
                Intent intent6=new Intent(this,FileMangerActivity.class);
                startActivity(intent6);
                break;
            //加速球
            case R.id.home_img:
             SpeedupManager speedupManager=SpeedupManager.getInstance(this);
                speedupManager.defSpeedup();
                long a=FileSizeUtil.getTotalMemorySize(this);
                long b= FileSizeUtil.getAvailableMemory(this);
                long c=a-b;
                double d=(double) c/(double) a;
                customProc.startAnimSetProgress3((int)(d*100));
                break;

        }

    }


}
