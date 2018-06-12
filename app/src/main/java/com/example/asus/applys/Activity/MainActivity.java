package com.example.asus.applys.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.applys.R;
import com.example.asus.applys.utils.AnalysisUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvUserName;
    private TextView tvUserName1;
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
        tvUserName1 = (TextView) findViewById(R.id.tv_user_name1);
        rlCourseHistory = (RelativeLayout) findViewById(R.id.rl_course_history);
        rlSetting = (RelativeLayout) findViewById(R.id.rl_setting);


        tvUserName1.setOnClickListener((View.OnClickListener) this);
        tvUserName.setOnClickListener((View.OnClickListener) this);
        rlCourseHistory.setOnClickListener((View.OnClickListener) this);
        rlSetting.setOnClickListener((View.OnClickListener) this);

        setLoginParams(readLoginStatus());

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_user_name:
                //退出登陆，跳到登录页面
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent,1);
                break;
            case R.id.tv_user_name1:
                //退出登陆，跳到登录页面
                Intent intent4 = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent4,1);
                break;
            case R.id.rl_course_history:
                    //跳转新闻页面
                if (readLoginStatus()) {
                    Intent intent2 = new Intent(MainActivity.this, SaxActivity.class);
                    startActivityForResult(intent2, 1);
                }else {
                    Toast.makeText(this,"您还未登录，请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rl_setting:
                //跳到播放页面
                if (readLoginStatus()) {
                    Intent intent3 = new Intent(MainActivity.this, videoplayActivity.class);
                    startActivityForResult(intent3, 1);
                }else {
                    Toast.makeText(this,"您还未登录，请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    public void setLoginParams(boolean isLogin) {
        if (isLogin){
            tvUserName1.setText(AnalysisUtils.readLoginUserName(this));
        }else {
            tvUserName1.setText("立即登录");
        }
    }
    private boolean readLoginStatus(){
        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
        boolean isLogin = sp.getBoolean("isLogin",false);
        return isLogin;
    }


}
