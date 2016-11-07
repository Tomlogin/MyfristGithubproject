package zhuoxin.andriody.com.gitdroid.okhttpgetandpost;

import okhttp3.Call;
import zhuoxin.andriody.com.gitdroid.okhttppost.User;

/**
 * Created by Administrator on 9/27 0027.
 */
public interface Oncall {
    Call postmeth(User user);

    Call getmeth();
}
