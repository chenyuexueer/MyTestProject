package wlj.myapplication.room_test;

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
import wlj.myapplication.room_test.demo.MyAppDatabase;
import wlj.myapplication.room_test.demo.User;
import wlj.myapplication.room_test.demo.UserDao;
import wlj.myapplication.room_test.upgrade_database.UpgradeDatabaseActivity;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/6/5.
 * 说明：https://github.com/HoldMyOwn/RoomDemo
 * ================================================
 */
public class MyRoomTestActivity extends AppCompatActivity {

    private UserDao mUserDao;//数据库语句
    private TextView mMsgTV;//展示打印信息
    private StringBuffer mBuffer;//存放打印信息
    private String TAG="MyRoomTestActivity==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_room_test);

        //创建一个数据库(上下文，数据库操作类，数据库名称)
        MyAppDatabase db = Room.databaseBuilder(getApplicationContext(),
                MyAppDatabase.class, "roomDemo-database")

                //表示允许主线程进行数据库操作，但是不推荐这样做。可能造成主线程lock以及ANR(应用无响应)，应为阻塞主线程
                //.allowMainThreadQueries()
                .build();

        //得到数据库，就可以 得到userDao数据库执行语句类 对象
        mUserDao = db.userDao();

        mMsgTV = (TextView) findViewById(R.id.msg);//打印显示控件
        mBuffer = new StringBuffer();

    }

    public void onClick(View view) {
        mBuffer.delete(0, mBuffer.length());//打印之前先清除数据
        switch (view.getId()) {

            case R.id.upgrade_database:
                startActivity(new Intent(MyRoomTestActivity.this, UpgradeDatabaseActivity.class));
                break;
            case R.id.insert_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //返回的是插入元素的primary key index（主键索引 uid ）
                        Long aLong = mUserDao.insertUser(new User("firstName1_" + System.currentTimeMillis() / 1000, "lastName"));
                        if (aLong > 0) {
                            String msg = "插入成功, uid索引== " + aLong;
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        } else {
                            String msg = "插入失败";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        }
                        MyRoomTestActivity.this.setMsg();
                    }
                }).start();
                break;
            case R.id.insert_some:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayList<User> users = new ArrayList<>();
                        users.add(new User("firstName2_" + System.currentTimeMillis() / 1000, "lastName2"));
                        users.add(new User("firstName3_" + System.currentTimeMillis() / 1000, "lastName3"));
                        List<Long> longs = mUserDao.insertUsers2(users);
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
                        MyRoomTestActivity.this.setMsg();
                    }
                }).start();
                break;
            case R.id.update_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int random = new Random().nextInt(9) + 1;
                        int update = mUserDao.updateUser(new User(random, "随机firstName4_" + System.currentTimeMillis() / 1000, "随机lastName4"));
                        if (update > 0) {
                            String msg = "更新成功, 影响条数==" + random;
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        } else {
                            String msg = "更新失败 ,影响条数== " + random + " 这个uid不存在 ";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        }
                        MyRoomTestActivity.this.setMsg();
                    }
                }).start();
                break;
            case R.id.delete_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int random = new Random().nextInt(9) + 1;
                        int delete = mUserDao.deleteUser(new User(random));
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
                        MyRoomTestActivity.this.setMsg();

                    }
                }).start();

                break;
            case R.id.find_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int random = new Random().nextInt(9) + 1;
                        User user = mUserDao.getUserByUid(random);
                        if (user != null) {
                            String msg = "查询成功 , uid== " + random + "---  user:  " + user.toString();
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        } else {
                            String msg = "查询失败 , uid== " + random + "这个uid不存在 ";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        }
                        MyRoomTestActivity.this.setMsg();
                    }
                }).start();
                break;
            case R.id.find_all:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<User> all = mUserDao.getUserAll();
                        if (all != null && all.size() > 0) {
                            for (User user1 : all) {
                                String msg = "查询所有user成功 ,item  ==" + user1.toString();
                                mBuffer.append(msg + "\n");
                                Log.i(TAG, msg);
                            }
                        } else {
                            String msg = "查询所有user失败, 这个用户不存在 ";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        }
                        MyRoomTestActivity.this.setMsg();


                    }
                }).start();
                break;
            case R.id.delete_all:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<User> all = mUserDao.getUserAll();
                        if (all != null && all.size() > 0) {
                            int i = mUserDao.deleteUsers1(all);
                            String msg = "删除所有user成功 , 删除了第  " + i +"条";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        } else {
                            String msg = "删除所有user失败 , 这个用户不存在 ";
                            Log.i(TAG, msg);
                            mBuffer.append(msg + "\n");
                        }
                        MyRoomTestActivity.this.setMsg();

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
