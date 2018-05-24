package wlj.myapplication.lifecycle_livedata_mvvm.bean;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/18.
 * 说明：数据bean类
 * ================================================
 */

public class A_User {
    private int id;
    private String name;

    public A_User() {
    }

    public A_User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
