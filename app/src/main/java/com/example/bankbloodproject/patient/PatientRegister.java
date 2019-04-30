package com.example.bankbloodproject.patient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bankbloodproject.R;
import com.example.bankbloodproject.model.patientModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class PatientRegister extends AppCompatActivity {
    EditText nametxt ,addresstxt,hospitaltxt,agetxt,gendertxt,nationalNumbertxt ,telephonetxt;
    private DatabaseReference firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_register);
         firebaseDatabase=FirebaseDatabase.getInstance().getReference();

        nametxt=findViewById(R.id.etPatientName);
        addresstxt=findViewById(R.id.etAddress);
        hospitaltxt=findViewById(R.id.ethospital);
        agetxt=findViewById(R.id.etPatientAge);
        nationalNumbertxt=findViewById(R.id.etNatoinalNumber);
        telephonetxt=findViewById(R.id.etPhoneNumber);
        gendertxt=findViewById(R.id.etGender);
        Button btnSave=findViewById(R.id.btnBank);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<patientModel>patientModelList=new ArrayList<>();
                String name = nametxt.getText().toString();
                String address = addresstxt.getText().toString();
                String hos = hospitaltxt.getText().toString();
                String age = agetxt.getText().toString();
                String gender = gendertxt.getText().toString();
                String nationalNumber = nationalNumbertxt.getText().toString();
                String telephone = telephonetxt.getText().toString();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(address) && !TextUtils.isEmpty(hos) && !TextUtils.isEmpty(age) &&
                        !TextUtils.isEmpty(gender) && !TextUtils.isEmpty(nationalNumber) && !TextUtils.isEmpty(telephone)  ){
                    patientModel patientModel=new patientModel(name,address,age,hos,gender,telephone,nationalNumber);
                    firebaseDatabase.child("patient").child(patientModelList.size()+"").push().setValue(patientModel);
                }
            }
        });
    }
}
