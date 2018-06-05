package wlj.myapplication.room_test.demo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/6/4.
 * 说明：Room数据库实体类，会与数据库表column字段 进行映射
 *
 * 注解@Entity(tableName = "user", indices = {})
 * @Entity()
 * ================================================
 */
@Entity(tableName = "user", indices = {})
public class User {

    //start-------------------------------bean中的变量，相当于数据库的字段
    @PrimaryKey(autoGenerate = true)//主键(自增长)
    @ColumnInfo(name = "uid")//定义在表中的字段名为：uid
    private int uid;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;
    //end-------------------------------bean中的变量，相当于数据库的字段


    //start-------------------------------构造方法，只能有一个，若有多个，
    // 需要@Ignore注解修饰，意思是这个不放进数据库表中作为字段
    public User() { }
    @Ignore
    public User(int uid) {
        this.uid = uid;
    }
    @Ignore
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Ignore
    public User(int uid, String firstName, String lastName) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //end-------------------------------构造方法，只能有一个，若有多个，需要@Ignore注解修饰


    //start-------------------------------Room执行需要getXxx()  setXxx()方法
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //end-------------------------------Room执行需要getXxx()  setXxx()方法


    //这个就不是数据库的东西了，是javabean中的方法，方便打印什么的吧
    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
