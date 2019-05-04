package com.example.bankbloodproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bankbloodproject.Home.HomeActivity;
import com.example.bankbloodproject.Home.HomeAdmin;
import com.example.bankbloodproject.auth.LoginActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private String uid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        auth = FirebaseAuth.getInstance();


        // final String uid = currentUser.getUid();
        final FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          startActivity(new Intent(SplashActivity.this, LoginActivity.class));
//                                          if (auth.getCurrentUser() != null) {
//
//                                              if (currentUser != null) {
//
//                                                  uid = currentUser.getUid();
//
//
//                                                  if (uid.equals("XzQyFGL8VVUYBuZCeQpmTg3iMF32")) {
//
//                                                      Intent intentAuth = new Intent(SplashActivity.this, HomeAdmin.class);
//                                                      startActivity(intentAuth);
//                                                      finish();
//
//                                                  } else {
//
//                                                      Intent intentAuth = new Intent(SplashActivity.this, HomeActivity.class);
//                                                      startActivity(intentAuth);
//                                                      finish();
//                                                  }
//
//
//                                              }
//                                          }
                                      }
                                  }
                ,2000);
    }}

