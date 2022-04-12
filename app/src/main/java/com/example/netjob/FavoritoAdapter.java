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

import com.example.netjob.Model.Favorito;


import java.util.List;

public class FavoritoAdapter extends ArrayAdapter {

    Context context;
    int itemLayout;
    List<Favorito> favoritos;

    public FavoritoAdapter(@NonNull Context context, int resource, @NonNull List<Favorito> objects) {
        super(context, resource, objects);
        this.context = context;
        itemLayout = resource;
        favoritos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(itemLayout, parent, false);
        }

        TextView linea1 = convertView.findViewById(R.id.linea1);
        linea1.setText(favoritos.get(position).getLinea1());

        TextView linea2 = convertView.findViewById(R.id.linea2);
        linea2.setText(favoritos.get(position).getLinea2());


        ImageView image = convertView.findViewById(R.id.favoritoImage);
        image.setImageResource(favoritos.get(position).getImage());


        return convertView;
    }
}
