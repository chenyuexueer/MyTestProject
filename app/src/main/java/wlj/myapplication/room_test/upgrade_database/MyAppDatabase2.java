package wlj.myapplication.room_test.upgrade_database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/6/4.
 * 说明：升级数据库
 *
 * 提供直接访问底层数据库实现，这里拿到具体的Dao,进行数据库操作
 *
 * 注解 @Database(entities = {User3.class}, version = 2)
 *
 * @Database ( 实体类(在数据库中的表)  ,   版本号)：
 *          实现这个类，得到一个数据库，得到一个数库操作对象
 *
 *          entities:指定实体类(相当于数据库的表)
 *          version:指定数据库版本号，当迁移数据库或者数据库版本升级时，
 *                       要改变这个值，当然还要在这个类里面进行数据库迁移操作
 * ================================================
 */
@Database(entities = {User2.class}, version = 2)
public abstract class MyAppDatabase2 extends RoomDatabase {

    //activity中实现这个方法  得到这个接口的对象  即可操作数据库
    public abstract UserDao2 userDao2();

    //数据库变动添加Migration
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            //给数据库添加有个列 age字段 如果不存在 默认值为0
            database.execSQL("ALTER TABLE user "
                    + " ADD COLUMN age INTEGER NOT NULL DEFAULT 0");
        }
    };
}
