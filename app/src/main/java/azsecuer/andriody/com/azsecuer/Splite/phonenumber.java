package azsecuer.andriody.com.azsecuer.Splite;

/**
 * Created by Administrator on 8/11 0011.
 */
public class phonenumber {
    private String name,phonenumber;
    public phonenumber(String name, String phonenumber){
        this.name=name;
        this.phonenumber=phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "phonetypedemo{" +
                "name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
