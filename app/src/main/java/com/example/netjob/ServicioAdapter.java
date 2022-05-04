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

import com.example.netjob.Model.Servicios;


import java.util.List;

public class ServicioAdapter extends ArrayAdapter {

    Context context;
    int itemLayout;
    List<Servicios> servicios;

    public ServicioAdapter(@NonNull Context context, int resource, @NonNull List<Servicios> objects) {
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

        TextView linea1 = convertView.findViewById(R.id.linea1);
        linea1.setText(servicios.get(position).getTitulo());

        TextView linea2 = convertView.findViewById(R.id.linea2);
        linea2.setText(servicios.get(position).getDescripcion());


        ImageView image = convertView.findViewById(R.id.servicioImage);
        image.setImageResource(servicios.get(position).getImage());


        return convertView;
    }
}
