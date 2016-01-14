package com.zy.androidlearn2.com.zy.ActivityIntent;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.zy.androidlearn2.R;

public class Activity1 extends AppCompatActivity {

    private static final String TAG = "Activity1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);


    }


    public void click(View view) {

        Intent intent = ShareCompat.IntentBuilder.from(this).getIntent();
        intent.setAction("com.zy.2activity2");
//        intent.setAction("com.zy.activity2");
//        intent.addCategory("catory.zy");
        intent.setDataAndType(Uri.parse("http://www.google.com:80/image/info"), "text/plain");
//        intent.setDataAndType(Uri.parse("http://www.sina.com:80/mpath"), "text/plain");
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PackageManager packageManager = getPackageManager();
        ResolveInfo resolveInfo = packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfo != null) {
            String s = resolveInfo.toString();
            Log.i(TAG, "intent info " + s);
            startActivity(intent);
        } else {
            Log.w(TAG, "intent info is null");
        }


    }
}
