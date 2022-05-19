package com.example.netjob.Model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.netjob.R;

import java.util.Base64;
import java.util.List;

import javax.annotation.Nullable;

public class DestacadoAdapter extends RecyclerView.Adapter<DestacadoAdapter.ViewHolder> {
    private List<Servicio> destacados;


    public DestacadoAdapter(List<Servicio> destacados) {
        this.destacados = destacados;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.destacado, parent, false);
        return new ViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(this.destacados.get(position));
    }

    @Override
    public int getItemCount() {
        return this.destacados.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imagen;
        private final TextView titulo;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imagen = itemView.findViewById(R.id.destacadoImage);
            this.titulo = itemView.findViewById(R.id.destacadoName);
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void setItem(final Servicio servicio) {

            //byte [] bytes = Base64.getDecoder().decode(servicio.getImagen());
            //Bitmap decodedByte = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            //imagen.setImageBitmap(decodedByte);
            titulo.setText(servicio.getTitulo());

        }
    }
}
