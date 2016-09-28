package azsecuer.andriody.com.azsecuer.util;

/**
 * @author: leejohngoodgame
 * @date: 2016/8/24 14:57
 * @email:18328541378@163.com
 * 遍历文件的约定
 */
public interface IFileSearch {
    /**
     *
     * @param srachLoactionRomPath 决定搜索的路径 内置 外置
     */
     void onFileSearchStart(int srachLoactionRomPath);

    /**
     *
     * @param size 文件的大小
     * @param fileType w文件的类型
     */
     void onFileSearching(long size, String fileType);

     void onFileSearchStop(int srachLoactionRomPath);

}
