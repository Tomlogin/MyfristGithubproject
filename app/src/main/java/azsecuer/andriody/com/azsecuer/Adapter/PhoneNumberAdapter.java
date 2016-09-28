package azsecuer.andriody.com.azsecuer.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.Splite.phonenumber;
import azsecuer.andriody.com.azsecuer.Splite.phonetypedemo;

/**
 * Created by Administrator on 8/12 0012.
 */
public class PhoneNumberAdapter extends BaseAdapter {
    private List<phonenumber> list;
    private Context context;
    private LayoutInflater inflater;
    public PhoneNumberAdapter (Context context){
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
    public void setDatas(List<phonenumber> e){
        this.list = e;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoler viewHoler=null;
        if(convertView==null){
            viewHoler=new ViewHoler();
            convertView=inflater.inflate(R.layout.phonecall,null);
            viewHoler.phonename=(TextView) convertView.findViewById(R.id.phonecall_tvone);
            viewHoler.phonenumber=(TextView)convertView.findViewById(R.id.phonecall_tvtwo);
            convertView.setTag(viewHoler);
        }else {

        viewHoler=(ViewHoler) convertView.getTag();
        }
        phonenumber phonenumber=(phonenumber) this.getItem(position);
        viewHoler.phonename.setText(phonenumber.getName());
        viewHoler.phonenumber.setText(phonenumber.getPhonenumber());

        return convertView;
    }
    class ViewHoler{
        TextView phonename,phonenumber;
    }
}
