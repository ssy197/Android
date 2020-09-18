package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * 杀死所有活动，直接退出，配合ActivityCollector
 */
public class FourthActivity extends BaseActivity {
    private static final String TAG = "FourthActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_layout);
        Log.d(TAG, "Task id is " + getTaskId());
        Button button1 = findViewById(R.id.buttonf1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();
//                杀掉一个进程
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }


}
