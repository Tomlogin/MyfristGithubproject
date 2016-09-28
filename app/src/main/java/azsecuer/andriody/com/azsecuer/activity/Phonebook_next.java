package azsecuer.andriody.com.azsecuer.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import azsecuer.andriody.com.azsecuer.Adapter.PhoneNumberAdapter;
import azsecuer.andriody.com.azsecuer.Adapter.PhonebookAdapter;
import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.mar.DBmanger;
import azsecuer.andriody.com.azsecuer.Splite.phonenumber;


public class Phonebook_next extends BaseActionBarActivity implements AdapterView.OnItemClickListener{
    private ListView  phonebook_next;

    private PhoneNumberAdapter adapter;
 private ListView listView;
    private ImageView left_icon;
    private PhonebookAdapter phonebookAdapter;
    private List<phonenumber> list;
    private Bundle bundle;
    private  String type;
    private phonenumber phonenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonebook_next);

        initData();
        initView();
        setListener();

//        initView();
//        setListener();
//        Intent intent=this.getIntent();
//        if(intent!=null){
//            bundle=intent.getExtras();
//            type=bundle.getString("type");
//            setActionBarBack(type);
//        }
//        if("订餐电话".equals(type)){
//            dataone();
//        }
//        if("公共服务".equals(type)){
//            datatwo();
//        }
//        phonebookAdapter=new PhonebookAdapter(this,R.layout.phonecall,list);
//       listView.setAdapter(phonebookAdapter);
    }
    void dataone(){

//        list.add(new phonetypedemo("杀牛场","123456789"));
    }
    void datatwo(){

   //     list.add(new phonetypedemo("电话亭","123456789"));
    }
    public void initData(){

        bundle = this.getIntent().getExtras();// 拿到Bundle
        int idx  =  bundle.getInt("idx");
        Log.i("Test","idx"+idx);
        list=DBmanger.readTabelNumber(idx);

        adapter = new PhoneNumberAdapter(this);
        adapter.setDatas(list);

    }
    @Override
    public void initView() {
        setActionBarBack("通讯大全");
        listView=(ListView) findViewById(R.id.phonebook_next_listview);
        listView.setAdapter(adapter);


//        Intent intent=this.getIntent();
//        if(intent!=null){
//            bundle=intent.getExtras();
//            type=bundle.getString("type");
//            setActionBarBack(type);
//        }
//        listView=(ListView) findViewById(R.id.phonebook_next_listview);
//        list=new ArrayList<phonetypedemo>();

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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

       showDiaog(position);
    }
        public void showDiaog(int position){
            phonenumber=(phonenumber) adapter.getItem(position);
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);//构造一个dialog
        dialog.setTitle("拨号提示")//设置标题
                .setMessage("是否拨打："+phonenumber.getName())//设置类容
            //给拨号按钮天添加点击事件
                .setNegativeButton("拨号", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:"+phonenumber.getPhonenumber()));
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
