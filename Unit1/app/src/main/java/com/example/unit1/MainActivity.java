package com.example.unit1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.Unit1.R;

/**
 * MainActivity继承自AppCompatActivity（Activity的子类）
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    /**
     * 被创建时必定要执行的方法
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("data", "onCreate:test ");

    }
}
