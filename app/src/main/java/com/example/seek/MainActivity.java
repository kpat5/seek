package com.example.seek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonLogin;
    private Button buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin=(Button) findViewById(R.id.login_button);
        buttonRegister=(Button) findViewById(R.id.register_button);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });

    }
    public void openLogin(){
        Intent intent =new Intent(this, Login.class);
        startActivity(intent);
    }
    public void openRegister(){
        Intent intent =new Intent(this, Register.class);
        startActivity(intent);
    }

}