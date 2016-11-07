package zhuoxin.andriody.com.gitdroid.retrofit;

import java.util.List;

import zhuoxin.andriody.com.gitdroid.gitretrofit.Tudou;

/**
 * Created by Administrator on 9/29 0029.
 */
public interface GitView {
    void showMessage(String s);

    void setData(List<Tudou.ResultBean.DataBean> data);

    void hideProgress();

    void showProgress();
}
