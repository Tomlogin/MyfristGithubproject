package azsecuer.andriody.com.azsecuer.Splite;

/**
 * Created by Administrator on 8/9 0009.
 */
public class phonetypedemo {
   private String name;
    private int idx;

    @Override
    public String toString() {
        return "phonetypedemo{" +
                "name='" + name + '\'' +
                ", idx=" + idx +
                '}';
    }

    public phonetypedemo(String name, int idx) {
        this.name = name;
        this.idx = idx;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
}
