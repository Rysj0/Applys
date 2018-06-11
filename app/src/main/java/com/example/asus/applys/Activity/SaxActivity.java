package com.example.asus.applys.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.example.asus.applys.R;
import com.example.asus.applys.Sex.RssFeed;
import com.example.asus.applys.Sex.RssFeed_SAXParser;
import com.example.asus.applys.Sex.RssItem;

public class SaxActivity  extends AppCompatActivity implements AdapterView.OnItemClickListener {
    // 从网络获取RSS地址
    public final String RSS_URL = "http://ent.qq.com/movie/rss_movie.xml";
    public final String tag = "RSSReader";
    private RssFeed feed = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());
        try {
            feed = new RssFeed_SAXParser().getFeed(RSS_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        showListView();
    }

    /*把RSS内容绑定到ui界面进行显示	 */
    private void showListView() {

        ListView itemList = (ListView) this.findViewById(R.id.listView1);
        if (feed == null) {
            setTitle("访问的RSS无效");
            return;
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                feed.getAllItems(), android.R.layout.simple_list_item_2,
                new String[] { RssItem.TITLE, RssItem.PUBDATE }, new int[] {
                android.R.id.text1, android.R.id.text2 });
        itemList.setAdapter(simpleAdapter);
        itemList.setOnItemClickListener(this);
        itemList.setSelection(0);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        Intent intent = new Intent();
        intent.setClass(this, ShowDescriptionActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("title", feed.getItem(position).getTitle());
        bundle.putString("description",feed.getItem(position).getDescription());
        bundle.putString("link", feed.getItem(position).getLink());
        bundle.putString("pubdate", feed.getItem(position).getPubdate());
        // 用android.intent.extra.INTENT的名字来传递参数
        intent.putExtra("android.intent.extra.rssItem", bundle);
        startActivityForResult(intent, 0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

