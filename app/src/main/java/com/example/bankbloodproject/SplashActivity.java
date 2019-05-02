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
//                                                  if (uid.equals("S17BXDZNiRd8N7fKuLK9DFhcC8g1")) {
//
//                                                      Intent intentAuth = new Intent(SplashActivity.this, HomeAdmin.class);
//                                                      //intentAuth.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                                                      startActivity(intentAuth);
//                                                      finish();
//
//                                                  } else {
//
//                                                      Intent intentAuth = new Intent(SplashActivity.this, HomeActivity.class);
//                                                      // intentAuth.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                                                      startActivity(intentAuth);
//                                                      finish();
//                                                  }
//
//
////                if (currentUser==null){
//////                    if (uid == "lNdli3tSqbdCM7WHiLzugD6YKk02") {
//////                        startActivity(new Intent(SplashActivity.this, HomeAdmin.class));
//////                    }else
////                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
////
////                }else
////                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
////                    finish();
//
//
//                                              }
//                                          }
                                      }
                                  }
                ,2000);
    }}

