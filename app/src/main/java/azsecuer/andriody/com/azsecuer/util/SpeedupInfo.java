package azsecuer.andriody.com.azsecuer.util;

import android.graphics.drawable.Drawable;

public class SpeedupInfo {

	public String processName;
	public Drawable icon; // 图标
	public String label;// 标签
	public long memory;
	public boolean isSelected;
	public boolean isSystemApp;

	public SpeedupInfo(String processName) {
		super();
		this.processName = processName;

	}
	public SpeedupInfo(String processName, Drawable icon, String label, long memory, boolean isSystemApp) {
		super();
		this.processName = processName;
		this.icon = icon;
		this.label = label;
		this.memory = memory;
		this.isSystemApp = isSystemApp;
		this.isSelected = false;
	}

	@Override
	public String toString() {
		return "SpeedupInfo{" +
				"processName='" + processName + '\'' +
				", icon=" + icon +
				", label='" + label + '\'' +
				", memory=" + memory +
				", isSelected=" + isSelected +
				", isSystemApp=" + isSystemApp +
				'}';
	}
}
