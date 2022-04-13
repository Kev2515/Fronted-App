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

import com.example.netjob.Model.Contrato;


import java.util.List;

public class ContratoAdapter extends ArrayAdapter {

    Context context;
    int itemLayout;
    List<Contrato> contratos;

    public ContratoAdapter(@NonNull Context context, int resource, @NonNull List<Contrato> objects) {
        super(context, resource, objects);
        this.context = context;
        itemLayout = resource;
        contratos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(itemLayout, parent, false);
        }

        TextView linea1 = convertView.findViewById(R.id.linea5);
        linea1.setText(contratos.get(position).getLinea1());

        TextView linea2 = convertView.findViewById(R.id.linea6);
        linea2.setText(contratos.get(position).getLinea2());


        ImageView image = convertView.findViewById(R.id.contratoImage);
        image.setImageResource(contratos.get(position).getImage());


        return convertView;
    }
}
