package com.example.bankbloodproject.auth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bankbloodproject.Home.HomeActivity;
import com.example.bankbloodproject.R;
import com.example.bankbloodproject.model.DonnerModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private DatabaseReference mFirebaseDatabase;
    private FirebaseAuth auth;
    private Button register;
    private TextView txtreg,txtbldgrp,txtgen;

    private EditText name,email,contact,passwd;



    private Spinner blgrp;
    private ProgressBar mprogress;
    private RadioGroup radioGroupgen;
    private RadioButton gender;
    private CheckBox donCheck;
    private String strDonor,strgender="";
    RadioButton malerb,femalerb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mFirebaseDatabase =  FirebaseDatabase.getInstance().getReference().child("users");
        name = (EditText) findViewById(R.id.editName);
        contact = (EditText) findViewById(R.id.editCont);
        register = (Button) findViewById(R.id.btnReg2);
        blgrp = (Spinner) findViewById(R.id.spinnerBlg);
        passwd = (EditText) findViewById(R.id.editPassreg);
        email = (EditText) findViewById(R.id.editEmail);
        radioGroupgen = (RadioGroup) findViewById(R.id.radioGen);
        malerb=findViewById(R.id.maleradioButtonm);
        femalerb=findViewById(R.id.femaleradioButtonf);

        txtbldgrp = (TextView) findViewById(R.id.txtBldgrp);
        auth = FirebaseAuth.getInstance();
        mprogress = (ProgressBar) findViewById(R.id.progressBarreg);
        donCheck = (CheckBox) findViewById(R.id.donor_check);

    }

    public void signUp(View view) {
        register();
    }

    private void register() {
        List<DonnerModel> DonnerModelList=new ArrayList<>();

        final String namel = name.getText().toString().trim();
        final String mobile1 = contact.getText().toString().trim();
        final String emaill = email.getText().toString().trim();
        final String paswdl = passwd.getText().toString().trim();
        final String bloodl = blgrp.getSelectedItem().toString().trim();
//        int genid = radioGroupgen.getCheckedRadioButtonId();

//        final String genderl= gender.getText().toString();


        boolean check = donCheck.isChecked();


        if(donCheck.isChecked())
        {
            strDonor = "Yes";
        }
        else
        {
            strDonor = "No";
        }



        if (malerb.isChecked())
        {
            strgender="male";
        }
        else if (femalerb.isChecked())
        {
            strgender="female";
        }


        if (TextUtils.isEmpty(namel) && TextUtils.isEmpty(mobile1) && TextUtils.isEmpty(emaill) && TextUtils.isEmpty(paswdl)) {
            Toast.makeText(RegisterActivity.this, "Please fill all the details.", Toast.LENGTH_SHORT).show();
        }

        else
        {

            DonnerModel donnerModel=new DonnerModel(namel,mobile1,emaill,paswdl,bloodl,strDonor,strgender);
            mFirebaseDatabase.child("user").child(DonnerModelList.size()+"").push().setValue(donnerModel);
        }






















//        String email = emailText.getText().toString().trim();
//        String pass = passText.getText().toString().trim();
//        String pass1 = pass1Text.getText().toString().trim();
//        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass) && TextUtils.equals(pass, pass1)) {
//            mauth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if (task.isSuccessful()){
//                        startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
//                        Toast.makeText(RegisterActivity.this, "Regester success", Toast.LENGTH_SHORT).show();}
//                    else {
//                        Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//
//                }
//            });
//
//        }
    }

}
