package com.example.seek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Ordering_landing extends AppCompatActivity {

    ImageButton buttonLazeez;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_landing);

        buttonLazeez = (ImageButton) findViewById(R.id.lazeezButton);

        buttonLazeez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLazeez();
            }
        });


    }
    public void openLazeez(){
        Intent intent =new Intent(this, Lazeez.class);
        startActivity(intent);
    }
}