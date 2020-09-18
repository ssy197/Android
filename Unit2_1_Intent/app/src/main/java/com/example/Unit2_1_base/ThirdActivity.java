package com.example.Unit2_1_base;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

            Button button = findViewById(R.id.button_t1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("data_result","hello,firstActivity");
                    setResult(RESULT_OK,intent);
                    finish();
                }
            });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_result","hello，back！");
        setResult(RESULT_OK,intent);
        finish();
    }
}
