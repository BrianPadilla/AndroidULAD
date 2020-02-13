package com.example.fragmentswithrecyclerviewchallenge;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarroAdapter extends RecyclerView.Adapter<CarroAdapter.ViewHolder> {

    private ArrayList<Carro> carro;
    ItemClicked activity;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public CarroAdapter(Context context, ArrayList<Carro> carro) {
        this.carro = carro;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView lblCardModelo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lblCardModelo = itemView.findViewById(R.id.lblCardModelo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.onItemClicked(carro.indexOf((Carro)v.getTag()));

                }
            });

        }

    }

            @NonNull
            @Override
            public CarroAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent,
            int viewType){
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_cardview_contenedor,parent,false);
                return new ViewHolder(view);
            }

            @Override
            public void onBindViewHolder (@NonNull CarroAdapter.ViewHolder holder,int position){

        holder.itemView.setTag(carro.get(position));
        holder.lblCardModelo.setText(carro.get(position).getDueño());


            }

            @Override
            public int getItemCount () {
                return carro.size();
            }
        }
