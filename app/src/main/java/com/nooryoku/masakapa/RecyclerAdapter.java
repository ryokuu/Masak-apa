package com.nooryoku.masakapa;


import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
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
    private Context mContext;

    static class myViewHolder extends RecyclerView.ViewHolder {
        TextView tv_judulMasakan, tv_tanggal;
        CardView cardView;


        public myViewHolder(View itemView) {
            super(itemView);
            tv_judulMasakan = itemView.findViewById(R.id.tv_judulMasakan);
            tv_tanggal = itemView.findViewById(R.id.tv_tanggal);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }

    public RecyclerAdapter(ArrayList<DataMasakan> mDataMasakan, Context mContext){
        this.mDataMasakan = mDataMasakan;
        this.mContext = mContext;
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
        holder.tv_tanggal.setText(currentMasakan.getmTanggal());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ItemDetailActivity.class);
                intent.putExtra("judul", currentMasakan.getmMasakan());
                intent.putExtra("tanggal", currentMasakan.getmTanggal());
                intent.putExtra("bahan", currentMasakan.getmBahanUtama());
                intent.putExtra("rempah", currentMasakan.getmRempah());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (mDataMasakan == null ) ? 0 : mDataMasakan.size();
        //return (mDataMasakan.size());
    }


}
