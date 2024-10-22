package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation logoAniTop,appNameAnimLeft;
    ImageView imageView;
    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        logoAniTop= AnimationUtils.loadAnimation(this,R.anim.logo_top_anim);
        appNameAnimLeft=AnimationUtils.loadAnimation(this,R.anim.app_name_anim_left);
        imageView=findViewById(R.id.logo_image);
        textView=findViewById(R.id.app_name_text);
        imageView.setAnimation(logoAniTop);
        textView.setAnimation(appNameAnimLeft);
    }
}