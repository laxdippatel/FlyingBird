package com.example.flybird;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public GameView gameView;
    private Handler handler = new Handler();
    private final static long TIMER_INTERVAL = 30;
    ImageButton stbtn;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stbtn=(ImageButton)findViewById(R.id.stbtn);
        stbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameView = new GameView(getApplicationContext());
                setContentView(gameView);

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                gameView.invalidate();
                            }
                        });
                    }
                }, 0, TIMER_INTERVAL);
            }
        });

    }

    public void onBackPressed(){

        finish();
    }
}