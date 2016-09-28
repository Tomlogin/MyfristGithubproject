package azsecuer.andriody.com.azsecuer.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.Splite.phonetypedemo;

/**-----------------已过期的自定义适配器---------------
 * Created by Administrator on 8/9 0009.
 */
public class PhonebookAdapter extends BaseAdapter {
    private List<phonetypedemo> list;
    private Context context;
    private int layoutid;
    private phonetypedemo phonedemo;
    public PhonebookAdapter(Context context, int layoutid, List<phonetypedemo> list){
        this.context=context;
        this.layoutid=layoutid;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            //解析每一项的布局文件
          convertView= LayoutInflater.from(context).inflate(layoutid,null);
        }
        phonedemo=(phonetypedemo) getItem(position);
        TextView phonecall_tvone=(TextView)convertView.findViewById(R.id.phonecall_tvone);
        TextView phonecall_tvtwo=(TextView)convertView.findViewById(R.id.phonecall_tvtwo);
        phonecall_tvone.setText(phonedemo.getName());
//        phonecall_tvtwo.setText(phonedemo.getPhonenumber());
        return convertView;
    }
}
