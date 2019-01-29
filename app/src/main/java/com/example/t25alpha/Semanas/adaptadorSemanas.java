package com.example.t25alpha.Semanas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.t25alpha.R;

import java.util.ArrayList;

public class adaptadorSemanas extends RecyclerView.Adapter<adaptadorSemanas.ViewHolderDatos> {
    public adaptadorSemanas(ArrayList<String> listaDatos) {
        this.listaDatos = listaDatos;
    }

    ArrayList<String> listaDatos;

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_semanas,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int i) {
viewHolderDatos.asignarDatos(listaDatos.get(i));
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView semana;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            semana = itemView.findViewById(R.id.idSemana);
        }

        public void asignarDatos(String s) {
            semana.setText(s);
        }
    }
}
