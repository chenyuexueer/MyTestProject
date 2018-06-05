package wlj.myapplication.room_test.upgrade_database;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import wlj.myapplication.R;
import wlj.myapplication.room_test.room_livedata_demo.RoomLivedataActivity;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/6/5.
 * 说明：升级数据库版本
 * ================================================
 */
public class UpgradeDatabaseActivity extends AppCompatActivity {

    private UserDao2 mUserDao2;//数据库语句
    private TextView mMsgTV;//展示打印信息
    private StringBuffer mBuffer;//存放打印信息
    private String TAG="RoomLivedataActivity==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade_database);

        //创建一个数据库(上下文，数据库操作类，数据库名称)
        MyAppDatabase2 db = Room.databaseBuilder(getApplicationContext(),
                MyAppDatabase2.class, "roomDemo-database")

                //表示允许主线程进行数据库操作，但是不推荐这样做。可能造成主线程lock以及ANR(应用无响应)，应为阻塞主线程
                //.allowMainThreadQueries()

                //添加数据库的变动迁移支持(当前状态从version1到version2的变动处理)
                //主要在user里面加入了age字段
                .addMigrations(MyAppDatabase2.MIGRATION_1_2)
                .build();

        //得到数据库，就可以 得到userDao2数据库执行语句类 对象
        mUserDao2 = db.userDao2();

        mMsgTV = (TextView) findViewById(R.id.msg);//打印显示控件
        mBuffer = new StringBuffer();

    }

    public void onClick(View view) {
        mBuffer.delete(0, mBuffer.length());//打印之前先清除数据
        switch (view.getId()) {

            case R.id.livedata_room:
                startActivity(new Intent(UpgradeDatabaseActivity.this, RoomLivedataActivity.class));
                break;
            case R.id.insert_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //返回的是插入元素的primary key index（主键索引 uid ）
                        Long aLong = mUserDao2.insertUser2(new User2("first2Name1_" + System.currentTimeMillis() / 1000, "last2Name"));
                        if (aLong > 0) {
                            String msg = "插入成功, uid索引== " + aLong;
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        } else {
                            String msg = "插入失败";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        }
                        UpgradeDatabaseActivity.this.setMsg();
                    }
                }).start();
                break;
            case R.id.insert_some:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayList<User2> users = new ArrayList<>();
                        users.add(new User2("first2Name2_" + System.currentTimeMillis() / 1000, "last2Name2"));
                        users.add(new User2("first2Name3_" + System.currentTimeMillis() / 1000, "last2Name3"));
                        List<Long> longs = mUserDao2.insertUser2s2(users);
                        if (longs != null && longs.size() > 0) {
                            for (Long aLong : longs) {
                                String msg = "插入成功, uid索引== " + aLong;
                                mBuffer.append(msg + "\n");
                                Log.i(TAG, msg);
                            }
                        } else {
                            String msg = "插入失败";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        }
                        UpgradeDatabaseActivity.this.setMsg();
                    }
                }).start();
                break;
            case R.id.update_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int random = new Random().nextInt(9) + 1;
                        int update = mUserDao2.updateUser2(new User2(random, "随机first2Name4_" + System.currentTimeMillis() / 1000, "随机last2Name4"));
                        if (update > 0) {
                            String msg = "更新成功, 影响条数==" + random;
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        } else {
                            String msg = "更新失败 ,影响条数== " + random + " 这个uid不存在 ";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        }
                        UpgradeDatabaseActivity.this.setMsg();
                    }
                }).start();
                break;
            case R.id.delete_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int random = new Random().nextInt(9) + 1;
                        int delete = mUserDao2.deleteUser2(new User2(random));
                        if (delete > 0) {
                            //size 表示删除个数
                            String msg = "删除成功，影响条数== " + random;
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        } else {
                            String msg = "删除失败，影响条数==  " + random + " 这个uid不存在  ";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        }
                        UpgradeDatabaseActivity.this.setMsg();

                    }
                }).start();

                break;
            case R.id.find_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int random = new Random().nextInt(9) + 1;
                        User2 user = mUserDao2.getUser2ByUid(random);
                        if (user != null) {
                            String msg = "查询成功 , uid== " + random + "---  user:  " + user.toString();
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        } else {
                            String msg = "查询失败 , uid== " + random + "这个uid不存在 ";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        }
                        UpgradeDatabaseActivity.this.setMsg();
                    }
                }).start();
                break;
            case R.id.find_all:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<User2> all = mUserDao2.getUser2All();
                        if (all != null && all.size() > 0) {
                            for (User2 user1 : all) {
                                String msg = "查询所有user成功 ,item  ==" + user1.toString();
                                mBuffer.append(msg + "\n");
                                Log.i(TAG, msg);
                            }
                        } else {
                            String msg = "查询所有user失败, 这个用户不存在 ";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        }
                        UpgradeDatabaseActivity.this.setMsg();


                    }
                }).start();
                break;
            case R.id.delete_all:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<User2> all = mUserDao2.getUser2All();
                        if (all != null && all.size() > 0) {
                            int i = mUserDao2.deleteUser2s1(all);
                            String msg = "删除所有user成功 , 删除了第  " + i +"条";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        } else {
                            String msg = "删除所有user失败 , 这个用户不存在 ";
                            Log.i(TAG, msg);
                            mBuffer.append(msg + "\n");
                        }
                        UpgradeDatabaseActivity.this.setMsg();

                    }
                }).start();
                break;

        }
    }

    private void setMsg() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String text = mBuffer.toString();
                mMsgTV.setText(text);
            }
        });
    }
}

