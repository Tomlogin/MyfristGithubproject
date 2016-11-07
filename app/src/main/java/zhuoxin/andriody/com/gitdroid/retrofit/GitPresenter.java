package zhuoxin.andriody.com.gitdroid.retrofit;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zhuoxin.andriody.com.gitdroid.gitretrofit.Tudou;

/**
 * Created by Administrator on 9/29 0029.
 */
public class GitPresenter {
    private GitView gitView;
    public GitPresenter(GitView gitView){
        this.gitView=gitView;
    }
    public void getData(final Context context){
        gitView.showProgress();
        String key="08b127d3d67bc05a617fe7aebf1d9670";
        NetRetrofitclient.getNetRetrofitclient().userregister(key,"土豆",10,3).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.e("test",response.body().string() );
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                if (response.isSuccessful()) {
//                    Tudou.ResultBean ResultBean = response.body();
//                    List<Tudou.ResultBean.DataBean> data = ResultBean.getData();
//                    if (data!=null) {
//                        gitView.setData(data);
//                        gitView.hideProgress();
//                        gitView.showMessage("请求成功");
//                    }
//                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                gitView.hideProgress();
                gitView.showMessage("失败了");
            }
        });
    }

}
