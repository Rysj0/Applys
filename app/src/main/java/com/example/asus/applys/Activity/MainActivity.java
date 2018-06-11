package com.example.asus.applys.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.asus.applys.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvUserName;
    private RelativeLayout rlCourseHistory;
    private RelativeLayout rlSetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        init();
    }

    private void init() {

        tvUserName = (TextView) findViewById(R.id.tv_user_name);
        rlCourseHistory = (RelativeLayout) findViewById(R.id.rl_course_history);
        rlSetting = (RelativeLayout) findViewById(R.id.rl_setting);


        tvUserName.setOnClickListener((View.OnClickListener) this);
        rlCourseHistory.setOnClickListener((View.OnClickListener) this);
        rlSetting.setOnClickListener((View.OnClickListener) this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_user_name:
                //跳转登录页面
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent,1);
                break;
            case R.id.rl_course_history:

                    //跳转新闻页面
                Intent intent2 = new Intent(MainActivity.this,SaxActivity .class);
                startActivityForResult(intent2,1);

                break;
            case R.id.rl_setting:
                //跳到播放页面
                Intent intent3 = new Intent(MainActivity.this, videoplayActivity.class);
                startActivityForResult(intent3,1);
                break;
        }
    }
}
