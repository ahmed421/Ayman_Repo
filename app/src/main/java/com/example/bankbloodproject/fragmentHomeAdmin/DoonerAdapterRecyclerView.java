package com.example.bankbloodproject.fragmentHomeAdmin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bankbloodproject.R;
import com.example.bankbloodproject.model.DonnerModel;

import java.util.List;

public class DoonerAdapterRecyclerView extends RecyclerView.Adapter<DoonerAdapterRecyclerView.DoonerAdapterRecyclerViewHolder> {
    private List<DonnerModel> donnerModels;
    private Context context;

    public DoonerAdapterRecyclerView(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public DoonerAdapterRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new DoonerAdapterRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_dooner,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DoonerAdapterRecyclerViewHolder doonerAdapterRecyclerViewHolder, int i) {

        DonnerModel donnerModel=donnerModels.get(i);
        doonerAdapterRecyclerViewHolder.txtname.setText(donnerModel.getName());
        doonerAdapterRecyclerViewHolder.txtAge.setText(donnerModel.getAge());
        doonerAdapterRecyclerViewHolder.txtBloodGroup.setText(donnerModel.getGender());
        doonerAdapterRecyclerViewHolder.txtcity.setText(donnerModel.getAddress());

    }

    @Override
    public int getItemCount() {
        return donnerModels!=null?donnerModels.size():0;
    }

    public void setDataSource(List<DonnerModel> doonerModelList) {
this.donnerModels=doonerModelList;
    }

    class DoonerAdapterRecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView txtname,txtAge,txtBloodGroup,txtcity;
public DoonerAdapterRecyclerViewHolder(View view){
    super(view);
        txtname=itemView.findViewById(R.id.tvNameDooner);
        txtname=itemView.findViewById(R.id.tvAgeDooner);
        txtname=itemView.findViewById(R.id.tvBloodGroup);
        txtname=itemView.findViewById(R.id.tvcity);


}

    }
}
