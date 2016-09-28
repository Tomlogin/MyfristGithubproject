package azsecuer.andriody.com.azsecuer.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.util.PublicUtils;
import azsecuer.andriody.com.azsecuer.util.SpeedupInfo;

/**
 * Created by Administrator on 2016/8/20.
 */
public class MyAdapter extends BaseAdapter {
    private List<SpeedupInfo> list;
    private Context context;
    private LayoutInflater inflater;
    public MyAdapter(Context context){
        this.context=context;
        this.list = new ArrayList<>();
        inflater=((Activity)context).getLayoutInflater();
    }
    public List<SpeedupInfo> getDataFromAdapter() {
        return list;
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
    public void setDatas(List<SpeedupInfo> list){
        this.list=list;
    };

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.inflate_speedup_listitem_user,null);
            viewHolder=new ViewHolder();
            viewHolder.cb_proc_checked=(CheckBox) convertView.findViewById(R.id.cb_speedup_clear);
            viewHolder.iv_proc_icon=(ImageView) convertView.findViewById(R.id.iv_speedup_icon);
            viewHolder.tv_proc_name=(TextView) convertView.findViewById(R.id.tv_speedup_lable);
            viewHolder.tv_proc_mem=(TextView) convertView.findViewById(R.id.tv_speedup_memory);
            convertView.setTag(viewHolder);

        }else{
            viewHolder=(ViewHolder)convertView.getTag();


        }
        SpeedupInfo speedupInfo=(SpeedupInfo)getItem(position);
        viewHolder.cb_proc_checked.setChecked(speedupInfo.isSelected);
        viewHolder.cb_proc_checked.setTag(speedupInfo);
        viewHolder.cb_proc_checked.setOnCheckedChangeListener(onCheckedChangeListener);
        viewHolder.iv_proc_icon.setImageDrawable(speedupInfo.icon);
        viewHolder.tv_proc_name.setText(speedupInfo.label);
        viewHolder.tv_proc_mem.setText(PublicUtils.formatSize(speedupInfo.memory));
        return convertView;
    }
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener=new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
           SpeedupInfo speedupInfo=(SpeedupInfo) buttonView.getTag();
            speedupInfo.isSelected=isChecked;
        }
    };
    class ViewHolder{
        TextView tv_proc_name,tv_proc_mem,tv_is_sys_proc;
        ImageView iv_proc_icon;
        CheckBox cb_proc_checked;



    }
}
