package com.example.seek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Booking_landing extends AppCompatActivity {

    Button salon;
    Button cabin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_booking_landing);
        salon = findViewById(R.id.salon);
        cabin=(Button)findViewById(R.id.cabin);
        salon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                golink("https://buddhabeautypoints.com/university/");
            }
        });
        cabin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openCabin();
            }
        });
    }

    private void golink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
    public void openCabin(){
        Intent intent =new Intent(this, Cabin.class);
        startActivity(intent);
    }
}