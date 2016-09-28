package azsecuer.andriody.com.azsecuer.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import azsecuer.andriody.com.azsecuer.R;


/**
 * Created by Administrator on 8/4 0004.
 */
public abstract class BaseActionBarActivity extends BaseActivity {
    private ImageView left_icon,right_icon;
    private TextView tv_phonemanger;
    //绑定actionbar的控件
    private void findActionBar()throws NotFoundActionBarException{
        left_icon=(ImageView)findViewById(R.id.left_icon);
        right_icon=(ImageView)findViewById(R.id.right_icon);
        tv_phonemanger=(TextView)findViewById(R.id.tv_phonemanger);
    }
    //产生没找到的异常类
    class NotFoundActionBarException extends  Exception{
        public NotFoundActionBarException(){
            super("没找到，请确定你有ActionBar");
        }

    }
    /*设置ActioBar
    left_iocnid左边的图片
    right-iconid右边的图片
    phonemangerid中间的文字（手机管家）
    规定;当传入id为-1的-1的情况，表示当前控件没作用，设置为不可见
    **/
    protected void setActionBar(int left_iconid,int right_iconid,String phonemangerid){
        try {
            findActionBar();
        }catch(NotFoundActionBarException e){
            e.printStackTrace();
        }
        if(left_iconid==-1){
            left_icon.setVisibility(View.INVISIBLE);
        }else{
            left_icon.setImageResource(left_iconid);
            left_icon.setOnClickListener(this);
        }
        if(right_iconid==-1){
            right_icon.setVisibility(View.INVISIBLE);
        }else{
            right_icon.setImageResource(right_iconid);
            left_icon.setOnClickListener(this);
        }
        if(phonemangerid==null){
            tv_phonemanger.setVisibility(View.INVISIBLE);
        }else{
            tv_phonemanger.setText(phonemangerid);
        }
    }
    //返回一个ActionBar
    protected void setActionBarBack(String  phonemangerid){
        setActionBar(R.drawable.btn_homeasup_default,-1,phonemangerid);
    }
    //主界面
    protected void setActivityHome(){
        setActionBar(R.drawable.ic_launcher,R.drawable.ic_child_configs,getResources().getString(R.string.app_name));
    }
}
