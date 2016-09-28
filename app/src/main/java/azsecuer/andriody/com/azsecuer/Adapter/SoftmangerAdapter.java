package azsecuer.andriody.com.azsecuer.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.util.Logutil;
import azsecuer.andriody.com.azsecuer.util.SoftwareBrowseInfo;

/**
 * Created by Administrator on 8/23 0023.
 */
public class SoftmangerAdapter extends BaseAdapter {

    private List<SoftwareBrowseInfo>list;
    private Context context;
    private LayoutInflater inflater;
    public SoftmangerAdapter(Context context){
        this.context=context;
        inflater=((Activity)context).getLayoutInflater();
        list=new ArrayList<>();
    }
    public void setDatas(List<SoftwareBrowseInfo>list){
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodle viewhodle=null;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.softmanger_appdome,null);
            viewhodle=new ViewHodle();
            viewhodle.img=(ImageView) convertView.findViewById(R.id.iv_soft_icon);
            viewhodle.tv_lable=(TextView) convertView.findViewById(R.id.tv_soft_lable);
            viewhodle.tv_packagename=(TextView) convertView.findViewById(R.id.tv_soft_packagename);
            viewhodle.tv_sysnumber=(TextView) convertView.findViewById(R.id.tv_soft_sysnumber);
            convertView.setTag(viewhodle);
        }else{
            viewhodle=(ViewHodle) convertView.getTag();
        }
        SoftwareBrowseInfo softwareBrowseInfo=(SoftwareBrowseInfo) getItem(position);
        viewhodle.tv_lable.setText(softwareBrowseInfo.lable);
        viewhodle.tv_packagename.setText(softwareBrowseInfo.packagename);
        viewhodle.tv_sysnumber.setText(softwareBrowseInfo.version);
        viewhodle.img.setImageDrawable(softwareBrowseInfo.drawable);
        Logutil.p("---","单个数据"+softwareBrowseInfo.lable);
        return convertView;
    }
    class ViewHodle{
        ImageView img;
        TextView tv_lable,tv_packagename,tv_sysnumber;

        @Override
        public String toString() {
            return "ViewHodle{" +
                    "img=" + img +
                    ", tv_lable=" + tv_lable +
                    ", tv_packagename=" + tv_packagename +
                    ", tv_sysnumber=" + tv_sysnumber +
                    '}';
        }
    }
}
