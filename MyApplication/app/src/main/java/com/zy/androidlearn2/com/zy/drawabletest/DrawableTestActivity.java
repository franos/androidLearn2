package com.zy.androidlearn2.com.zy.drawabletest;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zy.androidlearn2.R;

public class DrawableTestActivity extends AppCompatActivity {
    TextView textView;
    boolean isStart = true;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawable_test);
        img = (ImageView) findViewById(R.id.transition_img);
        textView = (TextView) findViewById(R.id.transition_test_tv);
//渐变动画 TransitionDrawable---<transition>
        final TransitionDrawable drawable = (TransitionDrawable) textView.getBackground();
        drawable.startTransition(2000);
        textView.setClickable(true);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart) {
                    drawable.reverseTransition(2000);
                    isStart = false;
                } else {
                    isStart = true;
                    drawable.startTransition(2000);
                }
            }
        });

        final TransitionDrawable transitionDrawable = (TransitionDrawable) img.getDrawable();
        img.setClickable(true);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionDrawable.startTransition(2000);
            }
        });
    }
}
