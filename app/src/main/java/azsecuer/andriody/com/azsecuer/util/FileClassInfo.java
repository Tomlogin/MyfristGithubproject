package azsecuer.andriody.com.azsecuer.util;

import android.graphics.drawable.Drawable;

import azsecuer.andriody.com.azsecuer.R;

public class FileClassInfo {
	/** 当前种类文件分类名称(音频文件?图像文件?APK文件?) */
	public String typeName;
	/** 当前种类文件类型<KEY> (音频?图像?APK?) */
	public String fileType;
	/** 当前种类文件大小 */
	public long size;
	/** 当前种类文件加载是否结束 */
	public boolean loadingOver;
	public int  drawable;
	public FileClassInfo(){}
	public FileClassInfo(String typeName, String fileType) {
		super();
		this.typeName = typeName;
		this.fileType = fileType;
		this.loadingOver = false;
		this.size = 0;
		drawable=R.drawable.ic_arrows_right;

	}

	@Override
	public String toString() {
		return "FileClassInfo{" +
				"typeName='" + typeName + '\'' +
				", fileType='" + fileType + '\'' +
				", size=" + size +
				", loadingOver=" + loadingOver +
				'}';
	}
}
