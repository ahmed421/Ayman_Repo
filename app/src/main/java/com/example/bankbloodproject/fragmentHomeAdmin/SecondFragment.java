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
public class SecondFragment extends Fragment {

    private DoonerAdapterRecyclerView adapter;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_second, container, false);
        // Inflate the layout for this fragment
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference dooner = reference.child("dooner").getRef();
        viewAllDooner(dooner);
        stupRecyclerView(view);
        return view;
    }
    private void stupRecyclerView(View view) {
        RecyclerView recycle = view.findViewById(R.id.recyclerView);
        GridLayoutManager mgr=new GridLayoutManager(getActivity(),1);
        recycle.setLayoutManager(mgr);
        adapter=new DoonerAdapterRecyclerView(getContext());
        recycle.setAdapter(adapter);

    }
    private void viewAllDooner(DatabaseReference restaurants) {
        restaurants.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<DonnerModel> doonerModelList=new ArrayList<>();
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child:children) {
                    DonnerModel childValue = child.getValue(DonnerModel.class);
                    doonerModelList.add(childValue);
                }


                adapter.setDataSource(doonerModelList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
