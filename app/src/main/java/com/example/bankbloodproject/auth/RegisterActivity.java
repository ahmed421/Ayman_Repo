package com.example.bankbloodproject.auth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bankbloodproject.Home.HomeActivity;
import com.example.bankbloodproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth mauth;
    EditText emailText, passText, pass1Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
         mauth = FirebaseAuth.getInstance();
        emailText = findViewById(R.id.etEmail);
        passText = findViewById(R.id.etpass1);
        pass1Text = findViewById(R.id.etPass2);
        TextView textView = findViewById(R.id.tvLogin);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });


    }

    public void signUp(View view) {
        register();
    }

    private void register() {

        String email = emailText.getText().toString().trim();
        String pass = passText.getText().toString().trim();
        String pass1 = pass1Text.getText().toString().trim();
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass) && TextUtils.equals(pass, pass1)) {
            mauth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                        Toast.makeText(RegisterActivity.this, "Regester success", Toast.LENGTH_SHORT).show();}
                    else {
                        Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
    }

}
