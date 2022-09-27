package com.example.seek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Landing extends AppCompatActivity {
    Button buttonLostFound;
    Button buttonOrder;
    Button buttonMap;
    Button buttonBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        buttonLostFound=(Button) findViewById(R.id.lostFound);
        buttonOrder=(Button) findViewById(R.id.order);
        buttonMap=(Button) findViewById(R.id.map);
        buttonBooking=(Button) findViewById(R.id.booking);

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
        Intent intent =new Intent(this, lost_found_post.class);
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