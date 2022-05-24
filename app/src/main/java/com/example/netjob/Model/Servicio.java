package com.example.netjob.Model;

public class Servicio {

    String titulo;
    String descripcion;
    Categoria[] categorias;

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
}
