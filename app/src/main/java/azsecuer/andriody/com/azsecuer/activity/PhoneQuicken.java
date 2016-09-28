package azsecuer.andriody.com.azsecuer.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.util.GetMemory;

public class PhoneQuicken extends BaseActionBarActivity implements CompoundButton.OnCheckedChangeListener{
private TextView tvone,tvtwo,tvthree;
    private ProgressBar progressBar;
    private Button buttonone,buttontwo;
    private CheckBox checkBox;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_quicken);
        initView();
    }

    @Override
    public void initView() {
        setActionBarBack("手机加速");
        tvone=(TextView)findViewById(R.id.spead_tvone);
        tvone.setText(Build.BRAND);
        tvtwo=(TextView)findViewById(R.id.spead_tvtwo);
        tvtwo.setText(Build.MODEL);
        tvthree=(TextView)findViewById(R.id.spead_tvthree);
        tvthree.setText("可用内存"+GetMemory.getMemoryCanUse()+"/"+GetMemory.getmemoryall());
        progressBar=(ProgressBar)findViewById(R.id.spead_progress);
        progressBar.setMax((int)GetMemory.max);
        progressBar.setProgress((int)GetMemory.progress);
        listView=(ListView)findViewById(R.id.lv_clear);
        buttonone=(Button) findViewById(R.id.spead_button);
        buttontwo=(Button)findViewById(R.id.spead_buttontwo);
        checkBox=(CheckBox)findViewById(R.id.spead_checkbox);


    }

    @Override
    public void setListener() {
        findViewById(R.id.left_icon).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_icon:
                finish();
                break;
            case R.id.spead_button:
                //界面切换
                break;
            case R.id.spead_buttontwo:
               //一键清理
                break;
            case R.id.spead_checkbox:
               //全选
                break;
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
