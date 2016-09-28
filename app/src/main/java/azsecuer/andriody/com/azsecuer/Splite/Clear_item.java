package azsecuer.andriody.com.azsecuer.Splite;

import android.graphics.drawable.Drawable;

import azsecuer.andriody.com.azsecuer.R;

/**
 * Created by Administrator on 8/17 0017.
 */
public class Clear_item {
    public String softChineseName;
    public String softEnglishName;
    public String  filepath;
    public String softapkname;
    public boolean isChecked;
    public Drawable drawable;
    public String filesize;


    public Clear_item(String softChineseName, String softEnglishName, String filepath, String softapkname, boolean isChecked, Drawable drawable, String  filesize) {
        this.softChineseName = softChineseName;
        this.softEnglishName = softEnglishName;
        this.filepath = filepath;
        this.softapkname = softapkname;
        this.isChecked = isChecked;
        this.drawable = drawable;
        this.filesize = filesize;
    }
}
