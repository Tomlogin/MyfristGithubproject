package azsecuer.andriody.com.azsecuer.activity;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import azsecuer.andriody.com.azsecuer.Adapter.MobliemgrAdapter;
import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.Splite.MobliemgrChild;
import azsecuer.andriody.com.azsecuer.Splite.MobliemgrGroup;
import azsecuer.andriody.com.azsecuer.mar.MobileManager;

public class Home_mobliemgr extends BaseActionBarActivity {
    private ExpandableListView ELV;
         private ImageView left_icon;
         private MyRecevier myRecevier;
    private ProgressBar progressBar;
    private TextView dianliang;
    private View v;
    private  int add=0,h;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

            if(add==100){
                v.setBackgroundColor(Color.parseColor("#ff5566"));
            }else {
                v.setBackgroundColor(Color.parseColor("#00ff00"));
            }
            progressBar.setProgress(add);
        }
    };

    private Map<String,List<MobliemgrChild>> children;
    private MobliemgrAdapter mobliemgrAdapter;
    private MobileManager mobileManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_mobliemgr);
        setActionBarBack("手机检测");

        initView();
        setListener();
        myRecevier=new MyRecevier();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(myRecevier,intentFilter);
        mobileManager=new MobileManager(this);
        mobliemgrAdapter=new MobliemgrAdapter(this);
        ELV.setAdapter(mobliemgrAdapter);
        initData();
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(myRecevier);
        super.onDestroy();
    }

    public class MyRecevier extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
             h=intent.getIntExtra("level",0);
            progressBar.setProgress(h);
            dianliang.setText(h+"%");

            new Thread(){
                @Override
                public void run() {
                    while (add<h){
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        add++;
                        handler.sendEmptyMessage(add);
                    }
                }
            }.start();
        }
    }
    public void initData() {


        final ProgressDialog pd = ProgressDialog.show(this,null,"加载中..",false,true);
        new Thread() {
            @Override
            public void run() {
                final MobliemgrGroup phoneInfoGroup = new MobliemgrGroup(getResources().getDrawable(R.drawable.setting_info_icon_version), "设备信息");
                final List<MobliemgrChild> phonnChild = mobileManager.getPhoneMessage();
                final MobliemgrGroup sytemInfoGroup =new MobliemgrGroup(getResources().getDrawable(R.drawable.setting_info_icon_cpu), "系统信息");
                final List<MobliemgrChild> systemChild = mobileManager.getSystemMessage();
                final MobliemgrGroup netInfoGroup = new MobliemgrGroup(getResources().getDrawable(R.drawable.setting_info_icon_root), "网络信息");
                final List<MobliemgrChild> netChild = mobileManager.getWIFIMessage();
                final MobliemgrGroup creamInfoGroup = new MobliemgrGroup(getResources().getDrawable(R.drawable.setting_info_icon_camera), "相机信息");
                final List<MobliemgrChild> creamChild = mobileManager.getCameraMessage();
                final MobliemgrGroup ramInfoFroup = new MobliemgrGroup(getResources().getDrawable(R.drawable.setting_info_icon_space), "存储信息");
                final List<MobliemgrChild> ramChild = mobileManager.getMemoryMessage(Home_mobliemgr.this);

                /**
                 * 回到ui
                 * 跟handler非常相似
                 */
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mobliemgrAdapter.addDataToAdapter(phoneInfoGroup, phonnChild);
                        mobliemgrAdapter.addDataToAdapter(sytemInfoGroup,systemChild);
                        mobliemgrAdapter.addDataToAdapter(netInfoGroup,netChild );
                        mobliemgrAdapter.addDataToAdapter(creamInfoGroup, creamChild);
                        mobliemgrAdapter.addDataToAdapter(ramInfoFroup,ramChild);
                        mobliemgrAdapter.notifyDataSetChanged();
                        pd.cancel();
                    }
                });
                super.run();
            }
        }.start();
    }


//        children=new HashMap<>();
//        List<MobliemgrChild> list=new ArrayList<>();
//        list.add(new MobliemgrChild("手机品牌", Build.BOARD));
//        list .add(new MobliemgrChild("手机制造商",Build.MANUFACTURER));
//        list.add(new MobliemgrChild("手机型号",Build.MODEL));
//        mobliemgrAdapter.addDataToAdapter(new MobliemgrGroup(getResources().getDrawable(R.drawable.setting_info_icon_version),"设备信息"),list);}





    @Override
    public void initView() {
        left_icon=(ImageView) findViewById(R.id.left_icon);
        progressBar=(ProgressBar) findViewById(R.id.progressbar);
        dianliang=(TextView)findViewById(R.id.tv_dianliang);
        v=(View)findViewById(R.id.v_fill);
        ELV=(ExpandableListView) findViewById(R.id.ELV);


    }

    @Override
    public void setListener() {
        left_icon.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_icon:
                finish();
                break;

        }

    }
}
