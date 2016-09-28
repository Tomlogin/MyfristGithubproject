package azsecuer.andriody.com.azsecuer.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import azsecuer.andriody.com.azsecuer.Adapter.RubbishAdapter;
import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.mar.ClearDBManger;
import azsecuer.andriody.com.azsecuer.Splite.Clear_item;
import azsecuer.andriody.com.azsecuer.util.CopyDB;
import azsecuer.andriody.com.azsecuer.util.FileUtils;

public class Clear_moblie extends BaseActionBarActivity {
    private ProgressBar progressBar;
    private List<Clear_item> list;
    private RubbishAdapter rubbishAdapter;
    private ListView listView;
private ImageView left_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear_moblie);
        try {
            ClearDBManger.initdata(this);
            if(ClearDBManger.file.length()==0){
                CopyDB.copy(this,"clearpath.db",ClearDBManger.file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        initView();
        setListener();
        initData();
//        list=ClearDBManger.readapkname(this);
//        rubbishAdapter=new RubbishAdapter(this);
//        rubbishAdapter.setDatas(list);
//        listView.setAdapter(rubbishAdapter);
//        listView.setVisibility(View.VISIBLE);
//       progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void initView() {
       setActionBarBack("垃圾清理");
        left_icon=(ImageView) findViewById(R.id.left_icon);
        listView=(ListView) findViewById(R.id.lv_clear);
        progressBar=(ProgressBar) findViewById(R.id.progressbar_clear);
    }

    @Override
    public void setListener() {
        left_icon.setOnClickListener(this);
        findViewById(R.id.button_clear).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_icon:
                finish();
                break;
            case R.id.button_clear:
               deleteData();
                break;
        }

    }
    private void deleteData(){
        listView.setVisibility(View.INVISIBLE);
      progressBar.setVisibility(View.VISIBLE);
        new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i=0;i<list.size();i++){
                    if(list.get(i).isChecked) {

                        FileUtils.deletefile(new File(list.get(i).filepath));
                        list.remove(i);
                        i-=1;
                    }
                }
//                Iterator<Clear_item> iterator=list.iterator();
//                while(iterator.hasNext()){
//                    Clear_item clear_item=iterator.next();
//                    Log.i("---",""+clear_item);
//                   if(clear_item.isChecked){
//                       File file=new File(clear_item.filepath);
//                           FileUtils.deletefile(file);
//                       iterator.remove();
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               rubbishAdapter.setDatas(list);
                               rubbishAdapter.notifyDataSetChanged();
                               progressBar.setVisibility(View.INVISIBLE);
                               listView.setVisibility(View.VISIBLE);
                           }
                       });


            }
        }.start();

    }
    private void initData(){
       list=new ArrayList<>();
        rubbishAdapter=new RubbishAdapter(this);
        new Thread(){
            @Override
            public void run() {
                super.run();
                list=ClearDBManger.readapkname(Clear_moblie.this);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                     rubbishAdapter.setDatas(list);
                        listView.setAdapter(rubbishAdapter);
                     rubbishAdapter.notifyDataSetChanged();
                        listView.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }

        }.start();
    }
}
