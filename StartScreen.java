package com.example.onlinegrievance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class StartScreen extends AppCompatActivity {

    Animation topanimation,bottomanimation,middleanimation;
    View first,second,third,four,five,six;
    TextView o,slogan;
    private static int  SPLASH_TIME_OUT=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_screen);
        topanimation= AnimationUtils.loadAnimation(this,R.anim.topanimation);
        bottomanimation= AnimationUtils.loadAnimation(this,R.anim.bottomanimation);
        middleanimation= AnimationUtils.loadAnimation(this,R.anim.middleanimation);
        first=findViewById(R.id.first);
        second=findViewById(R.id.second);
        third=findViewById(R.id.third);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        o=findViewById(R.id.o);
        slogan=findViewById(R.id.opp);

        first.setAnimation(topanimation);
        second.setAnimation(topanimation);
        third.setAnimation(topanimation);
        four.setAnimation(topanimation);
        five.setAnimation(topanimation);
        six.setAnimation(topanimation);
        o.setAnimation(middleanimation);
        slogan.setAnimation(bottomanimation);


        new Handler().postDelayed(new Runnable(){
            public void run() {
                Intent intent = new Intent(StartScreen.this, StartActivity.class);
                startActivity(intent);
                finish();

            }

        },SPLASH_TIME_OUT);


    }


}