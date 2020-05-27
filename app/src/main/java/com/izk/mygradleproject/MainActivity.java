package com.izk.mygradleproject;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_one,tv_two;
    String channel,theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_one = findViewById(R.id.tv_one);
        tv_two = findViewById(R.id.tv_two);

        getMeta();

        tv_one.setText(channel);
        tv_two.setText(theme);
    }

    /**
     * 从manifest中读取出metadata
     */
    private void getMeta() {
        PackageManager packageManager = getPackageManager();
        ApplicationInfo packageArchiveInfo = null;
        try {
            packageArchiveInfo = packageManager.getApplicationInfo(BuildConfig.APPLICATION_ID, PackageManager.GET_META_DATA);
            Bundle metaData = packageArchiveInfo.metaData;
            channel = metaData.getString("CHANNEL_VALUE");
            theme = metaData.getString("THEME");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
