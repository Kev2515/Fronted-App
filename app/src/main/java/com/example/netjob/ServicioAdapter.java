package com.example.netjob;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;

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

        EditText linea1 = convertView.findViewById(R.id.linea1);
        linea1.setText(servicios.get(position).getLinea1());

        EditText linea2 = convertView.findViewById(R.id.linea2);
        linea1.setText(servicios.get(position).getLinea2());


        ImageView image = convertView.findViewById(R.id.servicioImage);
        image.setImageResource(servicios.get(position).getImage());


        return convertView;
    }
}
