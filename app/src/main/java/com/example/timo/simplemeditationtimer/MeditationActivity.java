package com.example.timo.simplemeditationtimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MeditationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startPauseButton;
    private TextView timeTextView;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 600000;
    private boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_meditation);
        timeTextView = findViewById(R.id.timeTextView);
        startPauseButton = findViewById(R.id.startPauseButton);

        startPauseButton.setOnClickListener((View.OnClickListener) this);
        updateCountdownText();

    }

    @Override
    public void onClick(View v){
        int ce = v.getId();

        if(ce == R.id.startPauseButton && timerRunning){
            pauseTimer();
        }else if(ce == R.id.startPauseButton && !timerRunning){
            startTimer();
        }
    }

    private void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        timerRunning = true;
        startPauseButton.setText("Pause");
    }

    private void pauseTimer(){
        countDownTimer.cancel();
        timerRunning = false;
        startPauseButton.setText("Start");
    }

    private void updateCountdownText(){
        int minutes = (int) (timeLeftInMilliseconds / 1000) / 60;
        int seconds = (int) (timeLeftInMilliseconds / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        timeTextView.setText(timeLeftFormatted);
    }
}
