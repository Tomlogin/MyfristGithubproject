package azsecuer.andriody.com.azsecuer.Adapter;

import java.util.ArrayList;
import java.util.HashMap;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import azsecuer.andriody.com.azsecuer.R;
import azsecuer.andriody.com.azsecuer.util.FileClassInfo;
import azsecuer.andriody.com.azsecuer.util.PublicUtils;

public class FileServiceAdapter extends BaseAdapter {
private Context context;
	private LayoutInflater layoutInflater;
	private ArrayList<FileClassInfo> dataList = new ArrayList<FileClassInfo>();

	public FileServiceAdapter(Context context) {
		this.context=context;
		layoutInflater = LayoutInflater.from(context);
	}

	public void addDataToAdapter(FileClassInfo fileClassInfo) {
		if (fileClassInfo != null) {
			dataList.add(fileClassInfo);
		}
	}

	@Override
	public int getCount() {
		return dataList.size();
	}

	@Override
	public FileClassInfo getItem(int position) {
		return dataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.inflate_fileservice_listitem, null);
		}
		TextView tv_title = (TextView) convertView.findViewById(R.id.filemager_listitem_tvname);
		TextView tv_size = (TextView) convertView.findViewById(R.id.filemager_listitem_tvsize);
		ImageView tv_arrow = (ImageView) convertView.findViewById(R.id.filemanger_listitem_img);
		ProgressBar pb_loading = (ProgressBar) convertView.findViewById(R.id.filemanger_listitem_pb);
		FileClassInfo info = getItem(position);
		tv_title.setText(info.typeName);
		if (info.loadingOver) {
			pb_loading.setVisibility(View.INVISIBLE);
			tv_arrow.setVisibility(View.VISIBLE);
			tv_size.setText(PublicUtils.formatSize(info.size));
		} else {
			pb_loading.setVisibility(View.VISIBLE);
			tv_arrow.setVisibility(View.INVISIBLE);
			tv_size.setText("计算中");
		}
		return convertView;
	}

}
