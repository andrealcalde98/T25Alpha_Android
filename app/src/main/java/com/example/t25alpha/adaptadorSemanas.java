package com.example.t25alpha;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adaptadorSemanas extends RecyclerView.Adapter<adaptadorSemanas.ViewHolderDatos> {
    private ArrayList<Semanas> items;

    public adaptadorSemanas(ArrayList<Semanas> items) {
        this.items = items;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolderDatos(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_semanas, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        Semanas semana = items.get(position);
        holder.imgSemanas.setImageResource(semana.getImagen());
        holder.tvNombre.setText(semana.getNombre());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolderDatos extends RecyclerView.ViewHolder {

        ImageView imgSemanas;
        TextView tvNombre;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            imgSemanas = (ImageView) itemView.findViewById(R.id.imgSemana);
            tvNombre = (TextView) itemView.findViewById(R.id.idSemana);
        }
    }
}