package wlj.myapplication.room_test.upgrade_database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/6/4.
 * 说明：这个User2比版本1的User多了一个age，这里进行数据库升级操作
 *
 * Room数据库实体类，会与数据库表column字段 进行映射
 *
 * 注解@Entity(tableName = "user", indices = {})
 * @Entity()
 * ================================================
 */
@Entity(tableName = "user", indices = {})
public class User2 {

    //start-------------------------------bean中的变量，相当于数据库的字段
    @PrimaryKey(autoGenerate = true)//主键(自增长)
    @ColumnInfo(name = "uid")//定义在表中的字段名为：uid
    private int uid;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "age")
    private int age;
    //end-------------------------------bean中的变量，相当于数据库的字段


    //start-------------------------------构造方法，只能有一个，若有多个，
    // 需要@Ignore注解修饰，意思是这个不放进数据库表中作为字段
    public User2() { }
    @Ignore
    public User2(int uid) {
        this.uid = uid;
    }
    @Ignore
    public User2(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Ignore
    public User2(int uid, String firstName, String lastName) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Ignore
    public User2(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    @Ignore
    public User2(int uid, String firstName, String lastName, int age) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //end-------------------------------Room执行需要getXxx()  setXxx()方法


    //这个就不是数据库的东西了，是javabean中的方法，方便打印什么的吧
    @Override
    public String toString() {
        return "User3 { " +
                "uid=" + uid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

}