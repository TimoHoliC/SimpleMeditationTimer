package com.example.timo.simplemeditationtimer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity implements OnClickListener {

    private Button startMeditationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        startMeditationButton = (Button) findViewById(R.id.startMeditationButton);
        startMeditationButton.setOnClickListener((OnClickListener) this);
    }

    @Override
    public void onClick(View v){
        int ce = v.getId();

        if(ce == R.id.startMeditationButton){
            Intent intent = new Intent(MainMenuActivity.this, MeditationActivity.class);
            startActivity(intent);
        }
    }

}
