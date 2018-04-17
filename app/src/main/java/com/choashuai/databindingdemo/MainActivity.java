package com.choashuai.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.choashuai.databindingdemo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private String name = "shuaizi";
    private int id = 1;
    private String blog = "http://blog.csdn.net/q844258542/article/details/78088011";
    private boolean whileTag = true;
    private User user = new User();
    private UserT usert = new UserT();
    private List<User> userList = new ArrayList<>();
    private ItemAdapter mItemAdapter;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        final ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setUser(user);
        Util util = new Util();
        mainBinding.setUtil(util);

        Progress progress = new Progress();
        mainBinding.setProgress(progress);

        //设置一个初始值作为演示 数据 -> View
        //这是最常见的进度设置。
        progress.porgress.set(21);

        final ViewModel vm = new ViewModel();
        mainBinding.setModel(vm);

        //数据模型的变化将控制View的显示
        vm.isDisplay.set(false);
        Log.d("MainActivity", "数值变化:" + vm.isDisplay.get());
//        user.url.set("https://www.baidu.com/img/bd_logo1.png");
//        user.name.set("heihahou");
        imageView = findViewById(R.id.iv);
        Util.loadImage(imageView,"https://www.baidu.com/img/bd_logo1.png");

        user.id.set(0);
        user.name.set("zhangphil");

        user.quality.put("normal", "N url");
        user.quality.put("high", "H url");
        user.quality.put("super", "S url");

        user.current.set("normal");

        final TextView idView = mainBinding.id;
        final TextView nameView = mainBinding.name;
        final TextView blogView = mainBinding.blog;

//        for (int i=0;i<5;i++) {
//            User user = new User();
//            user.id.set(i);
//            user.name.set("shuaizi");
//            user.setBlog("csdn");
//            userList.add(user);
//        }

//        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//
//        mItemAdapter = new ItemAdapter();
//        mItemAdapter.setData(userList);
//        mRecyclerView.setAdapter(mItemAdapter);


        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                User u = new User();
//                u.id.set(3);
//                u.name.set("zhangphil @" + 3);
//                u.setBlog("blog.csdn.net/zhangphil @" + 3);
//                userList.add(u);
//                mItemAdapter.notifyDataSetChanged();
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (whileTag) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("MainActivity", id + "");
                            if (id == 3) {
                                whileTag = false;
                            }
                            user.id.set(id);
                            user.name.set(name + " " + System.currentTimeMillis());
                            user.setBlog(blog + " " + System.currentTimeMillis());
                        }
                    });

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
//        thread.start();

       Thread thread2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mainBinding.philview.setVisibility(View.VISIBLE);
                        //View的变化结果，值将回写到ViewModel的isDisplay中
                        Log.d(TAG, "数值变化:" + vm.isDisplay.get());
                    }
                });
            }
        });
        thread2.start();
    }
}
