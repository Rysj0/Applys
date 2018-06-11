package com.example.asus.applys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.applys.Activity.LoginActivity;
import com.example.asus.applys.Activity.videoplayer;
import com.example.asus.applys.utils.AnalysisUtils;

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
//            case R.id.ll_head:
//                if (AnalysisUtils.readLoginStatus(getActivity())) {
//                    //跳转到个人资料界面
//                    Intent intent = new Intent(getActivity(), ActivityUserInfoActivity.class);
//                    getActivity().startActivity(intent);
//                } else {
//                    //跳转到登陆界面
//                    Intent intent = new Intent(getActivity(), LoginActivity.class);
//                    getActivity().startActivityForResult(intent, 1);
//                }
//                break;
            case R.id.tv_user_name:
                //跳转登录页面
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent,1);
                break;
            case R.id.rl_course_history:

                    //跳转到发送邮件页面
                Intent intent2 = new Intent(MainActivity.this, PlayHistoryActivity.class);
                startActivityForResult(intent2,1);

                break;
            case R.id.rl_setting:
                //跳到播放页面
                Intent intent3 = new Intent(MainActivity.this, videoplayer.class);
                startActivityForResult(intent3,1);
                break;
        }
    }
}
