package com.example.bankbloodproject.Home;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.bankbloodproject.R;
import com.example.bankbloodproject.auth.LoginActivity;
import com.example.bankbloodproject.fragmentHomeAdmin.FirstFragment;
import com.example.bankbloodproject.fragmentHomeAdmin.SecondFragment;
import com.example.bankbloodproject.fragmentHomeAdmin.ThirdFragment;
import com.example.bankbloodproject.model.AdminDataModel;
import com.example.bankbloodproject.model.DonnerModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeAdmin extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DatabaseReference reference;
    private FirebaseAuth firebaseAuth;
    private EditText nameText,ageText,genderText,bloodGroupText,addressText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowAddDoonerDialog();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void ShowAddDoonerDialog() {

        AlertDialog.Builder builder=new AlertDialog.Builder(HomeAdmin.this);
        builder.setView(R.layout.add_donner_dialog).setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SaveDataBase();
            }
        });
        AlertDialog dialog = builder.show();
        nameText=dialog.findViewById(R.id.editText4);
        ageText=dialog.findViewById(R.id.editText5);
        genderText=dialog.findViewById(R.id.editText6);
        bloodGroupText=dialog.findViewById(R.id.editText7);
        addressText=dialog.findViewById(R.id.editText8);

    }
    private void SaveDataBase() {
        String name=nameText.getText().toString();
        String age=nameText.getText().toString();
        String gender=nameText.getText().toString();
        String address=nameText.getText().toString();
        if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(age)&&!TextUtils.isEmpty(gender)  &&
                !TextUtils.isEmpty(address)){
            List<DonnerModel>donnerModels=new ArrayList<>();

            DonnerModel donnerModel =new DonnerModel(name,address,gender,age);
            reference.child("dooner").child(donnerModels.size()+" ").push().setValue(donnerModel);

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_admin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;
        Class fragmentClass = null;

        switch (item.getItemId()){
            case R.id.nav_profile:
                fragmentClass = FirstFragment.class;

                break;
            case R.id.nav_bloodrequest:
                fragmentClass = SecondFragment.class;

                break;
                case R.id.nav_donner:
                    fragmentClass = SecondFragment.class;

                    break;

                case R.id.patient:
                    fragmentClass = ThirdFragment.class;

                    break;

                case R.id.nav_signpout:
                    firebaseAuth.signOut();
                    startActivity(new Intent(HomeAdmin.this, LoginActivity.class));
                    finish();


                    break;
            default:
                fragmentClass = FirstFragment.class;



    }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        item.setChecked(true);
        // Set action bar title
        setTitle(item.getTitle());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
