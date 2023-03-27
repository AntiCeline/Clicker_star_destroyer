package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView space;

    public static int count = 99999999;
    public static int damage = 1;
    public static int score_gold = 0;
    Button improve;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setContentView(R.layout.activity_main);

        improve = (Button) findViewById(R.id.improve);

        TextView text_count = findViewById(R.id.text_count);
        text_count.setText(count + "");
        TextView gold_text = findViewById(R.id.gold_txt);
        gold_text.setText(getString(R.string.txt_coin) + " " + score_gold);

        progressBar = findViewById(R.id.progress);
        progressBar.setProgress(count);


        space = findViewById(R.id.space);
        space.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    count -= damage;
                    text_count.setText(count + "");
                    progressBar.setProgress(count);
                    score_gold += damage;
                    gold_text.setText(getString(R.string.txt_coin) + " " + score_gold);
                    v.animate().scaleX(0.97f).scaleY(0.97f).setDuration(0);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.animate().scaleX(1f).scaleY(1f).setDuration(0);
                }
                return true;
            }
        });
        Shop();
    }

    void Shop() {
        improve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Improve.class);
                startActivity(intent);
            }
        });
    }

}