package com.example.seek;

import static android.graphics.Color.BLACK;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class Cabin extends AppCompatActivity {
    Button but1;
    Button but2;
    Button but3;
    Button but4;
    Button but5;
    Button but6;
    CardView card1;
    CardView card2;
    CardView card3;
    CardView card4;
    CardView card5;
    CardView card6;
    int b1,b2,b3,b4,b5,b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cabin);

        but1=(Button) findViewById(R.id.button);
        but2=(Button) findViewById(R.id.button3);
        but3=(Button) findViewById(R.id.button4);
        but4=(Button) findViewById(R.id.button5);
        but5=(Button) findViewById(R.id.button6);
        but6=(Button) findViewById(R.id.button7);

        card1=(CardView) findViewById(R.id.cardView);
        card2=(CardView) findViewById(R.id.cardView2);
        card3=(CardView) findViewById(R.id.cardView3);
        card4=(CardView) findViewById(R.id.cardView4);
        card5=(CardView) findViewById(R.id.cardView5);
        card6=(CardView) findViewById(R.id.cardView6);
        b1=0;
        b2=0;
        b3=0;
        b4=0;
        b5=0;
        b6=0;
        Toast booked;
        booked = Toast.makeText(this,"Cabin Already Booked!!!", Toast.LENGTH_SHORT);
        Toast confirm;
        confirm = Toast.makeText(this,"Your cabin has been booked!!!", Toast.LENGTH_SHORT);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b1!=0)booked.show();
                else {
                    b1 = bookCabin(but1);
                    confirm.show();
                }
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b2!=0)booked.show();
                else {
                    b2 = bookCabin(but2);
                    confirm.show();
                }
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b3!=0)booked.show();
                else {b3=bookCabin(but3);confirm.show();}
            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b4!=0)booked.show();
                else  {b4=bookCabin(but4); confirm.show();}
            }
        });
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b5!=0)booked.show();
                else {
                    b5 = bookCabin(but5);
                    confirm.show();
                }
            }
        });
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b6!=0)booked.show();
                else {
                    b6 = bookCabin(but6);
                    confirm.show();
                }
            }
        });

    }
    int bookCabin(Button buttt){
        buttt.setBackgroundColor(Color.GRAY);

        return 1;

    }
}