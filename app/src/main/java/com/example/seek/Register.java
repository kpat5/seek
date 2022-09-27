package com.example.seek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    private EditText inputName,inputPhone,inputEmail,inputPassword,inputCpass;
    private Button regBtn;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputEmail =findViewById(R.id.inputEmail);
        inputName =findViewById(R.id.inputName);
        inputPhone =findViewById(R.id.inputPhone);
        inputPassword =findViewById(R.id.inputPassword);
        inputCpass =findViewById(R.id.inputCpass);
        regBtn=findViewById(R.id.regBtn);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

    regBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            PerformAuth();
        }
    });
    }

    private void PerformAuth() {
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();
        String confirmPassword=inputCpass.getText().toString();
        String name=inputName.getText().toString();
        String phone=inputPhone.getText().toString();


        if (!email.matches(emailPattern))
        {
            inputEmail.setError("Enter Correct Email");
        }else if (password.isEmpty() || password.length()<8){
            inputPassword.setError("Enter proper password");
        }else if (!password.equals(confirmPassword)){
            inputCpass.setError("Password not match both field");
        }else if (name.isEmpty() ) {
            inputName.setError("Enter proper name");
        }else if (phone.isEmpty() || phone.length()<10) {
            inputName.setError("Enter proper phone number");
        }else {
           progressDialog.setMessage("Please wait while Registration...");
           progressDialog.setTitle("Registration");
           progressDialog.setCanceledOnTouchOutside(false);
           progressDialog.show();

           mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   if (task.isSuccessful()){
                       progressDialog.dismiss();
                       sendUserToNextActivity();
                       Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                   }else {
                       progressDialog.dismiss();
                       Toast.makeText(Register.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                   }
               }
           });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent=new Intent(Register.this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}