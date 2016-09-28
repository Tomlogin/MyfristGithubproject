package azsecuer.andriody.com.azsecuer.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.Splite.MobliemgrChild;
import azsecuer.andriody.com.azsecuer.Splite.MobliemgrGroup;

/**
 * Created by Administrator on 8/16 0016.
 */
public class MobliemgrAdapter extends BaseExpandableListAdapter {
    private List<MobliemgrGroup> groups;
    private Map<String,List<MobliemgrChild>> children;
    private Context context;
    private LayoutInflater inflater;
    public MobliemgrAdapter(Context context){
        this.context=context;
        inflater=((Activity)context).getLayoutInflater();
        groups=new ArrayList<>() ;
        children=new HashMap<>();
    }
    public void addDataToAdapter(MobliemgrGroup group,List<MobliemgrChild> child){
        groups.add(group);
        children.put(group.tv_group,child);
    }
    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return children.get(groups.get(groupPosition).tv_group).size();
    }

    @Override
    public MobliemgrGroup getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public MobliemgrChild getChild(int groupPosition, int childPosition) {
        return children.get(groups.get(groupPosition).tv_group).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        convertView=inflater.inflate(R.layout.mobliemgrgroupdome,null);
        MobliemgrGroup temp=getGroup(groupPosition);
        ImageView img=((ImageView) convertView.findViewById(R.id.iv_group));
        img.setImageDrawable(temp.iv_group);
        TextView tv=(TextView) convertView.findViewById(R.id.tv_group);
        tv.setText(temp.tv_group);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.mobliemgrchilddome,null);
        MobliemgrChild temp=getChild(groupPosition,childPosition);
        TextView tv_title=(TextView) convertView.findViewById(R.id.tv_child_tilte);
        tv_title.setText(temp.tv_title);
        TextView tv_content=(TextView) convertView.findViewById(R.id.tv_child_content);
        tv_content.setText(temp.tv_content);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
