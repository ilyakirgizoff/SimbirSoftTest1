package com.focaink.simbirsofttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;
import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private List<Note> rvList;
    private LayoutInflater rvInflater;
    //private AdapterView.OnItemClickListener rvClickListener;

    RvAdapter(List<Note> data){

        this.rvList = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.ViewHolder holder, int position) {
        String time = rvList.get(position).dateStart;
        String title = rvList.get(position).name;
        holder.time.setText(time);
        holder.title.setText(title);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return rvList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder /* implements View.OnClickListener*/{
        TextView time;
        TextView title;

        ViewHolder(View itemView){
            super(itemView);
            time = itemView.findViewById(R.id.time);
            title = itemView.findViewById(R.id.title);

            //itemView.setOnClickListener(this);
        }

       /* @Override
        public void onClick(View view) {
            if(rvClickListener != null) rvClickListener.onItemClick(view, getAdapterPosition());

        }*/
    }
/*
    String getItem(int id){
        return rvList.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener){
        this.rvClickListener = itemClickListener;
    }

    public interface ItemClickListener extends AdapterView.OnItemClickListener {
        void onItemClick(View view, int position);
    }*/


}
