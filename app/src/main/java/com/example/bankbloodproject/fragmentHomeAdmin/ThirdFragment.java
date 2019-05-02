package com.example.bankbloodproject.fragmentHomeAdmin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bankbloodproject.R;
import com.example.bankbloodproject.model.DonnerModel;
import com.example.bankbloodproject.model.patientModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {
    private PatientAdapterRecyclerView adapter;


    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_third, container, false);
        // Inflate the layout for this fragment
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference patient = reference.child("dooner").getRef();
        viewAllPatient(patient);
        stupRecyclerView(view);
        return view;    }
    private void stupRecyclerView(View view) {
        RecyclerView recycle = view.findViewById(R.id.recyclerView);
        GridLayoutManager mgr=new GridLayoutManager(getActivity(),1);
        recycle.setLayoutManager(mgr);
        adapter=new PatientAdapterRecyclerView(getContext());
        recycle.setAdapter(adapter);

    }
    private void viewAllPatient(DatabaseReference restaurants) {
        restaurants.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<patientModel> patientModelList=new ArrayList<>();
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child:children) {
                    patientModel childValue = child.getValue(patientModel.class);
                    patientModelList.add(childValue);
                }


                adapter.setDataSource(patientModelList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
