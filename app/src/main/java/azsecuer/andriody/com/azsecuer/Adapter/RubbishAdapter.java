package azsecuer.andriody.com.azsecuer.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.Splite.Clear_item;
import azsecuer.andriody.com.azsecuer.Splite.phonenumber;

/**
 * Created by Administrator on 8/17 0017.
 */
public class RubbishAdapter extends BaseAdapter {
    private List<Clear_item> list;
    private Context context;
    private LayoutInflater inflater;
    public RubbishAdapter (Context context){
        this.context=context;
        inflater=((Activity)context).getLayoutInflater();
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
    public void setDatas(List<Clear_item> e){
        this.list = e;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder v=null;
        if(convertView==null){
            v=new ViewHolder();
            convertView=inflater.inflate(R.layout.clear_listview_itme,null);
            v.checkBox=(CheckBox) convertView.findViewById(R.id.clear_checkbox);
            v.img=(ImageView)convertView.findViewById(R.id.clear_img);
            v.tv_title=(TextView)convertView.findViewById(R.id.clear_tvname);
            v.tv_size=(TextView)convertView.findViewById(R.id.clear_tvsize);
            convertView.setTag(v);
        }else{
            v=(ViewHolder) convertView.getTag();
        }
        Clear_item item=(Clear_item)getItem(position);
        v.tv_title.setText(item.softChineseName);
        v.tv_size.setText(item.filesize+"");
        v.img.setImageDrawable(item.drawable);
        v.checkBox.setTag(item);
        v.checkBox.setChecked(item.isChecked);
        v.checkBox.setOnCheckedChangeListener(checkedChangeListener);
        return convertView;
    }
    class ViewHolder {
        ImageView img;
        CheckBox checkBox;
        TextView tv_title,tv_size;
    }
    private CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // 根据Tag中的值去修改相应的操作
            ((Clear_item)buttonView.getTag()).isChecked = isChecked;
        }
    };
}
