package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private int fromDegree = 0,toDegree = 90;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final TextView textView = findViewById(R.id.text_hello);
        Button button = findViewById(R.id.btn_alpha);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0.2f);
                alphaAnimation.setDuration(1000);
                alphaAnimation.setFillAfter(true);
                textView.startAnimation(alphaAnimation);
            }
        });

        Button btnTranslate = findViewById(R.id.btn_translate);
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0f,100f,0f,100f);
                translateAnimation.setDuration(1000);
                translateAnimation.setFillAfter(true);
                textView.startAnimation(translateAnimation);
            }
        });

        Button btnScale = findViewById(R.id.btn_scale);
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f,1.5f,1.0f,1.5f, Animation.RELATIVE_TO_SELF,1f,Animation.RELATIVE_TO_SELF,1f);
                scaleAnimation.setDuration(1000);
                scaleAnimation.setFillAfter(true);
                textView.startAnimation(scaleAnimation);
            }
        });

        Button btnRotate = findViewById(R.id.btn_rotate);
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RotateAnimation rotateAnimation = new RotateAnimation(fromDegree,toDegree,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(2000);
                rotateAnimation.setFillAfter(true);
                textView.startAnimation(rotateAnimation);
                fromDegree +=90;
                toDegree +=90;
            }
        });

        Button btnAdvance = findViewById(R.id.btn_advance);
        btnAdvance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,MainActivity3.class));
            }
        });


    }
}