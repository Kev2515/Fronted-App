package com.example.netjob;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.netjob.Model.Servicio;


import java.util.List;

public class ServicioAdapter extends ArrayAdapter {

    Context context;
    int itemLayout;
    List<Servicio> servicios;

    public ServicioAdapter(@NonNull Context context, int resource, @NonNull List<Servicio> objects) {
        super(context, resource, objects);
        this.context = context;
        itemLayout = resource;
        servicios = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(itemLayout, parent, false);
        }

        TextView titulo = convertView.findViewById(R.id.titulo);
        titulo.setText(servicios.get(position).getTitulo());




        //ImageView image = convertView.findViewById(R.id.servicioImage);
        //image.setImageResource(servicios.get(position).getImage());


        return convertView;
    }
}
