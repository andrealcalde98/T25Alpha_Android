package cat.copernic.rehabilitat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class BDAdaptador extends RecyclerView.Adapter<BDAdaptador.ViewHolder> {

   public static class ViewHolder extends RecyclerView.ViewHolder{
       private TextView tUsuari,tCorreu,tSexe,tEdad,tAltura,tPassword;
       public ViewHolder(View v){
           super(v);
           tUsuari =(TextView)v.findViewById(R.id.tvUsuari);
           tCorreu = (TextView)v.findViewById(R.id.tvCorreu);
           tSexe =(TextView)v.findViewById(R.id.tvSexe);
           tEdad = (TextView)v.findViewById(R.id.tvEdad);
           tAltura =(TextView)v.findViewById(R.id.tvAltura);
           tPassword=(TextView)v.findViewById(R.id.tvPassword);
       }
   }

   public List<BDModelo> listabd;

   public BDAdaptador(List<BDModelo> listabd){
       this.listabd = listabd;
   }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bd,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tUsuari.setText(listabd.get(position).getUsuari());
        holder.tCorreu.setText(listabd.get(position).getCorreo());
        holder.tSexe.setText(listabd.get(position).getSexe());
        holder.tEdad.setText(listabd.get(position).getEdad());
        holder.tAltura.setText(listabd.get(position).getAltura());
        holder.tPassword.setText(listabd.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        return listabd.size();
    }
}
