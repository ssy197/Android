package com.example.Unit2_1_base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Button
 * Toast
 * Menu
 * finish
 * Intent
 */
public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        给当前活动加载一个布局
        setContentView(R.layout.first_layout);

//        添加一个按钮（Toast使用）
//          Toast使用方法：makeText（context上下文，文本，时长）创建Toast
//          show（）显示出来了
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this,"you clicked Button 1", Toast.LENGTH_SHORT).show();
            }
        });

//        添加第二个按钮(销毁一个活动 finish（））
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//         添加第三个按钮（显示Intent）
        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

//        添加第四个按钮（隐式Intent：跳转百度界面，拨号界面）
        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent("com.example.activitytest.ACTION_START");
//                intent.addCategory("com.example.activitytest.MY_CATEGORY");
//                startActivity(intent);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://baidu.com"));
                startActivity(intent);
//
//                Intent intent1 = new Intent(Intent.ACTION_DIAL);
//                intent1.setData(Uri.parse("tel:10086"));
//                startActivity(intent1);
            }
        });

//        添加第五个按钮（向下传递数据：通过Intent）
        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "hello secondActivity";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });

//      添加第六个按钮（向上传递数据：通过startActivityForResult）
        Button button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, ThirdActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }


    /**
     * 接收上传数据
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if(resultCode == RESULT_OK) {
                    String ResultData = data.getStringExtra("data_result");
                    Log.d("FirstActivity", ResultData);
                }
                break;
            default:
        }
    }

    /**
     * 活动上添加menu菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    /**
     * 给menu菜单添加功能
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        判断添加那个菜单项
       switch (item.getItemId()) {
           case R.id.add_item:
               Toast.makeText(this,"you clicked Add", Toast.LENGTH_SHORT).show();
               break;

           case R.id.remove_item:
               Toast.makeText(this,"you clicked Remove", Toast.LENGTH_SHORT).show();
               break;

           default:
       }
        return  true;
    }
}
