package wlj.myapplication.room_test.room_livedata_demo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import wlj.myapplication.R;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/6/5.
 * 说明：升级数据库版本
 * ================================================
 */
public class RoomLivedataActivity extends AppCompatActivity {

    private UserDao3 mUserDao3;//数据库语句
    private TextView mMsgTV;//展示打印信息
    private StringBuffer mBuffer;//存放打印信息
    private String TAG="RoomLivedataActivity==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livedata_room);

        //创建一个数据库(上下文，数据库操作类，数据库名称)
        MyAppDatabase3 db = Room.databaseBuilder(getApplicationContext(),
                MyAppDatabase3.class, "roomDemo-database")

                //表示允许主线程进行数据库操作，但是不推荐这样做。可能造成主线程lock以及ANR(应用无响应)，应为阻塞主线程
                //.allowMainThreadQueries()

                //添加数据库的变动迁移支持(当前状态从version1到version2的变动处理)
                //主要在user里面加入了age字段
                .addMigrations(MyAppDatabase3.MIGRATION_2_3)
                .build();

        //得到数据库，就可以 得到userDao2数据库执行语句类 对象
        mUserDao3 = db.userDao3();

        mMsgTV = (TextView) findViewById(R.id.msg);//打印显示控件
        mBuffer = new StringBuffer();


        //livedata观察数据
        //观察  查询 删除  的所有数据（观察的是数据，不是观察查询方法）
        LiveData<List<User3>> all = mUserDao3.getUser3All();
        all.observe(RoomLivedataActivity.this, new Observer<List<User3>>() {
            @Override
            public void onChanged(@Nullable List<User3> users) {
                if (users == null) {
                    return;
                }
                Log.e(TAG, "livedata观察数据："+users.toString());
            }
        });

    }

    public void onClick(View view) {
        mBuffer.delete(0, mBuffer.length());//打印之前先清除数据
        switch (view.getId()) {

            case R.id.insert_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //返回的是插入元素的primary key index（主键索引 uid ）
                        Long aLong = mUserDao3.insertUser3(new User3("first2Name1_" + System.currentTimeMillis() / 1000, "last2Name"));
                        if (aLong > 0) {
                            String msg = "插入成功, uid索引== " + aLong;
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        } else {
                            String msg = "插入失败";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        }
                        RoomLivedataActivity.this.setMsg();
                    }
                }).start();
                break;
            case R.id.insert_some:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayList<User3> users = new ArrayList<>();
                        users.add(new User3("first2Name2_" + System.currentTimeMillis() / 1000, "last2Name2"));
                        users.add(new User3("first2Name3_" + System.currentTimeMillis() / 1000, "last2Name3"));
                        List<Long> longs = mUserDao3.insertUser3s2(users);
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
                        RoomLivedataActivity.this.setMsg();
                    }
                }).start();
                break;
            case R.id.update_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int random = new Random().nextInt(9) + 1;
                        int update = mUserDao3.updateUser3(new User3(random, "随机first2Name4_" + System.currentTimeMillis() / 1000, "随机last2Name4"));
                        if (update > 0) {
                            String msg = "更新成功, 影响条数==" + random;
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        } else {
                            String msg = "更新失败 ,影响条数== " + random + " 这个uid不存在 ";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        }
                        RoomLivedataActivity.this.setMsg();
                    }
                }).start();
                break;
            case R.id.delete_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int random = new Random().nextInt(9) + 1;
                        int delete = mUserDao3.deleteUser3(new User3(random));
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
                        RoomLivedataActivity.this.setMsg();

                    }
                }).start();

                break;
            case R.id.find_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int random = new Random().nextInt(9) + 1;
                        User3 user = mUserDao3.getUser3ByUid(random);
                        if (user != null) {
                            String msg = "查询成功 , uid== " + random + "---  user:  " + user.toString();
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        } else {
                            String msg = "查询失败 , uid== " + random + "这个uid不存在 ";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        }
                        RoomLivedataActivity.this.setMsg();
                    }
                }).start();
                break;
            case R.id.find_all:      //livedata观察数据     查询
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        LiveData<List<User3>> liveData_all = mUserDao3.getUser3All();

                        List<User3> all=null;

                        try {
                            all = LiveDataUtil.getValue(liveData_all);//将观察的数据返回去
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (all != null && all.size() > 0) {
                            for (User3 user1 : all) {
                                String msg = "查询所有user成功 ,item  ==" + user1.toString();
                                mBuffer.append(msg + "\n");
                                Log.i(TAG, msg);
                            }
                        } else {
                            String msg = "查询所有user失败, 这个用户不存在 ";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        }
                        RoomLivedataActivity.this.setMsg();


                    }
                }).start();
                break;
            case R.id.delete_all:   //livedata观察数据      删除
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LiveData<List<User3>> liveData_all = mUserDao3.getUser3All();

                        List<User3> all=null;

                        try {
                            all = LiveDataUtil.getValue(liveData_all);//将观察的数据返回去
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (all != null && all.size() > 0) {
                            int i = mUserDao3.deleteUser3s1(all);
                            String msg = "删除所有user成功 , 删除了第  " + i +"条";
                            mBuffer.append(msg + "\n");
                            Log.i(TAG, msg);
                        } else {
                            String msg = "删除所有user失败 , 这个用户不存在 ";
                            Log.i(TAG, msg);
                            mBuffer.append(msg + "\n");
                        }
                        RoomLivedataActivity.this.setMsg();

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

