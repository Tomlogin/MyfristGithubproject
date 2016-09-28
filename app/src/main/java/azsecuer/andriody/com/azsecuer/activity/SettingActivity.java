package azsecuer.andriody.com.azsecuer.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RemoteViews;
import android.widget.ToggleButton;

import azsecuer.andriody.com.azsecuer.R;

public class SettingActivity extends BaseActionBarActivity {
    private ToggleButton setting_open,setting_inform;
    private boolean setting_open_whether=false,setting_inform_whether=false;
    private SharedPreferences sharedpreferces;
    private SharedPreferences.Editor editor;
    private  final  String key_open="openchecked",key_inform="informchecked";
    private boolean ischeckopen,ischeckinform;
    private NotificationManager notificationManager;
    private Intent intenthome,intentphonebook;
    private PendingIntent pendingintenthome,pendingintentphonebook;
    private RemoteViews remoteviews;
    private int NOTIFICATION=1;
    private Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        sharedpreferces=this.getSharedPreferences("settingpreferces",MODE_PRIVATE);
        editor=sharedpreferces.edit();
        setActionBarBack("设置");
        initView();
        setListener();


    }

    @Override
    public void initView() {
         setting_open=(ToggleButton) findViewById(R.id.setting_open);//找到控件
         setting_inform=(ToggleButton) findViewById(R.id.setting_inform);
        ischeckopen=sharedpreferces.getBoolean(key_open,false);//获取储存的key值（key值，默认值）
        ischeckinform=sharedpreferces.getBoolean(key_inform,false);
        setting_open.setChecked(ischeckopen);//控件设置储存值
        setting_inform.setChecked(ischeckinform);
    }

    @Override
    public void setListener() {
        //为setting_inform设置监听事件（创建一个Oncheckedchangelistener对象并重写oncheckedchenged方法）
        setting_inform.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                   opennotification();
                }else{
                    closenotification(SettingActivity.this);
                }

            }
        });
        setting_open.setOnClickListener(this);


    }
//添加通知栏消息
    public void opennotification(){
        //初始化notificationManger
       notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        //生成意图
        intenthome=new Intent(this,HomeActivity.class);
        intentphonebook=new Intent(this,Phonebook.class);
        //生成intent对应的两个pendingintent
        pendingintenthome=PendingIntent.getActivity(this,0,intenthome,0);
        pendingintentphonebook=PendingIntent.getActivity(this,0,intentphonebook,PendingIntent.FLAG_CANCEL_CURRENT);
       //notification初始化
       notification=new Notification.Builder(this)
        .setSmallIcon(R.drawable.ic_launcher)//小图标
        .setContent(remoteviews)//布局文件
        .setTicker("有新信息")
//        .setContentIntent(pendingintenthome)//跳转的意图
        .build();//提交
        notification.flags=Notification.FLAG_NO_CLEAR;//通知栏不能被其它清除
        notificationManager.notify(NOTIFICATION,notification);//管理者生成通知（谁，怎样的通知）
        //初始化RemoteViews
        remoteviews=new RemoteViews(this.getPackageName(),R.layout.activity_inform);
        //添加监听事件
        remoteviews.setOnClickPendingIntent(R.id.inform_layout,pendingintenthome);
        remoteviews.setOnClickPendingIntent(R.id.inform_imgtwo,pendingintentphonebook);

    }
    //关闭通知栏
    public void closenotification(Context context){
     if(notificationManager==null){
         notificationManager=(NotificationManager)this.getSystemService(context.NOTIFICATION_SERVICE);
     }
        notificationManager.cancel(NOTIFICATION);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //开机启动
            case R.id.setting_open:
                if(ischeckopen){
                    setting_open.setChecked(false);
                    ischeckopen=false;

                }else{
                    setting_open.setChecked(true);
                    ischeckopen=true;
                }
                editor.putBoolean(key_open,ischeckopen);
                editor.commit();//提交
                break;
            //通知图标
            case R.id.setting_inform:
                if(ischeckinform){
                    setting_inform.setChecked(false);
                    ischeckinform=false;

                }else{
                    setting_inform.setChecked(true);
                    ischeckinform=true;
                }
                editor.putBoolean(key_inform,ischeckinform);
                editor.commit();//提交
                break;
            case R.id.left_icon:
                finish();
                break;
        }
//        switch (v.getId()){
//            case R.id.setting_open:
//                if(!setting_open_whether){
//                    setting_open_whether=true;
//                    setting_open.setBackgroundResource(R.drawable.check_switch_on);
//                }else{
//                    setting_open_whether=false;
//                    setting_open.setBackgroundResource(R.drawable.check_switch_off);
//
//                }
//                break;
//            case R.id.setting_inform:
//                if(!setting_inform_whether){
//                    setting_inform_whether=true;
//                    setting_inform.setBackgroundResource(R.drawable.check_switch_on);
//                }else{
//                    setting_inform_whether=false;
//                    setting_inform.setBackgroundResource(R.drawable.check_switch_off);
//
//                }
//                break;
//      }

    }
}
