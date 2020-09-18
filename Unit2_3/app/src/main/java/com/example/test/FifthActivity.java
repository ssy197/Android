package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * 最佳启动
 */
public class FifthActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_layout);
    }

    public static void actionStart(Context context,String data1,String data2) {
        Intent intent = new Intent(context, FifthActivity.class);
        intent.putExtra("data1",data1);
        intent.putExtra("data2",data2);
        context.startActivity(intent);
    }
}
