package azsecuer.andriody.com.azsecuer.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;

import azsecuer.andriody.com.azsecuer.Adapter.FileServiceAdapter;
import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.mar.FileSearchManager;
import azsecuer.andriody.com.azsecuer.util.FileClassInfo;
import azsecuer.andriody.com.azsecuer.util.FileSearchTypeEvent;
import azsecuer.andriody.com.azsecuer.util.FileSizeUtil;
import azsecuer.andriody.com.azsecuer.util.Logutil;

public class FileMangerActivity extends BaseActionBarActivity implements AdapterView.OnItemClickListener{
private TextView tv_size;
    private Button button;
    private ListView listView;
    private long totalSize;//文件总的大小（每次进入时归零）
    private HashMap<String,Long>fileSizes;
    private FileSearchManager searchManager;
    private FileServiceAdapter adapter;
    private Thread searchThread;
    private FileClassInfo info;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    button.setClickable(false);
                    button.setText("搜索中");
                    break;
                case 1:
                    tv_size.setText(FileSizeUtil.formatFileSize(totalSize,true));
                    break;
                case 2:
                    int searchLocationRom = msg.arg1;
                    switch (searchLocationRom) {
                        // 内置空间搜索结束后UI更新 (click为true,可再进行深度搜索)
                        case 0:
                            button.setClickable(true);
                            button.setText("深度搜索");
                            break;
                        // 外置空间搜索结束后UI更新(click为false,搜索完毕)
                        case 1:
                            button.setClickable(false);
                            button.setText("搜索完毕");
                            break;
                    }
                    int count = adapter.getCount();
                    for (int i = 0; i < count; i++) {
                        FileClassInfo info = adapter.getItem(i);
                        info.size = fileSizes.get(info.fileType);
                        info.loadingOver = true;
                    }
                    adapter.notifyDataSetChanged();
                    break;
            }

        }


    };
    private void loadTheData(){
        adapter = new FileServiceAdapter(this);
        adapter.addDataToAdapter(new FileClassInfo("文本文件", FileSearchTypeEvent.TYPE_TXT));
        adapter.addDataToAdapter(new FileClassInfo("图像文件", FileSearchTypeEvent.TYPE_IMAGE));
        adapter.addDataToAdapter(new FileClassInfo("APK文件", FileSearchTypeEvent.TYPE_APK));
        adapter.addDataToAdapter(new FileClassInfo("视屏文件", FileSearchTypeEvent.TYPE_VIDEO));
        adapter.addDataToAdapter(new FileClassInfo("音屏文件", FileSearchTypeEvent.TYPE_AUDIO));
        adapter.addDataToAdapter(new FileClassInfo("压缩文件", FileSearchTypeEvent.TYPE_ZIP));
        adapter.addDataToAdapter(new FileClassInfo("其它文件", FileSearchTypeEvent.TYPE_OTHER));
        listView.setAdapter(adapter);
        totalSize = 0;
        searchManager = FileSearchManager.getInstance(true);
        fileSizes = searchManager.getFileSizes();
        // 异步搜索内置文件
        asyncSearchInRomFile();
    }
    //搜索内部文件
    private void asyncSearchInRomFile(){
        searchThread=new Thread(new Runnable() {
            @Override
            public void run() {
                searchManager.setOnFileSearchListener(searchListener);
                searchManager.startSearchFromInRom(FileMangerActivity.this);
            }
        });
searchThread.start();
    }
    //搜索外置文件（深度搜索）
    private void asyncSearchOutRomFile(){
        searchThread=new Thread(new Runnable() {
            @Override
            public void run() {
                searchManager.setOnFileSearchListener(searchListener);
                searchManager.startSearchFromOutRom(FileMangerActivity.this);
            }
        });
        searchThread.start();
    }
    private FileSearchManager.OnFileSearchListener searchListener=new FileSearchManager.OnFileSearchListener() {
        @Override
        public void onSearchStart(int searchLocationRom) {
            handler.sendEmptyMessage(0);

        }

        @Override
        public void onSearching(String fileType, long totalSize) {

            //保存文件大小
            FileMangerActivity.this.totalSize=totalSize;
            //给message赋值并发送过去
            Message message= handler.obtainMessage();
            message.what=1;
            message.obj=fileType;
            handler.sendMessage(message);

        }

        @Override
        public void onSearchEnd(boolean isExceptionEnd, int searchLocationRom) {
            //给message赋值并发送过去
            Message message= handler.obtainMessage();
            message.what=2;
            message.arg1=searchLocationRom;
            handler.sendMessage(message);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_manger);
        initView();
        setListener();
        loadTheData();
    }

    @Override
    public void initView() {
        setActionBarBack("文件管理");
        tv_size=(TextView) findViewById(R.id.filemanger_tv_size);
        button=(Button)findViewById(R.id.filemanger_button);
        listView=(ListView) findViewById(R.id.filemanger_lv);

    }

    @Override
    public void setListener() {
     findViewById(R.id.left_icon).setOnClickListener(this);
        button.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
       case R.id.left_icon:
        finish();
        break;
        case R.id.filemanger_button:
          button.setClickable(false);
            for(int i=0;i<adapter.getCount();i++){
                adapter.getItem(i).loadingOver=false;
            }
            adapter.notifyDataSetChanged();
            asyncSearchOutRomFile();
            break;
}
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String filetype=adapter.getItem(position).fileType;
        Intent intent=new Intent(this,FilemangerListviewitemNext.class);
        intent.putExtra("filetype",filetype);
        startActivity(intent);


    }
}
