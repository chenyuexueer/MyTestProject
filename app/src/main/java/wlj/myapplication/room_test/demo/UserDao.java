package wlj.myapplication.room_test.demo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/6/4.
 * 说明：数据库访问对象，实现具体的增删改查      数据库语句
 *
 * @Dao：注解配置sql语句
 *              这里提前定义了各种操作数据库的语句与返回值
 * ================================================
 */
@Dao
public interface UserDao {
    //下面所有的CURD根据primary key(主键)进行匹配


    //start------------------------query查询------------------------
    /**
     *查询user表所有数据
     *
     * @return
     */
    @Query("SELECT * FROM user")
    List<User> getUserAll();//查询方法返回

    /**
     * 根据uid数组查询多个数据，返回list集合
     *
     * @param uids 下面的  查询方法getUserByids(userIds)  传进来的
     * @return
     */
    @Query("SELECT * FROM user WHERE uid IN (:uids)")
    List<User> getUserByids(int[] uids);//查询方法返回

    /**
     * 如果看不懂就去看一下数据库知识
     *
     * LIKE：模糊查询
     * AND：只有当所有条件都为真（true）时，整个条件为真（true）
     * LIMIT：限制由 SELECT 语句返回的数据数量。
     *
     * @param firstName 下面的  getUserByFirst_Last_Name(firstName,lastName)  传进来的
     * @param lastName  下面的  getUserByFirst_Last_Name(firstName,lastName)  传进来的
     * @return
     */
    @Query("SELECT * FROM user WHERE first_name LIKE :firstName AND last_name LIKE :lastName LIMIT 1")
    User getUserByFirst_Last_Name(String firstName,String lastName);

    /**
     *根据uid查询user数据，返回一个user
     *
     * @param uid
     * @return
     */
    @Query("SELECT * FROM user WHERE uid=:uid")
    User getUserByUid(int uid);
    //end------------------------query查询------------------------


    //start------------------------insert插入------------------------
    /**
     *
     * OnConflictStrategy.REPLACE ：如果已有数据，就覆盖掉,没有就插入
     *
     * @param user  通过user主键 uid 进行匹配，不是拿整个user对象进行匹配
     * @return          插入条目的主键值（uid）即  user插入到那个uid对应地方
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertUser(User user);


    /**
     *  OnConflictStrategy.REPLACE ：如果已有数据，就覆盖掉,没有就插入
     *
     * @param users     不确定个数的users
     * @return              返回被插入数据的主键uid列表
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertUsers1(User... users);


    /**
     * OnConflictStrategy.REPLACE ：如果已有数据，就覆盖掉,没有就插入
     *
     * @param users     确定个数的users
     * @return              返回被插入数据的主键uid列表
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertUsers2(List<User> users);
    //end------------------------insert插入------------------------


    //start------------------------update更新------------------------
    /**
     *
     * 更新一个已有user数据，根据主键（uid）匹配，
     * 而不是拿整个user对象进行匹配
     *
     * @param user  一个user
     * @return          返回更新条目数量，这个可不是  主键uid的值，可以理解为影响条数
     */
    @Update()
    int updateUser(User user);

    /**
     *
     * 更新 不确定数量 已有user 数据，根据主键（uid）匹配，
     * 而不是拿整个user对象进行匹配
     *
     * @param user  一个user
     * @return          返回更新条目数量，这个可不是  主键uid的值，可以理解为影响条数
     */
    @Update()
    int updateUsers1(User... user);

    /**
     *
     * 更新 确定数量 已有user 的数据，根据主键（uid）匹配，
     * 而不是拿整个user对象进行匹配
     *
     * @param user  一个user
     * @return          返回更新条目数量，这个可不是  主键uid的值，可以理解为影响条数
     */
    @Update()
    int updateUsers2(List<User> user);
    //end------------------------update更新------------------------


    //start------------------------delete删除------------------------

    /**
     * 删除 一个 user 数据，通过主键uid匹配，而不是拿整个user对象进行匹配。
     *
     * @param user  一个user
     * @return  删除了多少条。不是主键uid值，可以理解为影响条数
     */
    @Delete
    int deleteUser(User user);

    /**
     * 删除 不确定数量 user 数据，通过主键uid匹配，而不是拿整个user对象进行匹配。
     *
     * @param users  不确定数量个user
     * @return            删除了多少条。不是主键uid值，可以理解为影响条数
     */
    @Delete
    int deleteUsers1(List<User> users);

    /**
     * 删除 确定数量 user 数据，通过主键uid匹配，而不是拿整个user对象进行匹配。
     *
     * @param users  确定数量个user
     * @return            删除了多少条。不是主键uid值，可以理解为影响条数
     */
    @Delete
    int deleteUsers2(User... users);
    //end------------------------delete删除------------------------
}
