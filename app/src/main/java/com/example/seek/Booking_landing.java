package com.example.seek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Booking_landing extends AppCompatActivity {
    
    Button salon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_landing);
        salon = findViewById(R.id.salon);
        
        salon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                golink("https://buddhabeautypoints.com/university/");
            }
        });
    }

    private void golink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}