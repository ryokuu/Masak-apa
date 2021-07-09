package com.nooryoku.masakapa;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {
    private ArrayList<DataMasakan> mDataMasakan;

    static class myViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_judulMasakan;


        public myViewHolder(View itemView) {
            super(itemView);
            tv_judulMasakan = itemView.findViewById(R.id.tv_judulMasakan);


        }
    }

    public RecyclerAdapter(ArrayList<DataMasakan> mDataMasakan){
        this.mDataMasakan = mDataMasakan;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_container, parent, false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        DataMasakan currentMasakan = mDataMasakan.get(position);

        holder.tv_judulMasakan.setText(currentMasakan.getmMasakan());
    }

    @Override
    public int getItemCount() {
        return (mDataMasakan == null ) ? 0 : mDataMasakan.size();
        //return (mDataMasakan.size());
    }


}
