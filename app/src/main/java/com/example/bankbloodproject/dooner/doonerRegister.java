package com.example.bankbloodproject.dooner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.bankbloodproject.R;
import com.example.bankbloodproject.model.DonnerModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class doonerRegister extends AppCompatActivity {
    EditText name_patienttxt,national_numbertxt,passwordtxt,gendertxt,agetxt,phone_numbertxt,addresstxt,time_to_connecttxt,
    donate_persontxt,date_donate_timetxt,blood_groupstxt;
    RadioButton radioButton1,radioButton2,radioButton3,radioButton4;
    Button blood_groups,save;
    DatabaseReference reference;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        reference= FirebaseDatabase.getInstance().getReference();
        //text
        setContentView(R.layout.activity_dooner_register);
        name_patienttxt=findViewById(R.id.name_donertxt);
        national_numbertxt=findViewById(R.id.national_numbertxt);
        passwordtxt=findViewById(R.id.passwordtxt);
        gendertxt=findViewById(R.id.gendertxt);
        agetxt=findViewById(R.id.agetxt);
        phone_numbertxt=findViewById(R.id.phone_numbertxt);
        addresstxt=findViewById(R.id.addresstxt);
        time_to_connecttxt=findViewById(R.id.time_to_connecttxt);
        donate_persontxt=findViewById(R.id.donate_persontxt);
        date_donate_timetxt=findViewById(R.id.date_donate_timetxt);

        //radio
        //radioButton1=findViewById(R.id.radioButton5);
        radioButton2=findViewById(R.id.radioButton6);
        //radioButton3=findViewById(R.id.radioButton7);
        radioButton4=findViewById(R.id.radioButton8);
        //button
        blood_groups=findViewById(R.id.btnBloodType);
        save=findViewById(R.id.btnSaveDooner);

        if (radioButton2.isChecked())
        {
            donate_persontxt.setVisibility(View.INVISIBLE);
            TextView textView=findViewById(R.id.textView17);
            textView.setVisibility(View.INVISIBLE);

        }
        else if (radioButton4.isChecked())
        {
            date_donate_timetxt.setVisibility(View.INVISIBLE);
            TextView textView=findViewById(R.id.textView170);
            textView.setVisibility(View.INVISIBLE);

        }
       /* blood_groups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });*/
       save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               List<DonnerModel> DonnerModelList=new ArrayList<>();
               String name = name_patienttxt.getText().toString();
               String national_number = national_numbertxt.getText().toString();
               String password = passwordtxt.getText().toString();
               String gender = gendertxt.getText().toString();
               String age = agetxt.getText().toString();
               String phone_number = phone_numbertxt.getText().toString();
               String address = addresstxt.getText().toString();
               String time_available = time_to_connecttxt.getText().toString();
               String donate_name = donate_persontxt.getText().toString();
               String date_donate = date_donate_timetxt.getText().toString();
               if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(national_number)&&!TextUtils.isEmpty(password)&&!TextUtils.isEmpty(gender)&&

               !TextUtils.isEmpty(age)&&!TextUtils.isEmpty(phone_number)&&!TextUtils.isEmpty(address)&&!TextUtils.isEmpty(time_available)

               &&!TextUtils.isEmpty(donate_name)&& !TextUtils.isEmpty(date_donate))
               {
                   DonnerModel donnerModel=new DonnerModel(name,national_number,password,gender,age,phone_number,address,time_available,donate_name
                   ,date_donate);
                   reference.child("donner").child(DonnerModelList.size()+"").push().setValue(donnerModel);

               }


           }
       });




    }
}
