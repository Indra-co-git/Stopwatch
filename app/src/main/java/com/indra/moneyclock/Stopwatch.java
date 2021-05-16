package com.indra.moneyclock;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Stopwatch extends AppCompatActivity {

    Button button;
    ImageView anchor;
    Animation round;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        button = findViewById(R.id.buttonstart);
        anchor = findViewById(R.id.ancor);
        round = AnimationUtils.loadAnimation(this,R.anim.rotate);


        Typeface mmedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");

        button.setTypeface(mmedium);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anchor.startAnimation(round);
            }
        });

    }
}