package zhuoxin.andriody.com.gitdroid.gitretrofit;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zhuoxin.andriody.com.gitdroid.R;
import zhuoxin.andriody.com.gitdroid.retrofit.GitPresenter;
import zhuoxin.andriody.com.gitdroid.retrofit.GitView;

public class GitRetrofitActivity extends AppCompatActivity implements GitView {
    private ProgressDialog progressDialog;
    private List<Tudou.ResultBean.DataBean> data;
    private ArrayAdapter<String> adapter;
    @Bind(R.id.progressbar)
    ProgressBar progressbar;
    @Bind(R.id.listview)
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_retrofit);
        ButterKnife.bind(this);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listview.setAdapter(adapter);
    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(GitRetrofitActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(List<Tudou.ResultBean.DataBean> data) {
        for (Tudou.ResultBean.DataBean databean : data) {
            adapter.add(databean.getTitle());
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
        listview.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgress() {
        progressDialog = ProgressDialog.show(this, "", "加载中...");
        listview.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.btnGet)
    public void onClick() {
        new GitPresenter(this).getData(this);
    }
}
