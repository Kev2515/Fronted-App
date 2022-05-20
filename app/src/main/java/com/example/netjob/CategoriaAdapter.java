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

import java.util.Base64;
import java.util.List;

public class CategoriaAdapter extends ArrayAdapter {

    Context context;
    int itemLayout;
    List<Categoria> categorias;

    public CategoriaAdapter(@NonNull Context context, int resource, @NonNull List<Categoria> objects) {
        super(context, resource, objects);
        this.context = context;
        itemLayout = resource;
        categorias = objects;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(itemLayout, parent, false);
        }


        TextView name = convertView.findViewById(R.id.categoriaName);
        name.setText(categorias.get(position).getName());


        ImageView image = convertView.findViewById(R.id.categoriaImage);
        byte [] bytes = Base64.getDecoder().decode(categorias.get(position).getImage());
        Bitmap decodedByte = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        image.setImageBitmap(decodedByte);



        return convertView;
    }
}
