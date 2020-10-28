package com.example.ejerciciofragmentrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterContacto extends RecyclerView.Adapter<AdapterContacto.HolderContacto> {

    ArrayList<Contactos> contactos;
    LayoutInflater inflater;

    public AdapterContacto(ArrayList<Contactos> contactos, Context context) {
        this.contactos = contactos;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HolderContacto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista= inflater.inflate(R.layout.item_list,parent,false);


        return new HolderContacto(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderContacto holder, int position) {
        String nombre= contactos.get(position).getNombre();
        String direcion=contactos.get(position).getDireccion();
        String telefono=contactos.get(position).getTelefono();
        int imagen=contactos.get(position).getImagen();
        holder.nombres.setText(nombre);
        holder.direcciones.setText(direcion);
        holder.telefonos.setText(telefono);
        holder.imagenes.setImageResource(imagen);

    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public class HolderContacto extends RecyclerView.ViewHolder {
        TextView nombres,direcciones,telefonos;
        ImageView imagenes;
        public HolderContacto(@NonNull View itemView) {
            super(itemView);
            nombres=(TextView)itemView.findViewById(R.id.tvNombre);
            direcciones=(TextView)itemView.findViewById(R.id.tvDireccion);
            telefonos=(TextView)itemView.findViewById(R.id.tvTelefono);
            imagenes=(ImageView)itemView.findViewById(R.id.imagen);
        }
    }
}
