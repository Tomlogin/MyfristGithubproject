package azsecuer.andriody.com.azsecuer.util;

import android.graphics.drawable.Drawable;


//            软件
public class SoftwareBrowseInfo {
	
	public String lable;
	public String packagename;
	public String version;
	public Drawable drawable;
	public boolean isSelected;
	
	public SoftwareBrowseInfo(){}

	public SoftwareBrowseInfo(String lable, String packagename, String version, Drawable drawable) {
		this.lable = lable;
		this.packagename = packagename;
		this.version = version;
		this.drawable = drawable;
		this.isSelected = false;
	}

	@Override
	public String toString() {
		return "SoftwareBrowseInfo{" +
				"lable='" + lable + '\'' +
				", packagename='" + packagename + '\'' +
				", version='" + version + '\'' +
				", drawable=" + drawable +
				", isSelected=" + isSelected +
				'}';
	}
}
