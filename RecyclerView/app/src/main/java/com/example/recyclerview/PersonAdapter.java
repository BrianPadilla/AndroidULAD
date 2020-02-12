package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>{

    private ArrayList<Person> people;

    ItemClicked activity;

    public interface ItemClicked{

        void OnItemClicked(int index);

    }

    public PersonAdapter(Context context, ArrayList<Person> people) {
        this.people = people;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imvPref;
        TextView txtName,txtSurname;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtSurname = itemView.findViewById(R.id.txtSurname);
            imvPref = itemView.findViewById(R.id.imvPref);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.OnItemClicked(people.indexOf((Person) v.getTag()));

                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {

        holder.itemView.setTag(people.get(position));
        holder.txtName.setText(people.get(position).getName());
        holder.txtSurname.setText(people.get(position).getSurname());

        if(people.get(position).getPreference().equals("bus")){

                holder.imvPref.setImageResource(R.drawable.bus);
        }

        else{

            holder.imvPref.setImageResource(R.drawable.plane);
        }

    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
