package wlj.myapplication.databinding.bean;
/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/8/28.
 * 说明：DataBinddingActivity数据
 * ================================================
 */
public class UserBean {
    private String name; //姓名
    private String pwd; //密码

    public UserBean(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}