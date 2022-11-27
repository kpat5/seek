package com.example.seek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Mess extends AppCompatActivity {
    EditText  txtReason , txtLocation, txtName , txtPhone, messMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_mess);

        txtReason = findViewById(R.id.reason);
        txtLocation = findViewById(R.id.location);
        txtName = findViewById(R.id.student);
        txtPhone = findViewById(R.id.number);
        messMenu = findViewById(R.id.menu);

        Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });

    }
    private void sendMail(){
        String recipientList = "nitin.varyani@bmu.edu.in";
        String[] recipients = recipientList.split(",");
        String subjects = "Meal: "+ messMenu.getText().toString();
        String messages = "Room number: " + txtLocation.getText().toString()+"\n"+"Phone number: "+ txtPhone.getText().toString()+"\n"+ "Reason: "+ txtReason.getText().toString()+"\n"+"Thanks and regards"+"\n"+txtName.getText().toString() ;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,subjects);
        intent.putExtra(Intent.EXTRA_TEXT,messages);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose a email client"));

    }
}