package zhuoxin.andriody.com.gitdroid.retrofit;

/**
 * Created by Administrator on 9/28 0028.
 */
public class UserResult {

    /**
     * reason : 查询城市
     * result : {}
     */

    private String reason;
    private ResultBean result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
    }
}
