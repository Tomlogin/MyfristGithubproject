package azsecuer.andriody.com.azsecuer.Adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.Splite.phonetypedemo;

/**
 * Created by Administrator on 8/12 0012.
 */
public class PhonetypeAdapter1 extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<phonetypedemo> list;
    public PhonetypeAdapter1(Context context){
        this.context = context;
        this.inflater = ((Activity)context).getLayoutInflater();
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.phonebooknext, null);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.next_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        phonetypedemo typeInfo = (phonetypedemo) this.getItem(position);
        holder.textView.setText(typeInfo.getName());//设置数据
        return convertView;
    }
    public void setDatas(List<phonetypedemo> e){
        this.list = e;
    }

    class ViewHolder {
        TextView textView;
    }
}