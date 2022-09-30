package com.example.seek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Lazeez extends AppCompatActivity {

    EditText Order, Location, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazeez);

        Order = (EditText)findViewById(R.id.order);
        Location = (EditText)findViewById(R.id.location);
        phone = (EditText)findViewById(R.id.phone);

    }

    public void btn_send(View view) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if(permissionCheck == PackageManager.PERMISSION_GRANTED){

            MyMessage();
        }
        else{
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.SEND_SMS},0);
        }
    }

    private void MyMessage() {
        String phoneNumber ="7690863839";
        String Message = Order.getText().toString().trim();
        String Message2 = Location.getText().toString().trim();
        String Message3 = phone.getText().toString().trim();
        String sms = "Order: "+ Message+"\n Location: "+Message2+"\n Phone Number: " + Message3;

        if(!Order.getText().toString().equals("") || !Location.getText().toString().equals("") || !phone.getText().toString().equals("")){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber,null,sms, null,null);

            Toast.makeText(this,"Message sent", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Please enter all the details",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case 0:
                if(grantResults.length>=0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    MyMessage();
                }
                else{
                    Toast.makeText(this, "You don't have required permission", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


}