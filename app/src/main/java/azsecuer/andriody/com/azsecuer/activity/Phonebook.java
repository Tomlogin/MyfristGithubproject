package azsecuer.andriody.com.azsecuer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import azsecuer.andriody.com.azsecuer.Adapter.PhonetypeAdapter1;
import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.mar.DBmanger;
import azsecuer.andriody.com.azsecuer.Splite.phonetypedemo;
import azsecuer.andriody.com.azsecuer.util.CopyDB;
import azsecuer.andriody.com.azsecuer.util.Logutil;


/**
 * Created by Administrator on 2016/8/5.
 */
public class Phonebook extends BaseActionBarActivity implements AdapterView.OnItemClickListener{
    private ListView listview;
    private ImageView imgback;
    private List<Map<String,Object>> data;
    private List<phonetypedemo> list;
    private PhonetypeAdapter1 adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonebook);

        try {
            DBmanger.initdatabase(this);
            if(DBmanger.file.length() == 0){
                CopyDB.copy(this,"commonnum.db",DBmanger.file);
            }

        } catch (IOException e) {
            e.printStackTrace();
            Logutil.p("Test",e.toString());
        }
        initView();
        Logutil.p("Test","-"+DBmanger.file.length());
        list=DBmanger.readclasslist();
        adapter1=new PhonetypeAdapter1(this);
        adapter1.setDatas(list);
        listview.setAdapter(adapter1);





//      MyAdapter myAdapter=new MyAdapter();
//       listview.setAdapter(myAdapter);
//        String[] from = { "1", "2"};// keys
//		int[] to = { R.id.tv_dome, R.id.imgview }; // id
//		SimpleAdapter adapter = new SimpleAdapter(this, // 上下文对象
//				data, // 数据源
//				R.layout.activity_phonebookdome, // 布局文件
//				from,// 所有的key
//				to);// 要对应到的控件id
//		listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);


    }

    @Override
    public void initView() {
        listview=(ListView)findViewById(R.id.listview);
        imgback=(ImageView) findViewById(R.id.phonebook_back);
        imgback.setOnClickListener(this);
//        data=new ArrayList<Map<String, Object>>();
//        Map<String, Object> m= new HashMap<String, Object>();
//        m.put("1","订餐电话");
//        m.put("2",R.drawable.ic_arrows_right);
//        data.add(m);
//        m= new HashMap<String, Object>();
//        m.put("1","公共服务");
//        m.put("2",R.drawable.ic_arrows_right);
//        data.add(m);
//        m= new HashMap<String, Object>();
//        m.put("1","运营商");
//        m.put("2",R.drawable.ic_arrows_right);
//        data.add(m);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this,Phonebook_next.class);
        Bundle bundle = new Bundle();
        bundle.putInt("idx",((phonetypedemo)adapter1.getItem(position)).getIdx());
        intent.putExtras(bundle);
        startActivity(intent,bundle);
//        Map<String, Object> m= new HashMap<String, Object>();
//        m=data.get(position);
//        Bundle bundle=new Bundle();
//        bundle.putString("type",(String)m.get("1"));
//        Toast.makeText(this,"跳转",Toast.LENGTH_SHORT).show();
//        Intent intent=new Intent(this,Phonebook_next.class);
//        intent.putExtras(bundle);
//        startActivity(intent);
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater inflater=Phonebook.this.getLayoutInflater();
            View v=inflater.inflate(R.layout.activity_phonebookdome,null);
            TextView tv_dome=(TextView) findViewById(R.id.tv_dome);
            ImageView imgicon=(ImageView)findViewById(R.id.imgview);
            imgicon.setImageResource(R.drawable.ic_arrows_right);
            Map<String,Object> m =data.get(position);
            tv_dome.setText((String)m.get("1"));
            imgicon.setImageResource((Integer)m.get("2"));
            return v;
        }
    }

    @Override
    public void setListener() {
//        listview.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
switch (view.getId()){
    case R.id.phonebook_back:
        finish();
        break;
}

    }
}

