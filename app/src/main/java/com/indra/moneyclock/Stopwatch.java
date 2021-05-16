package com.indra.moneyclock;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class Stopwatch extends AppCompatActivity {

    Button button,pausebutton;
    ImageView anchor;
    Animation round;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        button = findViewById(R.id.buttonstart);
        pausebutton = findViewById(R.id.pausebutton);
        anchor = findViewById(R.id.ancor);
        round = AnimationUtils.loadAnimation(this,R.anim.rotate);
        chronometer = findViewById(R.id.timer);


        pausebutton.setAlpha(0);


        Typeface mmedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");

        button.setTypeface(mmedium);
        pausebutton.setTypeface(mmedium);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anchor.startAnimation(round);
                pausebutton.animate().alpha(1).translationY(-80).setDuration(300).start();
                button.animate().alpha(0).setDuration(300).start();

                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });

        pausebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anchor.clearAnimation();
                button.animate().alpha(1).start();
                pausebutton.setAlpha(0);
                chronometer.stop();
            }
        });

    }
}