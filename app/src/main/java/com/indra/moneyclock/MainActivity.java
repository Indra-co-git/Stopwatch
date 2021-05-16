package com.indra.moneyclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2;
    Button button;
    Animation animation,btone,bttwo;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv);
        tv2 = findViewById(R.id.subtv);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.ivsplash);

        Typeface mlight = Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface mmedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface mregular = Typeface.createFromAsset(getAssets(),"fonts/MRegular.ttf");

        animation = AnimationUtils.loadAnimation(this,R.anim.atg);
        btone = AnimationUtils.loadAnimation(this,R.anim.btgone);
        bttwo = AnimationUtils.loadAnimation(this,R.anim.btgtwo);


        imageView.startAnimation(animation);
        tv1.startAnimation(btone);
        tv2.startAnimation(btone);
        button.startAnimation(bttwo);

        tv1.setTypeface(mregular);
        tv2.setTypeface(mlight);
        button.setTypeface(mmedium);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Stopwatch.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
    }
}