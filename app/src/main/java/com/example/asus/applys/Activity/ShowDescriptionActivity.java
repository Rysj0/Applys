package com.example.asus.applys.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.asus.applys.R;

public class ShowDescriptionActivity  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_description);
        String content =null;
        Intent intent = getIntent();
        if(intent!=null){
            Bundle bundle = intent.getBundleExtra("android.intent.extra.rssItem");
            if(bundle==null){
                content = "不好意思程序出错啦";
            }else{
                content = bundle.getString("title") + "\n\n"
                        + bundle.getString("pubdate") + "\n\n"
                        + bundle.getString("description").replace('\n', ' ')
                        + "\n\n详细信息请访问以下网址:\n" + bundle.getString("link");
            }
        }else{
            content = "不好意思程序出错啦";
        }
        TextView contentText = (TextView) this.findViewById(R.id.content);
        contentText.setText(content);
        Button backButton = (Button) this.findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
