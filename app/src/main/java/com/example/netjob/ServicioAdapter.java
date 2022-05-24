package com.example.netjob;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.netjob.Model.Categoria;
import com.example.netjob.Model.Servicio;


import java.util.Base64;
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(itemLayout, parent, false);
        }

        TextView titulo = convertView.findViewById(R.id.titulo);
        titulo.setText(servicios.get(position).getTitulo());

        TextView descripcion = convertView.findViewById(R.id.descripcionServicio);
        descripcion.setText(servicios.get(position).getDescripcion());

        ImageView imagen = convertView.findViewById(R.id.servicioImage);
        Categoria[] categorias = servicios.get(position).getCategoria();
        if (categorias.length > 0) {
            byte[] bytes = Base64.getDecoder().decode(servicios.get(position).getCategoria()[0].getImage());
            Bitmap decodedByte = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            imagen.setImageBitmap(decodedByte);
        }


        return convertView;
    }
}
