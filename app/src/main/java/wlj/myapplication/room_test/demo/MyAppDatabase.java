package wlj.myapplication.room_test.demo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/6/4.
 * 说明：提供直接访问底层数据库实现，这里拿到具体的Dao,进行数据库操作
 *
 * 注解 @Database(entities = {User.class}, version = 1)
 *
 * @Database ( 实体类(在数据库中的表)  ,   版本号)：
 *          实现这个类，得到一个数据库，得到一个数库操作对象
 *
 *          entities:指定实体类(相当于数据库的表)
 *          version:指定数据库版本号，当迁移数据库或者数据库版本升级时，
 *                       要改变这个值，当然还要在这个类里面进行数据库迁移操作
 * ================================================
 */
@Database(entities = {User.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {
    //activity中实现这个方法  得到这个接口的对象  即可操作数据库
    public abstract UserDao userDao();
}
