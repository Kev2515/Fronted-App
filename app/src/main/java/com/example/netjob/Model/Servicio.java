package com.example.netjob.Model;

public class Servicio {

    String titulo;
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




}
