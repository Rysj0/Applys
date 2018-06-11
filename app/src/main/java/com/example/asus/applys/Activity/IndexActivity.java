package com.example.asus.applys.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.applys.R;
import com.example.asus.applys.utils.AnalysisUtils;


public class IndexActivity extends Fragment implements View.OnClickListener {

    private LinearLayout llHead;
    private ImageView ivHeadIcon;
    private TextView tvUserName;
    private RelativeLayout rlCourseHistory;
    private ImageView ivCourseHistoryicon;
    private RelativeLayout rlSetting;
    private ImageView ivUserinfoIcon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_index, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        llHead = (LinearLayout) view.findViewById(R.id.ll_head);
        ivHeadIcon = (ImageView) view.findViewById(R.id.iv_head_icon);
        tvUserName = (TextView) view.findViewById(R.id.tv_user_name);
        rlCourseHistory = (RelativeLayout) view.findViewById(R.id.rl_course_history);

        rlSetting = (RelativeLayout) view.findViewById(R.id.rl_setting);


        if (AnalysisUtils.readLoginStatus(getActivity())) {
            tvUserName.setText(AnalysisUtils.readLoginUserName(getActivity()));
        } else {
            tvUserName.setText("点击登录");
        }

        llHead.setOnClickListener(this);
        rlCourseHistory.setOnClickListener(this);
        rlSetting.setOnClickListener(this);
    }

    @Override
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
            case R.id.rl_course_history:
                if (AnalysisUtils.readLoginStatus(getActivity())) {
                    //跳转到发送邮件页面
                    Intent intent = new Intent(getActivity(), PlayHistoryActivity.class);
                    getActivity().startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "您未登录，请先登录", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rl_setting:
                if (AnalysisUtils.readLoginStatus(getActivity())) {
                    //跳转到播放视频界面
                    Intent intent = new Intent(getActivity(), videoplayer.class);
                    getActivity().startActivityForResult(intent, 1);
                } else {
                    Toast.makeText(getActivity(), "您未登录，请先登录", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
