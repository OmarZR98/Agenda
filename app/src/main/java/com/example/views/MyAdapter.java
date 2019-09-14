package com.example.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Contacto> listContactos;

    public MyAdapter(ArrayList<Contacto> listContactos) {
        this.listContactos = listContactos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v =
                LayoutInflater.from(parent.getContext()).inflate
                        (R.layout.item_list,null,false);
        return new MyViewHolder(v);

    }


    @Override
    public void onBindViewHolder
            (@NonNull MyViewHolder holder, int position) {

        holder.txtEmail.setText(listContactos.get(position).getEmail());
        holder.txtUsuario.setText(listContactos.get(position).getUsuario());
        holder.txtTwiter.setText(listContactos.get(position).getTwiter());
        holder.txtTel.setText(listContactos.get(position).getTel());
        holder.txtFechaNac.setText(listContactos.get(position).getFechaNac());
    }

    @Override
    public int getItemCount() {
        return listContactos.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        EditText txtEmail, txtUsuario, txtTwiter, txtTel, txtFechaNac;
        public MyViewHolder(View v) {
            super(v);
            txtEmail= v.findViewById(R.id.idEmail);
            txtUsuario=v.findViewById(R.id.idUsuario);
            txtTwiter=v.findViewById(R.id.idTwiter);
            txtTel=v.findViewById(R.id.idTelefono);
            txtFechaNac=v.findViewById(R.id.idFechaNac);

        }
    }




}
