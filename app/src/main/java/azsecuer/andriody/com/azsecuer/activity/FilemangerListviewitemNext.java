package azsecuer.andriody.com.azsecuer.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import azsecuer.andriody.com.azsecuer.Adapter.FileBrowseAdapter;
import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.mar.FileSearchManager;
import azsecuer.andriody.com.azsecuer.util.FileInfo;
import azsecuer.andriody.com.azsecuer.util.Logutil;
import azsecuer.andriody.com.azsecuer.util.PublicUtils;

public class FilemangerListviewitemNext extends BaseActionBarActivity implements AdapterView.OnItemClickListener,CompoundButton.OnCheckedChangeListener {
    private TextView filenumber,filesize;
    private ListView listView;
    private CheckBox checkBox;
    private Button button;
    private String fileType;
    private FileSearchManager searchManager;
    private HashMap<String,Long>fileSizes;
    private HashMap<String,ArrayList<FileInfo>>fileInfos;
    private ArrayList<FileInfo> list;
    private FileBrowseAdapter browseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filemanger_listviewitem_next);
        initView();
        setListener();
        initData();
    }
    public void initData(){
// 取得FileServcieActivity传入的文件类型
        fileType = getIntent().getStringExtra("filetype");
        Logutil.p(">>>>","---"+fileType);
        // 取得文件列表数据信息
        searchManager = FileSearchManager.getInstance(false);
        fileInfos = searchManager.getFileInfos(); // 文件实体集合(Map)
        list=fileInfos.get(fileType);
        fileSizes = searchManager.getFileSizes(); // 文件大小集合(Map)
        long size = fileSizes.get(fileType);
        long count = fileInfos.get(fileType).size();
        // 将文件列表数量和大小分别设置到对应的文件控件上
        filenumber.setText("" + count);
        filesize.setText(PublicUtils.formatSize(size));
        // 将文件实体集合数据适配到文件列表控件上
        browseAdapter = new FileBrowseAdapter(this, listView);
        browseAdapter.addDataToAdapter(fileInfos.get(fileType));
        listView.setAdapter(browseAdapter);
}
    @Override
    public void initView() {
        setActionBarBack( "文件浏览");
        filenumber=(TextView) findViewById(R.id.filenumber);
        filesize=(TextView) findViewById(R.id.filesize);
        button=(Button) findViewById(R.id.spead_buttontwo);
        listView=(ListView) findViewById(R.id.filemager_listitem_nextlistview);
        checkBox=(CheckBox) findViewById(R.id.spead_checkbox);
        button.setTag("删除所选文件");
    }

    @Override
    public void setListener() {
findViewById(R.id.left_icon).setOnClickListener(this);
        checkBox.setOnCheckedChangeListener(this);
        button.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
      switch (v.getId()) {
          case R.id.left_icon:
              finish();
              break;
          case R.id.spead_buttontwo:
              // TODO: 8/26 00
              Toast.makeText(this,"有效",Toast.LENGTH_SHORT).show();
              List<FileInfo> l = new ArrayList<>();
              for(int i=0;i<list.size();i++){
                  if(list.get(i).isSelect){
                      l.add(list.get(i));
                  }
              }
             list.removeAll(l);
             browseAdapter.notifyDataSetChanged();
              break;
      }
}


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        for(int i=0;i<browseAdapter.getCount();i++){
            browseAdapter.getItem(i).isSelect=isChecked;
        }
        browseAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"有效onitem",Toast.LENGTH_SHORT).show();
       FileInfo fileInfo = browseAdapter.getItem(position);
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        Uri data = Uri.fromFile(fileInfo.file);
//        String type = fileInfo.openType;
//        intent.setDataAndType(data, type);
//        startActivity(intent);
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);//构造一个dialog
        dialog.setTitle("拨号提示")//设置标题
                .setMessage("是否拨打："+fileInfo.iconName)//设置类容
                //给拨号按钮天添加点击事件
                .setNegativeButton("拨号", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:"+1111));
                       startActivity(intent);
                    }
                })
                //取消按钮
                .setPositiveButton("取消",null)
                //设置为true可以取消
                .setCancelable(true);
        dialog.show();
    }
}
