package com.example.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


/**
 * 1.活动启动：.xml文件 + MainActivity
 * 2.检测运行活动：BaseActivity
 * 3.大返：直接退出：ActivityCollector + BaseActivity + FourthActivity
 * 4.最佳启动：MainActivity + FifthActivity
 */
public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        自我访问的时候，查看返回栈
        Log.d(TAG, "Task id is " + getTaskId());

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                开启自我访问
//                Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                startActivity(intent);

                FifthActivity.actionStart(MainActivity.this,"data","data");
            }
        });

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: mainActivity");
    }
}
