package cat.copernic.rehabilitat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class adaptadorSemanas extends RecyclerView.Adapter<adaptadorSemanas.ViewHolderDatos> {
    private ArrayList<Semanas> items;
    private Context context;


    public adaptadorSemanas(ArrayList<Semanas> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(
               R.layout.list_semanas, viewGroup, false);
       ViewHolderDatos viewHolderDatos = new ViewHolderDatos(view);
       return viewHolderDatos;

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

    class ViewHolderDatos extends RecyclerView.ViewHolder{
        ImageView imgSemanas;
        TextView tvNombre;


        public ViewHolderDatos(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Intent intent = new Intent(context, Dias.class);
                        context.startActivity(intent);

                }
            });
            imgSemanas = (ImageView) itemView.findViewById(R.id.imgSemana);
            tvNombre = (TextView) itemView.findViewById(R.id.idSemana);


        }

        }
    }
