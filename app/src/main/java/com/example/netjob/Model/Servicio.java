package com.example.netjob.Model;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class Servicio {

    String titulo;
    String descripcion;
    Categoria[] categorias;
    int image;

    public Categoria[] getCategoria() {
        return categorias;
    }

    public void setCategoria(Categoria[] categoria) {
        this.categorias = categorias;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Servicio(String titulo, String descripcion, int image) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.image = image;
    }
}
