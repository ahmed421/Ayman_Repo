package com.example.bankbloodproject.auth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bankbloodproject.Home.HomeAdmin;
import com.example.bankbloodproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginAdminActivity extends AppCompatActivity {
    DatabaseReference reference;
    EditText name,password;
    Button login_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
      name=findViewById(R.id.etEmail);
      
      password=findViewById(R.id.etpass1);
      
        login_admin=findViewById(R.id.btnLogin);
      login_admin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String email = name.getText().toString();
              String pass = password.getText().toString();
              if (!TextUtils.isEmpty(email)&& !TextUtils.isEmpty(pass))
              {
                  checkdataFromFireBase(email,pass);
              }





          }
      });

    }

    private void checkdataFromFireBase(final String email, final String pass) {
        reference=FirebaseDatabase.getInstance().getReference().child("admin").child("1");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String Firename = dataSnapshot.child("email").getValue().toString();
                String Firepass= dataSnapshot.child("password").getValue().toString();
                if (email.equals(Firename)&&pass.equals(Firepass))
                {
                   startActivity(new Intent(LoginAdminActivity.this, HomeAdmin.class));
                }
                else
                {
                    Toast.makeText(LoginAdminActivity.this, "Invalid Admin", Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
