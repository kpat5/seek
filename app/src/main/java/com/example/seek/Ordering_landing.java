package com.example.seek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class Ordering_landing extends AppCompatActivity {

    Button buttonLazeez;
    Button buttonMess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_ordering_landing);

        buttonLazeez = (Button) findViewById(R.id.lazeezButton);
       buttonMess =(Button) findViewById(R.id.messButton) ;

        buttonLazeez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLazeez();
            }
        });
        buttonMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMess();
            }
        });


    }
    public void openLazeez(){
        Intent intent =new Intent(this, Lazeez.class);
        startActivity(intent);
    }
    public void openMess(){
        Intent intent =new Intent(this, Mess.class);
        startActivity(intent);
    }
}