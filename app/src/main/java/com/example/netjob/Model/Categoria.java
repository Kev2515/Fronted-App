package com.example.netjob.Model;

public class Categoria {

    String nombre;
    String imagen;

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = name;
    }

    public String getImage() {
        return imagen;
    }

    public void setImage(String image) {
        this.imagen = image;
    }

    public Categoria(String name, String image) {
        this.nombre = name;
        this.imagen = image;
    }
}


