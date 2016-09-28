package azsecuer.andriody.com.azsecuer.activity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import azsecuer.andriody.com.azsecuer.Adapter.MyAdapter;
import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.mar.SpeedupManager;
import azsecuer.andriody.com.azsecuer.util.FileSizeUtil;
import azsecuer.andriody.com.azsecuer.util.Logutil;
import azsecuer.andriody.com.azsecuer.util.SpeedupInfo;


public class PhoneSpeadup extends BaseActionBarActivity implements CompoundButton.OnCheckedChangeListener {
private TextView tvone,tvtwo,tvthree;
    private ProgressBar progressBar,progressBarone;
    private Button buttonone,buttontwo;
    private ListView listView;
    private MyAdapter adapter;
    List<SpeedupInfo> speedupInfoList,one,two;
    private boolean isUserProc=true;
    private SpeedupManager speedupManager;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_quicken);
        initView();
        setListener();
        initData();
    }
    public void initData(){
        asynLoadRuningApp();

    }
    //异步加载数据
    private void asynLoadRuningApp(){
        checkBox.setVisibility(View.GONE);
        buttontwo.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
        new Thread(){
            @Override
            public void run() {
                //获取speadupmanger的对象，（单例模式）
                speedupManager=SpeedupManager.getInstance(PhoneSpeadup.this);
                speedupInfoList = new ArrayList<SpeedupInfo>();
                //获取对应数据源通过getRuningApp
                one=speedupManager.getRuningApp(SpeedupManager.CLASSIFY_ALL,true);
                two=speedupManager.getRuningApp(SpeedupManager.CLASSIFY_USER,true);
                speedupInfoList=speedupManager.getRuningApp(SpeedupManager.CLASSIFY_USER,true);
                Log.i("-----","数据："+speedupInfoList.size());
                adapter.setDatas(speedupInfoList);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBarone.setVisibility(View.INVISIBLE);
                        checkBox.setVisibility(View.VISIBLE);
                        buttontwo.setVisibility(View.VISIBLE);
                        listView.setVisibility(View.VISIBLE);
                       adapter.notifyDataSetChanged();

                    }
                });
            }
        }.start();
    }

    @Override
    public void initView() {
        setActionBarBack("手机加速");
        tvone=(TextView) findViewById(R.id.spead_tvone);
        tvone.setText(Build.BOARD);
        tvtwo=(TextView) findViewById(R.id.spead_tvtwo);
        tvtwo.setText(Build.MODEL);
        tvthree=(TextView) findViewById(R.id.spead_tvthree);
        long a=FileSizeUtil.getTotalMemorySize(this);
        long b=FileSizeUtil.getAvailableMemory(this);
        long c=a-b;
        Logutil.p(">>>>",""+c);
        tvthree.setText((c/1024/1024)+"M/"+  (a/1024/1024)+"M");
        buttonone=(Button)findViewById(R.id.spead_button);
        buttontwo=(Button)findViewById(R.id.spead_buttontwo);
        progressBar=(ProgressBar)findViewById(R.id.spead_progress);
        long i=1024*1024;
        progressBar.setMax((int)(a/i));
        progressBar.setProgress((int)(c/i));
        progressBarone=(ProgressBar) findViewById(R.id.progressbar_clear);
        listView=(ListView)findViewById(R.id.lv_clear);
        checkBox=(CheckBox)findViewById(R.id.spead_checkbox);
        adapter=new MyAdapter(PhoneSpeadup.this);
        listView.setAdapter(adapter);

    }

    @Override
    public void setListener() {
        findViewById(R.id.left_icon).setOnClickListener(this);
        buttonone.setOnClickListener(this);
        buttontwo.setOnClickListener(this);
        checkBox.setOnCheckedChangeListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.left_icon:
                finish();
                break;
            case R.id.spead_button:
                //列表切换
            if(isUserProc){
                buttonone.setText("隐藏系统进程");
               Logutil.p("-----",""+speedupInfoList);
              adapter.setDatas( one);
                isUserProc=false;
            }else{
               buttonone.setText("显示系统进程");
               adapter.setDatas( two);
                isUserProc=true;
            }
                adapter.notifyDataSetChanged();
                break;
            case R.id.spead_buttontwo:
                //一键清除
                speedupInfoList=adapter.getDataFromAdapter();
                List<SpeedupInfo> l=new ArrayList<SpeedupInfo>();
                for(SpeedupInfo info:speedupInfoList){
                    if(info.isSelected){
                        speedupManager.kill(info.processName);
                        l.add(info);
                    }

                }
                checkBox.setChecked(false);
                speedupInfoList.removeAll(l);
                adapter.notifyDataSetChanged();
                break;
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
       speedupInfoList=adapter.getDataFromAdapter();

        for (SpeedupInfo info : speedupInfoList) {

            info.isSelected = isChecked;

        }
       adapter.notifyDataSetChanged();
    }



}
