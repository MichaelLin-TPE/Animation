package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.text_hello);
        Button button = findViewById(R.id.btn_alpha);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha));
            }
        });

        Button btnTranslate = findViewById(R.id.btn_translate);
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate));
            }
        });

        Button btnScale = findViewById(R.id.btn_scale);
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale));
            }
        });

        Button btnRotate = findViewById(R.id.btn_rotate);
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate));
            }
        });

        Button btnAdvance = findViewById(R.id.btn_advance);
        btnAdvance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });

    }
}