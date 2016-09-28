package azsecuer.andriody.com.azsecuer.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import azsecuer.andriody.com.azsecuer.Adapter.SoftmangerAdapter;
import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.mar.SoftwareManager;
import azsecuer.andriody.com.azsecuer.util.Logutil;
import azsecuer.andriody.com.azsecuer.util.SoftwareBrowseInfo;

public class Softmanger_app extends BaseActionBarActivity implements AdapterView.OnItemClickListener{
private ListView listView;
    private SoftwareBrowseInfo softwareBrowseInfo;
    private ProgressBar progressBar;
    private List<SoftwareBrowseInfo> list;
    private SoftmangerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_softmanger_app);
        initView();
        setListener();
        initData();
    }
public void initData(){
    int softtype=getIntent().getExtras().getInt("soft_type");
    syncLoadData(softtype);
}
    private void syncLoadData(final int softtype){
        new Thread(){
            @Override
            public void run() {
                list = SoftwareManager.getInstance(Softmanger_app.this).getSoftware(softtype);
//                Logutil.p("----","数据"+list.get(0).lable);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter=new SoftmangerAdapter(Softmanger_app.this);
                        adapter.setDatas(list);
                        listView.setAdapter(adapter);
                        listView.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }.start();

    }
    @Override
    public void initView() {
        setActionBarBack("软件列表");
//        list=new ArrayList<>();
        listView=(ListView) findViewById(R.id.lv_clear);
        progressBar=(ProgressBar) findViewById(R.id.progressbar_clear);

    }

    @Override
    public void setListener() {
     findViewById(R.id.left_icon).setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_icon:
                finish();
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("卸载")
                .setMessage("是否确定卸载此软件")
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(Intent.ACTION_DELETE);
                        intent.setData(Uri.parse("package:"+list.get(position).packagename));
                        startActivity(intent);
                        list.remove(position);
                        adapter.notifyDataSetChanged();

                    }
                })
                .setPositiveButton("取消",null)
                .setCancelable(true);
        dialog.show();


    }
}
