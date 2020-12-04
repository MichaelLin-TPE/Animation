package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private boolean isLike = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final TextView textView = findViewById(R.id.text_hello);

        final TextView tvTest = findViewById(R.id.text_test);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);

        final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0.2f);
        alphaAnimation.setDuration(1000);

        TranslateAnimation translateAnimation = new TranslateAnimation(0f,500f,0f,0);
        translateAnimation.setDuration(1000);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setInterpolator(new BounceInterpolator());
        textView.startAnimation(animationSet);



        final ImageView ivLike = findViewById(R.id.like);
        ivLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLike){
                    ivLike.setImageResource(R.drawable.like_pressed);
                    isLike = true;
                }else {
                    ivLike.setImageResource(R.drawable.like);
                    isLike = false;
                }

                AnimationSet animationSet = new AnimationSet(true);

                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f,1.2f,1.0f,1.2f);
                scaleAnimation.setDuration(200);

                RotateAnimation rotateAnimation = new RotateAnimation(0.0f,-20f,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(200);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(rotateAnimation);
                ivLike.startAnimation(animationSet);
            }
        });



        Button btnX,btnColor,btnRotate,btnScaleX,btnSet,btnAlpha,btnAnim;

        btnX = findViewById(R.id.btn_x);
        btnColor = findViewById(R.id.btn_color);
        btnRotate = findViewById(R.id.btn_rotate);
        btnScaleX = findViewById(R.id.btn_scale_x);
        btnSet = findViewById(R.id.btn_set);
        btnAlpha = findViewById(R.id.btn_alpha);
        btnAnim = findViewById(R.id.btn_anim);

        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator animator = AnimatorInflater.loadAnimator(MainActivity3.this,R.animator.anim_alpha);
                animator.setTarget(tvTest);
                animator.start();
            }
        });

        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator animator = AnimatorInflater.loadAnimator(MainActivity3.this,R.animator.anim_x);
                animator.setTarget(tvTest);
                animator.start();
            }
        });

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Animator animator = AnimatorInflater.loadAnimator(MainActivity3.this,R.animator.anim_background);
//                animator.setTarget(tvTest);
//                animator.start();

                ObjectAnimator animator = ObjectAnimator.ofInt(tvTest,"BackgroundColor",R.color.colorAccent,R.color.colorPrimary);
                animator.setDuration(1000);
                animator.start();
            }
        });
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Animator animator = AnimatorInflater.loadAnimator(MainActivity3.this,R.animator.anim_rotate);
//                animator.setTarget(tvTest);
//                animator.start();
                ObjectAnimator animator = ObjectAnimator.ofFloat(tvTest,"rotation",0.0f,270f);
                animator.setDuration(1000);
                animator.start();
            }
        });
        btnScaleX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Animator animator = AnimatorInflater.loadAnimator(MainActivity3.this,R.animator.anim_scale_x);
//                animator.setTarget(tvTest);
//                animator.start();


                ObjectAnimator animator = ObjectAnimator.ofFloat(tvTest,"scaleX",3);
                animator.setDuration(1000);
                animator.start();
            }
        });
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Animator animator = AnimatorInflater.loadAnimator(MainActivity3.this,R.animator.anim_set);
//                animator.setTarget(tvTest);
//                animator.start();

                ObjectAnimator animator = ObjectAnimator.ofFloat(tvTest,"scaleX",3);
                animator.setDuration(1000);
                animator.start();
            }
        });

        btnAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ValueAnimator valueAnimator = ValueAnimator.ofFloat(1.0f,0.1f);
//
//                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        tvTest.setAlpha((Float) animation.getAnimatedValue());
//                        tvTest.requestLayout();
//                    }
//                });
//                valueAnimator.setDuration(2000);
//                valueAnimator.start();

                Keyframe frame0 = Keyframe.ofFloat(0f,0f);
                Keyframe frame1 = Keyframe.ofFloat(0.1f,-30f);
                Keyframe frame2 = Keyframe.ofFloat(0.3f,30f);
                Keyframe frame3 = Keyframe.ofFloat(0.6f,-30f);
                Keyframe frame4 = Keyframe.ofFloat(0.8f,30f);
                Keyframe frame5 = Keyframe.ofFloat(1f,0f);

                PropertyValuesHolder valuesHolder = PropertyValuesHolder.ofKeyframe("rotation",frame0,frame1,frame2,frame3,frame4,frame5);
                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(tvTest,valuesHolder);
                objectAnimator.setDuration(500);
                objectAnimator.start();





            }
        });


    }
}