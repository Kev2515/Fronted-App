package com.example.netjob.Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.netjob.R;

import java.util.List;

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

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(this.destacados.get(position));
    }

    @Override
    public int getItemCount() {
        return this.destacados.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.destacadoImage);
            this.name = itemView.findViewById(R.id.destacadoName);

        }

        public void setItem(final Servicio servicio) {

            image.setImageResource(servicio.getImage());
            name.setText(servicio.getLinea1());

        }
    }
}
