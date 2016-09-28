package azsecuer.andriody.com.azsecuer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.mar.SoftwareManager;
import azsecuer.andriody.com.azsecuer.util.FileSizeUtil;
import azsecuer.andriody.com.azsecuer.util.Logutil;
import azsecuer.andriody.com.azsecuer.util.PiecharView;

public class SoftwareMangerActivity extends BaseActionBarActivity {
    private TextView tv_sizeone,tv_sizetwo,tv_text,tv_sizethree,tv_sizefour,tvdomeone,tvdometwo,tvdomethree;
    private ProgressBar progressBarone,progressBartwo;
    private View incldeone,incldetwo,tvandimgone,tvandimgtwo,tvandimgthree;
    private PiecharView piecharView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software_manger);
        initView();
        setListener();

    }

    @Override
    public void initView() {
        long i=1024*1024*1024;
        setActionBarBack("软件管理");
        tv_sizeone=(TextView)findViewById(R.id.sm_ball_tvsizeone);
        tv_sizeone.setText(FileSizeUtil.formatFileSize(FileSizeUtil.getTotalInternalMemorySize(),true));
//        tv_sizeone.setText(MemoryManager.getTotalInRom(this)+"");
        tv_sizetwo=(TextView)findViewById(R.id.sm_ball_tvsizetwo);
        tv_sizetwo.setText(FileSizeUtil.formatFileSize(FileSizeUtil.getTotalExternalMemorySize(),true));
//        tv_sizetwo.setText(MemoryManager.getTotalOutRom(this)+"");
        incldeone=findViewById(R.id.include_softmanger_progressone);
        tv_sizethree=(TextView)incldeone.findViewById(R.id.tv_sizethree);
        long a=FileSizeUtil.getTotalInternalMemorySize()-FileSizeUtil. getAvailableInternalMemorySize();
//        long a=MemoryManager.getTotalInRom(this)-MemoryManager.getAvailableInRom(this);
        tv_sizethree.setText( FileSizeUtil.formatFileSize(a,true)+"/"+ FileSizeUtil.formatFileSize(FileSizeUtil.getTotalInternalMemorySize(),true));
        progressBarone=(ProgressBar) incldeone.findViewById(R.id.softmanger_progressbar);
        progressBarone.setMax((int)(FileSizeUtil.getTotalInternalMemorySize()/i));
        progressBarone.setProgress((int)(a/i));
        incldetwo=findViewById(R.id.include_softmanger_progresstwo);
        long b=FileSizeUtil.getTotalExternalMemorySize()-FileSizeUtil. getAvailableExternalMemorySize();
        Logutil.p("----","long b:"+b);
//        long b=MemoryManager.getTotalOutRom(this)-MemoryManager.getAvailableOutRom(this);
        tv_text=(TextView) incldetwo.findViewById(R.id.tv_text);
        tv_text.setText("外置空间(已使用/全部)");
        tv_sizefour=(TextView)incldetwo.findViewById(R.id.tv_sizethree);
        tv_sizefour.setText( FileSizeUtil.formatFileSize(b,true)+"/"+ FileSizeUtil.formatFileSize(FileSizeUtil.getTotalExternalMemorySize(),true));
        progressBartwo=(ProgressBar) incldetwo.findViewById(R.id.softmanger_progressbar);
        progressBartwo.setMax((int)(FileSizeUtil.getTotalExternalMemorySize()/i));
        progressBartwo.setProgress((int)(b/i));
        tvandimgone=findViewById(R.id.softmanger_tvandimgone);
        tvdomeone=(TextView) tvandimgone.findViewById(R.id.tv_dome);
        tvdomeone.setText("所有软件");
        tvandimgtwo=findViewById(R.id.softmanger_tvandimgtwo);
        tvdometwo=(TextView) tvandimgtwo.findViewById(R.id.tv_dome);
        tvdometwo.setText("系统软件");
        tvandimgthree=findViewById(R.id.softmanger_tvandimgthree);
        tvdomethree=(TextView) tvandimgthree.findViewById(R.id.tv_dome);
        tvdomethree.setText("用户软件");
        piecharView=(PiecharView)findViewById(R.id.piecharview);
        double in=((int)(a/i));
        double out=((int)(b/i));
        int in360=(int)((in/(in+out))*360);
        Logutil.p(">>>>>",""+in);
        Logutil.p(">>>>>",""+out);
        Logutil.p(">>>>>",""+in360);
        int out360=360-in360;
        // 设置饼状图信息
        int data[][] = new int[][]{{this.getResources().getColor(R.color.piechar_phone),in360,0},
                {this.getResources().getColor(R.color.piechar_sdcard),out360,0}};
        piecharView.setAngleWithAnim2(data);
    }

    @Override
    public void setListener() {
        findViewById(R.id.left_icon).setOnClickListener(this);
        tvandimgone.setOnClickListener(this);
        tvandimgtwo.setOnClickListener(this);
        tvandimgthree.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,Softmanger_app.class);
        Bundle bundle=new Bundle();
        switch (v.getId()){
            case R.id.left_icon:
                finish();
                break;
            case R.id.softmanger_tvandimgone:
                bundle.putInt("soft_type", SoftwareManager.CLASSIFY_ALL);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.softmanger_tvandimgtwo:
                bundle.putInt("soft_type", SoftwareManager.CLASSIFY_SYS);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.softmanger_tvandimgthree:
                bundle.putInt("soft_type", SoftwareManager.CLASSIFY_USER);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }

    }
}
