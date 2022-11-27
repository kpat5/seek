package com.example.seek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Landing extends AppCompatActivity {
    Button buttonLostFound;
    Button buttonOrder;
    Button buttonMap;
    Button buttonBooking;
    Button LogOut;
    public static final String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_landing);


        buttonLostFound=(Button) findViewById(R.id.lostFound);
        buttonOrder=(Button) findViewById(R.id.order);
        buttonMap=(Button) findViewById(R.id.map);
        buttonBooking=(Button) findViewById(R.id.booking);
        LogOut = findViewById(R.id.logOut);

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", "");
                editor.apply();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonLostFound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLostFound();
            }
        });
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrder();
            }
        });
        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });
        buttonBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBooking();
            }
        });


    }
    public void openLostFound(){
        Intent intent =new Intent(this, lostFound.class);
        startActivity(intent);
    }
    public void openOrder(){
        Intent intent =new Intent(this, Ordering_landing.class);
        startActivity(intent);
    }
    public void openMap(){
        Intent intent =new Intent(this, Bmu_Map.class);
        startActivity(intent);
    }
    public void openBooking(){
        Intent intent =new Intent(this, Booking_landing.class);
        startActivity(intent);
    }
}